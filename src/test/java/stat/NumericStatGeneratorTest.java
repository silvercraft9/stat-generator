/**
 * 
 */
package stat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import core.Category;
import core.Domain;
import core.Field;
import core.ICategory;
import core.IDomain;
import core.IField;
import core.IRecord;
import core.ISubCategory;
import core.SubCategory;
import parser.ExcelFileParser;

/**
 * @author ro6k4
 *
 */
class NumericStatGeneratorTest {

	private static ExcelFileParser parser1;
	
	private static IDomain domain1;
	
	private static ICategory categoryA;
	private static ICategory categoryB;
	private static ICategory categoryC;
	
	private static ISubCategory subcat1;
	private static ISubCategory subcat2;
	private static ISubCategory subcat3;
	private static ISubCategory subcat4;
	private static ISubCategory subcat5;
	private static ISubCategory subcat6;
	
	private static IField fieldX;
	private static IField fieldY;
	private static IField fieldZ;
	
	private static IRecorderCollection collection;
	
	private static IStatGenerator generator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		domain1 = new Domain("Etablissement1", "brut");
		parser1 = new ExcelFileParser(domain1, "dossier_test/Etablissement1.xlsx");
		categoryA = new Category("categoryA");
		categoryB = new Category("categoryB");
		categoryC = new Category("categoryC");
		subcat1 = new SubCategory("Sous_Categorie1", categoryA);
		subcat2 = new SubCategory("Sous_Categorie2", categoryA);
		subcat3 = new SubCategory("Sous_Categorie3", categoryB);
		subcat4 = new SubCategory("Sous_Categorie4", categoryC);
		subcat5 = new SubCategory("Sous_Categorie5", categoryC);
		subcat6 = new SubCategory("Sous_Categorie6", categoryC);
		fieldX = new Field("ChampX", "brut", 1);
		fieldY = new Field("ChampY", "brut", 2);
		fieldZ = new Field("ChampZ", "brut", 3);
		
		ArrayList<ISubCategory> subcats = new ArrayList<ISubCategory>();
		subcats.add(subcat1);
		subcats.add(subcat2);
		subcats.add(subcat3);
		subcats.add(subcat4);
		subcats.add(subcat5);
		subcats.add(subcat6);
		
		ArrayList<IField> fields = new ArrayList<IField>();
		fields.add(fieldX);
		fields.add(fieldY);
		fields.add(fieldZ);
		
		ArrayList<IRecord> rawRecords = parser1.getRecordsPerSubCategory(subcats, fields);
		
		int nbRecords = rawRecords.size();
		collection = new NumericRecordCollection();
		for(int i = 0; i < nbRecords; i++) {
			IRecord record = rawRecords.get(i);
			collection.addRecord(record);
		}
		
		generator = new NumericStatGenerator();
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getSumForCategoryAndField(java.util.ArrayList, core.ICategory, core.IField)}.
	 */
	@Test
	final void testGetSumForCategoryAndField() {
		ArrayList<IRecord> records = collection.getAllRecordsForCategory(categoryC);
		Double actual1 = generator.getSumForCategoryAndField(records, categoryC, fieldX);
		Double expected1 = 39.0;
		Double actual2 = generator.getSumForCategoryAndField(records, categoryC, fieldY);
		Double expected2 = 42.0;
		Double actual3 = generator.getSumForCategoryAndField(records, categoryC, fieldZ);
		Double expected3 = 45.0;
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getAvgForCategoryAndField(java.util.ArrayList, core.ICategory, core.IField)}.
	 */
	@Test
	final void testGetAvgForCategoryAndField() {
		ArrayList<IRecord> records = collection.getAllRecordsForCategory(categoryC);
		Double actual1 = generator.getAvgForCategoryAndField(records, categoryC, fieldX);
		Double expected1 = 13.0;
		Double actual2 = generator.getAvgForCategoryAndField(records, categoryC, fieldY);
		Double expected2 = 14.0;
		Double actual3 = generator.getAvgForCategoryAndField(records, categoryC, fieldZ);
		Double expected3 = 15.0;
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getSumForDomainAndCategoryAndField(java.util.ArrayList, core.IDomain, core.ICategory, core.IField)}.
	 */
	@Test
	final void testGetSumForDomainAndCategoryAndField() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getAvgForDomainAndCategoryAndField(java.util.ArrayList, core.IDomain, core.ICategory, core.IField)}.
	 */
	@Test
	final void testGetAvgForDomainAndCategoryAndField() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getStdDrvForDomainAndCategoryAndField(java.util.ArrayList, core.ICategory, core.IField)}.
	 */
	@Test
	final void testGetStdDrvForDomainAndCategoryAndField() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link stat.NumericStatGenerator#getRatioPercentForDomainAndCategory(java.util.ArrayList, core.IDomain, core.ICategory, core.IField, core.IField)}.
	 */
	@Test
	final void testGetRatioPercentForDomainAndCategory() {
		fail("Not yet implemented");
	}

}
