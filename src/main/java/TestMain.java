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
		//Generating file for each domain with a category granularity
		for(int i = 0; i < nbDomains; i++) {
			
			IDomain domain = domains.get(i);
			String domainName = domain.getName();
			IWriter writer = new ExcelWriter(RESULT_FOLDER + "" + domainName + "_traité.xlsx");
			
			IRecorderCollection domainCollection = new NumericRecordCollection();
			
			String type = domain.getType();
			ArrayList<IField> fields = new ArrayList<IField>();
			ArrayList<IRecord> records = new ArrayList<IRecord>();
			
			IFileParser parser = new ExcelFileParser(domain, DOMAIN_FOLDER + domainName + ".xlsx");
			
			if(type.equalsIgnoreCase(ConfigValues.RAW.toString())) {
				fields = reader.getRawFields();
				//System.out.println("Raw fields : " + fields.size());
				records = parser.getRecordsPerSubCategory(subCategories, fields);
				//System.out.println("Records : " + records.size());
			}
			
			if(type.equalsIgnoreCase(ConfigValues.PREPROC.toString())) {
				fields = reader.getPreProcFields();
				//System.out.println("Preprocessed fields : " + fields.size());
				records = parser.getRecordsPerCategory(categories, fields);
				//System.out.println("Records : " + records.size());
			}
						
			int nbRecords = records.size();
			for(int j = 0; j < nbRecords; j++) {
				IRecord record = records.get(j);
				domainCollection.addRecord(record);
				globalCollection.addRecord(record);
				
			}
			
			ArrayList<ArrayList<Object>> toWrite = new ArrayList<ArrayList<Object>>();
			toWrite.add(writer.getFieldNames(fields));
			int nbCategories = categories.size();
			for(int k = 0; k < nbCategories; k++) {
				ArrayList<Object> line = new ArrayList<Object>();
				ICategory category = categories.get(k);
				line.add(category.getName());
				int nbFields = fields.size();
				for(int l = 0; l < nbFields; l++) {
					IField field = fields.get(l);
					ArrayList<IRecord> values = domainCollection.getAllRecordsForDomainAndCategoryAndField(domain, category, field);
					int nbValues = values.size();
					Double res = 0.0;
					for(int m = 0; m < nbValues; m++) {
						IRecord record = values.get(m);
						res += record.getValue();
					}
					line.add(res);
				}
				toWrite.add(line);
			}
			
			writer.writeData(toWrite);
		}
		
	}

}