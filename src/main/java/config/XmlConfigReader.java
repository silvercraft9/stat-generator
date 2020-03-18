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

import core.Category;
import core.Domain;
import core.Field;
import core.ICategory;
import core.IDomain;
import core.IField;
import core.ISubCategory;
import core.SubCategory;
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
	
	private String domainFolder;
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
		
		//Recover the folder with all files containing records
		
		final NodeList domainFolderList = config.getElementsByTagName(XmlNodes.DOMFOLDER.toString());
		final Element domainFolderNode = (Element) domainFolderList.item(0);
		String domainFolderName = domainFolderNode.getTextContent();
		this.domainFolder = domainFolderName;
		
		//Recover all domains
		final Element domainNodes = (Element) config.getElementsByTagName(XmlNodes.DOMAINS.toString());
		final NodeList domainList = domainNodes.getElementsByTagName(XmlNodes.DOMAIN.toString());
		int domainLength = domainList.getLength();
		for(int i = 0; i < domainLength; i++) {
			final Element domainNode = (Element) domainList.item(i);
			final Element domainNameElem = (Element) domainNode.getElementsByTagName(XmlNodes.NAME.toString()).item(0);
			final Element domainTypeElem = (Element) domainNode.getElementsByTagName(XmlNodes.TYPE.toString()).item(0);
			
			String domainName = domainNameElem.getTextContent();
			String domainType = domainTypeElem.getTextContent();
			
			IDomain domain = new Domain(domainName, domainType);
			this.domains.add(domain);
		}
		
		//Recover all categories
		final Element categoriesNodes = (Element) config.getElementsByTagName(XmlNodes.CATS.toString());
		final NodeList categoriesList = categoriesNodes.getElementsByTagName(XmlNodes.CAT.toString());
		int categorieLength = categoriesList.getLength();
		for(int i = 0; i < categorieLength; i++) {
			final Element categorieNode = (Element) categoriesList.item(i);
			
			String categorieName = categorieNode.getTextContent();
			
			ICategory category = new Category(categorieName);
			this.categories.add(category);
		}
		
		//Recover all subcategories
		final Element subcatNodes = (Element) config.getElementsByTagName(XmlNodes.SUBCATS.toString());
		final NodeList subcatList = subcatNodes.getElementsByTagName(XmlNodes.SUBCAT.toString());
		int subcatLength = subcatList.getLength();
		for(int i = 0; i < subcatLength; i++) {
			final Element subcatNode = (Element) subcatList.item(i);
			final Element subcatNameElem = (Element) subcatNode.getElementsByTagName(XmlNodes.NAME.toString()).item(0);
			final Element subcatCategoryElem = (Element) subcatNode.getElementsByTagName(XmlNodes.CAT.toString()).item(0);
			
			String subcatName = subcatNameElem.getTextContent();
			String subcatCategory = subcatCategoryElem.getTextContent();
			
			ICategory category = new Category(subcatCategory);
			ISubCategory subCategory = new SubCategory(subcatName, category);
			
			this.subcats.add(subCategory);
		}
		
		//Recover all fields
		final Element fieldNodes = (Element) config.getElementsByTagName(XmlNodes.FIELDS.toString());
		final NodeList fieldList =  fieldNodes.getElementsByTagName(XmlNodes.FIELD.toString());
		int  fieldLength =  fieldList.getLength();
		for(int i = 0; i <  fieldLength; i++) {
			final Element  fieldNode = (Element) fieldList.item(i);
			final Element fieldNameElem = (Element) fieldNode.getElementsByTagName(XmlNodes.NAME.toString()).item(0);
			final Element fieldTypeElem = (Element) fieldNode.getElementsByTagName(XmlNodes.TYPE.toString()).item(0);
			final Element fieldRankElem = (Element) fieldNode.getElementsByTagName(XmlNodes.RANK.toString()).item(0);
			
			String fieldName = fieldNameElem.getTextContent();
			String fieldType = fieldTypeElem.getTextContent();
			Integer fieldRank = Integer.parseInt(fieldRankElem.getTextContent());
			
			IField field = new Field(fieldName, fieldType, fieldRank);
			
			this.fields.add(field);
		}
	}
	
	/**
	 * @return the folder including all domains
	 */
	public String getDomainFolder() {
		return domainFolder;
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
