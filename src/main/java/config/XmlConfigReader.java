/**
 * 
 */
package config;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import core.Domain;
import core.ICategory;
import core.IDomain;
import core.IField;
import core.ISubCategory;
import core.XmlNodes;

/**
 * @author ro6k4
 *
 */
public class XmlConfigReader implements IConfigReader {

	private static final String configFile = "config/statgen_config.xml";
	private final DocumentBuilderFactory factory;
	private final DocumentBuilder builder;
	private final Document document;
	
	private ArrayList<IDomain> domains;
	private ArrayList<ICategory> categories;
	private ArrayList<ISubCategory> subcats;
	private ArrayList<IField> fields;
	
	public XmlConfigReader() throws ParserConfigurationException, SAXException, IOException {
		this.factory = DocumentBuilderFactory.newInstance();
		this.builder = factory.newDocumentBuilder();
		this.document = builder.parse(configFile);
		
		this.domains = new ArrayList<IDomain>();
		this.categories = new ArrayList<ICategory>();
		this.subcats = new ArrayList<ISubCategory>();
		this.fields = new ArrayList<IField>();
	}
	
	public void init() {
		Document doc = this.document;
		final Element config = (Element) doc.getElementsByTagName(XmlNodes.CONFIG.toString()).item(0);
		
		final Element domNodes = (Element) config.getElementsByTagName(XmlNodes.DOMAINS.toString());
		final NodeList domList = domNodes.getElementsByTagName(XmlNodes.DOMAIN.toString());
		int domLength = domList.getLength();
		for(int i = 0; i < domLength; i++) {
			final Element domNode = (Element) domList.item(i);
			final Element domNameElem = (Element) domNode.getElementsByTagName(XmlNodes.NAME.toString()).item(0);
			final Element domTypeElem = (Element) domNode.getElementsByTagName(XmlNodes.TYPE.toString()).item(0);
			
			String domName = domNameElem.getTextContent();
			String domType = domNameElem.getTextContent();
			
			IDomain domain = new Domain(domName, domType);
			this.domains.add(domain);
		}
		//TODO Extract categories, subcategories and fields as done above for domains
	}
	
	@Override
	public ArrayList<IDomain> getDomains() {
		return this.domains;
	}

	@Override
	public ArrayList<ICategory> getCategories() {
		return this.categories;
	}

	@Override
	public ArrayList<ISubCategory> getSubCategories() {
		return this.subcats;
	}

	@Override
	public ArrayList<IField> getFields() {
		return this.fields;
	}

}
