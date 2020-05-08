/**
 * 
 */
package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.ICategory;
import core.IDomain;
import core.IField;
import core.IRecord;
import core.ISubCategory;
import core.Record;
import util.ListUtils;

/**
 * @author ro6k4
 *
 */
public class ExcelFileParser implements IFileParser {

	public IDomain domain;
	public String filename;
	public XSSFWorkbook workbook;
	
	public ExcelFileParser(IDomain domain, String filename) throws IOException {
		this.domain = domain;
		this.filename = filename;
		FileInputStream excelFile = new FileInputStream(new File(filename));
		this.workbook = new XSSFWorkbook(excelFile);
	}
	
	@Override
	public String getFilePath() {
		return this.filename;
	}
	
	/**
	 * 
	 * @param fields A list of fields to locate in the excel file
	 * @return The map of field names with their location in the excel file
	 */
	public HashMap<String, Integer> getFieldColumns(ArrayList<IField> fields) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		ArrayList<String> fieldNames = new ArrayList<String>();
		int n = fields.size();
		for(int i = 0; i < n; i++) {
			String fieldName = fields.get(i).getName();
			fieldNames.add(fieldName);
		}
		
		XSSFSheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		int nbFields = fields.size();
		int nbFound = 0;
		while (rowIterator.hasNext() && nbFound < nbFields) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
					String cellValue = cell.getStringCellValue();
					int position = ListUtils.belongToList(fieldNames, cellValue);
					if(position > -1) {
						result.put(cellValue, cell.getColumnIndex());
						nbFound++;
					}
				}
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getRecordsPerCategory(ArrayList<ICategory> categories, ArrayList<IField> fields) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		
		ArrayList<String> categoryNames = new ArrayList<String>();
		int nbCategory = categories.size();
		for(int i = 0; i < nbCategory; i++) {
			String categoryName = categories.get(i).getName();
			categoryNames.add(categoryName);
		}
		
		ArrayList<String> fieldNames = new ArrayList<String>();
		int nbField = fields.size();
		for(int i = 0; i < nbField; i++) {
			String fieldName = fields.get(i).getName();
			fieldNames.add(fieldName);
		}
		
		HashMap<String, Integer> fieldColumns = this.getFieldColumns(fields);
		XSSFSheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cell = row.getCell(0);
			if(cell != null) {
				String categoryName = cell.getStringCellValue();
				int categoryIndex = ListUtils.belongToList(categoryNames, categoryName);
				System.out.println(categoryName + ", index: " + categoryIndex);
				ICategory category = categories.get(categoryIndex);
				if(categoryIndex > -1) {
					for(int i = 0; i < nbField; i++) {
						String fieldName = fieldNames.get(i);
						IField field = fields.get(i);
						Double value = row.getCell(fieldColumns.get(fieldName)).getNumericCellValue();
						IRecord record = new Record(this.domain, category, null, field, value);
						result.add(record);
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<IRecord> getRecordsPerSubCategory(ArrayList<ISubCategory> subCategories, ArrayList<IField> fields) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		
		ArrayList<String> subCategoryNames = new ArrayList<String>();
		int nbSubCategory = subCategories.size();
		for(int i = 0; i < nbSubCategory; i++) {
			String subCategoryName = subCategories.get(i).getName();
			subCategoryNames.add(subCategoryName);
		}
		
		ArrayList<String> fieldNames = new ArrayList<String>();
		int nbField = fields.size();
		for(int i = 0; i < nbField; i++) {
			String fieldName = fields.get(i).getName();
			fieldNames.add(fieldName);
		}
		
		HashMap<String, Integer> fieldColumns = this.getFieldColumns(fields);
		XSSFSheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cell = row.getCell(0);
			if(cell != null) {
				String subCategoryName = cell.getStringCellValue();
				int subCategoryIndex = ListUtils.belongToList(subCategoryNames, subCategoryName);
				System.out.println(subCategoryName + ", index: " + subCategoryIndex);
				ISubCategory subCategory = subCategories.get(subCategoryIndex);
				ICategory category = subCategory.getParent();
				if(subCategoryIndex > -1) {
					for(int i = 0; i < nbField; i++) {
						String fieldName = fieldNames.get(i);
						IField field = fields.get(i);
						Double value = row.getCell(fieldColumns.get(fieldName)).getNumericCellValue();
						IRecord record = new Record(this.domain, category, subCategory, field, value);
						result.add(record);
					}
				}
			}
		}
		
		return result;
	}

}
