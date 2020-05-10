import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import config.ConfigValues;
import config.IConfigReader;
import config.XmlConfigReader;
import core.ICategory;
import core.IDomain;
import core.IField;
import core.IRecord;
import core.ISubCategory;
import parser.ExcelFileParser;
import parser.IFileParser;
import stat.IRecorderCollection;
import stat.NumericRecordCollection;
import writer.ExcelWriter;
import writer.IWriter;

/**
 * 
 */

/**
 * @author ro6k4
 *
 */
public class TestMain {

	public static String DOMAIN_FOLDER = "dossier_test/";
	public static String RESULT_FOLDER = "resultat_test/";
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		IConfigReader reader = new XmlConfigReader();
		reader.init();
		
		
		ArrayList<IDomain> domains = reader.getDomains();
		ArrayList<ICategory> categories = reader.getCategories();
		ArrayList<ISubCategory> subCategories = reader.getSubCategories();
		
		
		IRecorderCollection globalCollection = new NumericRecordCollection();
		
		int nbDomains = domains.size();
		for(int i = 0; i < nbDomains; i++) {
			
			IDomain domain = domains.get(i);
			String domainName = domain.getName();
			IWriter writer = new ExcelWriter(RESULT_FOLDER + "" + domainName + ".xlsx");
			
			IRecorderCollection domainCollection = new NumericRecordCollection();
			
			String type = domain.getType();
			ArrayList<IField> fields = new ArrayList<IField>();
			ArrayList<IRecord> records = new ArrayList<IRecord>();
			
			IFileParser parser = new ExcelFileParser(domain, DOMAIN_FOLDER + domainName + ".xlsx");
			
			if(type.equalsIgnoreCase(ConfigValues.RAW.toString())) {
				fields = reader.getRawFields();
				records = parser.getRecordsPerSubCategory(subCategories, fields);
			}
			
			if(type.equalsIgnoreCase(ConfigValues.PREPROC.toString())) {
				fields = reader.getPreProcFields();
				records = parser.getRecordsPerCategory(categories, fields);
			}
						
			int nbRecords = records.size();
			for(int j = 0; j < nbRecords; j++) {
				IRecord record = records.get(j);
				domainCollection.addRecord(record);
				globalCollection.addRecord(record);
			}
			
			ArrayList<ArrayList<Object>> toWrite = new ArrayList<ArrayList<Object>>();
			toWrite.add(writer.getFieldNames(fields));
			
			writer.writeData(toWrite);
		}
		
	}

}