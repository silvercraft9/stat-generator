/**
 * 
 */
package parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import core.Category;
import core.Domain;
import core.Field;
import core.IDomain;
import core.IField;
import core.IRecord;
import core.ISubCategory;
import core.Record;
import core.SubCategory;
import parser.ExcelFileParser;

/**
 * @author ro6k4
 *
 */
class ExcelFileParserTest {

	private static ExcelFileParser parser1;
	private static ExcelFileParser parser2;
	private static IDomain domain1;
	private static IDomain domain2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		domain1 = new Domain("Etablissement1", "brut");
		domain2 = new Domain("Etablissement2", "brut");
		parser1 = new ExcelFileParser(domain1, "dossier_test/Etablissement1.xlsx");
		parser2 = new ExcelFileParser(domain2, "dossier_test/Etablissement2.xlsx");
	}

	/**
	 * Test method for {@link parser.ExcelFileParser#getFieldColumns(java.util.ArrayList)}.
	 */
	@Test
	final void testGetFieldColumns() {
		ArrayList<IField> fields = new ArrayList<IField>();
		IField fieldX = new Field("ChampX", "brut", 1);
		IField fieldY = new Field("ChampY", "brut", 2);
		IField fieldZ = new Field("ChampZ", "brut", 3);
		fields.add(fieldX);
		fields.add(fieldY);
		fields.add(fieldZ);
		
		HashMap<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("ChampX", 1);
		expected.put("ChampY", 2);
		expected.put("ChampZ", 3);
		
		HashMap<String, Integer> actual1 = parser1.getFieldColumns(fields);
		HashMap<String, Integer> actual2 = parser2.getFieldColumns(fields);
		
		assertEquals(expected.get("ChampX"), actual1.get("ChampX"));
		assertEquals(expected.get("ChampY"), actual1.get("ChampY"));
		assertEquals(expected.get("ChampZ"), actual1.get("ChampZ"));
		assertEquals(expected.get("ChampX"), actual2.get("ChampX"));
		assertEquals(expected.get("ChampY"), actual2.get("ChampY"));
		assertEquals(expected.get("ChampZ"), actual2.get("ChampZ"));
	}

	/**
	 * Test method for {@link parser.ExcelFileParser#getRecords()}.
	 */
	@Test
	final void testGetRecords() {
		ArrayList<IField> fields1 = new ArrayList<IField>();
		IField fieldX = Mockito.mock(IField.class);
		Mockito.when(fieldX.getName()).thenReturn("ChampX");
		Mockito.when(fieldX.getType()).thenReturn("brut");
		Mockito.when(fieldX.getRank()).thenReturn(1);
		
		IField fieldY = Mockito.mock(IField.class);
		Mockito.when(fieldY.getName()).thenReturn("ChampY");
		Mockito.when(fieldY.getType()).thenReturn("brut");
		Mockito.when(fieldY.getRank()).thenReturn(2);
		
		IField fieldZ = Mockito.mock(IField.class);
		Mockito.when(fieldZ.getName()).thenReturn("ChampZ");
		Mockito.when(fieldZ.getType()).thenReturn("brut");
		Mockito.when(fieldZ.getRank()).thenReturn(3);
		
		fields1.add(fieldX);
		fields1.add(fieldY);
		fields1.add(fieldZ);
		
		Category catA = Mockito.mock(Category.class);
		Mockito.when(catA.getName()).thenReturn("CategorieA");
		
		Category catB = Mockito.mock(Category.class);
		Mockito.when(catB.getName()).thenReturn("CategorieB");
		
		Category catC = Mockito.mock(Category.class);
		Mockito.when(catC.getName()).thenReturn("CategorieC");
		
		ArrayList<ISubCategory> subcats = new ArrayList<ISubCategory>();
		
		SubCategory subcat1 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat1.getName()).thenReturn("Sous_Categorie1");
		Mockito.when(subcat1.getParent()).thenReturn(catA);
		
		SubCategory subcat2 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat2.getName()).thenReturn("Sous_Categorie2");
		Mockito.when(subcat2.getParent()).thenReturn(catA);
		
		SubCategory subcat3 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat3.getName()).thenReturn("Sous_Categorie3");
		Mockito.when(subcat3.getParent()).thenReturn(catB);
		
		SubCategory subcat4 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat4.getName()).thenReturn("Sous_Categorie4");
		Mockito.when(subcat4.getParent()).thenReturn(catC);
		
		SubCategory subcat5 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat5.getName()).thenReturn("Sous_Categorie5");
		Mockito.when(subcat5.getParent()).thenReturn(catC);
		
		SubCategory subcat6 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat6.getName()).thenReturn("Sous_Categorie6");
		Mockito.when(subcat6.getParent()).thenReturn(catC);
		
		subcats.add(subcat1);
		subcats.add(subcat2);
		subcats.add(subcat3);
		subcats.add(subcat4);
		subcats.add(subcat5);
		subcats.add(subcat6);
		
		Record rec1 = Mockito.mock(Record.class);
		Mockito.when(rec1.getDomain()).thenReturn(domain1);
		Mockito.when(rec1.getCategory()).thenReturn(catA);
		Mockito.when(rec1.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec1.getField()).thenReturn(fieldX);
		Mockito.when(rec1.getValue()).thenReturn(1.0);
		Record rec2 = Mockito.mock(Record.class);
		Mockito.when(rec2.getDomain()).thenReturn(domain1);
		Mockito.when(rec2.getCategory()).thenReturn(catA);
		Mockito.when(rec2.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec2.getField()).thenReturn(fieldY);
		Mockito.when(rec2.getValue()).thenReturn(2.0);
		Record rec3 = Mockito.mock(Record.class);
		Mockito.when(rec3.getDomain()).thenReturn(domain1);
		Mockito.when(rec3.getCategory()).thenReturn(catA);
		Mockito.when(rec3.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec3.getField()).thenReturn(fieldZ);
		Mockito.when(rec3.getValue()).thenReturn(3.0);
		Record rec4 = Mockito.mock(Record.class);
		Mockito.when(rec4.getDomain()).thenReturn(domain1);
		Mockito.when(rec4.getCategory()).thenReturn(catA);
		Mockito.when(rec4.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec4.getField()).thenReturn(fieldX);
		Mockito.when(rec4.getValue()).thenReturn(4.0);
		Record rec5 = Mockito.mock(Record.class);
		Mockito.when(rec5.getDomain()).thenReturn(domain1);
		Mockito.when(rec5.getCategory()).thenReturn(catA);
		Mockito.when(rec5.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec5.getField()).thenReturn(fieldY);
		Mockito.when(rec5.getValue()).thenReturn(5.0);
		Record rec6 = Mockito.mock(Record.class);
		Mockito.when(rec6.getDomain()).thenReturn(domain1);
		Mockito.when(rec6.getCategory()).thenReturn(catA);
		Mockito.when(rec6.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec6.getField()).thenReturn(fieldZ);
		Mockito.when(rec6.getValue()).thenReturn(6.0);
		Record rec7 = Mockito.mock(Record.class);
		Mockito.when(rec7.getDomain()).thenReturn(domain1);
		Mockito.when(rec7.getCategory()).thenReturn(catB);
		Mockito.when(rec7.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec7.getField()).thenReturn(fieldX);
		Mockito.when(rec7.getValue()).thenReturn(7.0);
		Record rec8 = Mockito.mock(Record.class);
		Mockito.when(rec8.getDomain()).thenReturn(domain1);
		Mockito.when(rec8.getCategory()).thenReturn(catB);
		Mockito.when(rec8.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec8.getField()).thenReturn(fieldY);
		Mockito.when(rec8.getValue()).thenReturn(8.0);
		Record rec9 = Mockito.mock(Record.class);
		Mockito.when(rec9.getDomain()).thenReturn(domain1);
		Mockito.when(rec9.getCategory()).thenReturn(catB);
		Mockito.when(rec9.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec9.getField()).thenReturn(fieldZ);
		Mockito.when(rec9.getValue()).thenReturn(9.0);
		Record rec10 = Mockito.mock(Record.class);
		Mockito.when(rec10.getDomain()).thenReturn(domain1);
		Mockito.when(rec10.getCategory()).thenReturn(catC);
		Mockito.when(rec10.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec10.getField()).thenReturn(fieldX);
		Mockito.when(rec10.getValue()).thenReturn(10.0);
		Record rec11 = Mockito.mock(Record.class);
		Mockito.when(rec11.getDomain()).thenReturn(domain1);
		Mockito.when(rec11.getCategory()).thenReturn(catC);
		Mockito.when(rec11.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec11.getField()).thenReturn(fieldY);
		Mockito.when(rec11.getValue()).thenReturn(11.0);
		Record rec12 = Mockito.mock(Record.class);
		Mockito.when(rec12.getDomain()).thenReturn(domain1);
		Mockito.when(rec12.getCategory()).thenReturn(catC);
		Mockito.when(rec12.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec12.getField()).thenReturn(fieldZ);
		Mockito.when(rec12.getValue()).thenReturn(12.0);
		Record rec13 = Mockito.mock(Record.class);
		Mockito.when(rec13.getDomain()).thenReturn(domain1);
		Mockito.when(rec13.getCategory()).thenReturn(catC);
		Mockito.when(rec13.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec13.getField()).thenReturn(fieldX);
		Mockito.when(rec13.getValue()).thenReturn(13.0);
		Record rec14 = Mockito.mock(Record.class);
		Mockito.when(rec14.getDomain()).thenReturn(domain1);
		Mockito.when(rec14.getCategory()).thenReturn(catC);
		Mockito.when(rec14.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec14.getField()).thenReturn(fieldY);
		Mockito.when(rec14.getValue()).thenReturn(14.0);
		Record rec15 = Mockito.mock(Record.class);
		Mockito.when(rec15.getDomain()).thenReturn(domain1);
		Mockito.when(rec15.getCategory()).thenReturn(catC);
		Mockito.when(rec15.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec15.getField()).thenReturn(fieldZ);
		Mockito.when(rec15.getValue()).thenReturn(15.0);
		Record rec16 = Mockito.mock(Record.class);
		Mockito.when(rec16.getDomain()).thenReturn(domain1);
		Mockito.when(rec16.getCategory()).thenReturn(catC);
		Mockito.when(rec16.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec16.getField()).thenReturn(fieldX);
		Mockito.when(rec16.getValue()).thenReturn(16.0);
		Record rec17 = Mockito.mock(Record.class);
		Mockito.when(rec17.getDomain()).thenReturn(domain1);
		Mockito.when(rec17.getCategory()).thenReturn(catC);
		Mockito.when(rec17.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec17.getField()).thenReturn(fieldY);
		Mockito.when(rec17.getValue()).thenReturn(17.0);
		Record rec18 = Mockito.mock(Record.class);
		Mockito.when(rec18.getDomain()).thenReturn(domain1);
		Mockito.when(rec18.getCategory()).thenReturn(catC);
		Mockito.when(rec18.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec18.getField()).thenReturn(fieldZ);
		Mockito.when(rec18.getValue()).thenReturn(18.0);
		
		Record rec19 = Mockito.mock(Record.class);
		Mockito.when(rec19.getDomain()).thenReturn(domain2);
		Mockito.when(rec19.getCategory()).thenReturn(catA);
		Mockito.when(rec19.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec19.getField()).thenReturn(fieldX);
		Mockito.when(rec19.getValue()).thenReturn(11.0);
		Record rec20 = Mockito.mock(Record.class);
		Mockito.when(rec20.getDomain()).thenReturn(domain2);
		Mockito.when(rec20.getCategory()).thenReturn(catA);
		Mockito.when(rec20.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec20.getField()).thenReturn(fieldY);
		Mockito.when(rec20.getValue()).thenReturn(12.0);
		Record rec21 = Mockito.mock(Record.class);
		Mockito.when(rec21.getDomain()).thenReturn(domain2);
		Mockito.when(rec21.getCategory()).thenReturn(catA);
		Mockito.when(rec21.getSubCategory()).thenReturn(subcat1);
		Mockito.when(rec21.getField()).thenReturn(fieldZ);
		Mockito.when(rec21.getValue()).thenReturn(13.0);
		Record rec22 = Mockito.mock(Record.class);
		Mockito.when(rec22.getDomain()).thenReturn(domain2);
		Mockito.when(rec22.getCategory()).thenReturn(catA);
		Mockito.when(rec22.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec22.getField()).thenReturn(fieldX);
		Mockito.when(rec22.getValue()).thenReturn(14.0);
		Record rec23 = Mockito.mock(Record.class);
		Mockito.when(rec23.getDomain()).thenReturn(domain2);
		Mockito.when(rec23.getCategory()).thenReturn(catA);
		Mockito.when(rec23.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec23.getField()).thenReturn(fieldY);
		Mockito.when(rec23.getValue()).thenReturn(15.0);
		Record rec24 = Mockito.mock(Record.class);
		Mockito.when(rec24.getDomain()).thenReturn(domain2);
		Mockito.when(rec24.getCategory()).thenReturn(catA);
		Mockito.when(rec24.getSubCategory()).thenReturn(subcat2);
		Mockito.when(rec24.getField()).thenReturn(fieldZ);
		Mockito.when(rec24.getValue()).thenReturn(16.0);
		Record rec25 = Mockito.mock(Record.class);
		Mockito.when(rec25.getDomain()).thenReturn(domain2);
		Mockito.when(rec25.getCategory()).thenReturn(catB);
		Mockito.when(rec25.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec25.getField()).thenReturn(fieldX);
		Mockito.when(rec25.getValue()).thenReturn(17.0);
		Record rec26 = Mockito.mock(Record.class);
		Mockito.when(rec26.getDomain()).thenReturn(domain2);
		Mockito.when(rec26.getCategory()).thenReturn(catB);
		Mockito.when(rec26.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec26.getField()).thenReturn(fieldY);
		Mockito.when(rec26.getValue()).thenReturn(18.0);
		Record rec27 = Mockito.mock(Record.class);
		Mockito.when(rec27.getDomain()).thenReturn(domain2);
		Mockito.when(rec27.getCategory()).thenReturn(catB);
		Mockito.when(rec27.getSubCategory()).thenReturn(subcat3);
		Mockito.when(rec27.getField()).thenReturn(fieldZ);
		Mockito.when(rec27.getValue()).thenReturn(19.0);
		Record rec28 = Mockito.mock(Record.class);
		Mockito.when(rec28.getDomain()).thenReturn(domain2);
		Mockito.when(rec28.getCategory()).thenReturn(catC);
		Mockito.when(rec28.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec28.getField()).thenReturn(fieldX);
		Mockito.when(rec28.getValue()).thenReturn(20.0);
		Record rec29 = Mockito.mock(Record.class);
		Mockito.when(rec29.getDomain()).thenReturn(domain2);
		Mockito.when(rec29.getCategory()).thenReturn(catC);
		Mockito.when(rec29.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec29.getField()).thenReturn(fieldY);
		Mockito.when(rec29.getValue()).thenReturn(21.0);
		Record rec30 = Mockito.mock(Record.class);
		Mockito.when(rec30.getDomain()).thenReturn(domain2);
		Mockito.when(rec30.getCategory()).thenReturn(catC);
		Mockito.when(rec30.getSubCategory()).thenReturn(subcat4);
		Mockito.when(rec30.getField()).thenReturn(fieldZ);
		Mockito.when(rec30.getValue()).thenReturn(22.0);
		Record rec31 = Mockito.mock(Record.class);
		Mockito.when(rec31.getDomain()).thenReturn(domain2);
		Mockito.when(rec31.getCategory()).thenReturn(catC);
		Mockito.when(rec31.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec31.getField()).thenReturn(fieldX);
		Mockito.when(rec31.getValue()).thenReturn(23.0);
		Record rec32 = Mockito.mock(Record.class);
		Mockito.when(rec32.getDomain()).thenReturn(domain2);
		Mockito.when(rec32.getCategory()).thenReturn(catC);
		Mockito.when(rec32.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec32.getField()).thenReturn(fieldY);
		Mockito.when(rec32.getValue()).thenReturn(24.0);
		Record rec33 = Mockito.mock(Record.class);
		Mockito.when(rec33.getDomain()).thenReturn(domain2);
		Mockito.when(rec33.getCategory()).thenReturn(catC);
		Mockito.when(rec33.getSubCategory()).thenReturn(subcat5);
		Mockito.when(rec33.getField()).thenReturn(fieldZ);
		Mockito.when(rec33.getValue()).thenReturn(25.0);
		Record rec34 = Mockito.mock(Record.class);
		Mockito.when(rec34.getDomain()).thenReturn(domain2);
		Mockito.when(rec34.getCategory()).thenReturn(catC);
		Mockito.when(rec34.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec34.getField()).thenReturn(fieldX);
		Mockito.when(rec34.getValue()).thenReturn(26.0);
		Record rec35 = Mockito.mock(Record.class);
		Mockito.when(rec35.getDomain()).thenReturn(domain2);
		Mockito.when(rec35.getCategory()).thenReturn(catC);
		Mockito.when(rec35.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec35.getField()).thenReturn(fieldY);
		Mockito.when(rec35.getValue()).thenReturn(27.0);
		Record rec36 = Mockito.mock(Record.class);
		Mockito.when(rec36.getDomain()).thenReturn(domain2);
		Mockito.when(rec36.getCategory()).thenReturn(catC);
		Mockito.when(rec36.getSubCategory()).thenReturn(subcat6);
		Mockito.when(rec36.getField()).thenReturn(fieldZ);
		Mockito.when(rec36.getValue()).thenReturn(28.0);
		
		ArrayList<IRecord> expectedList1 = new ArrayList<IRecord>();
		expectedList1.add(rec1);
		expectedList1.add(rec2);
		expectedList1.add(rec3);
		expectedList1.add(rec4);
		expectedList1.add(rec5);
		expectedList1.add(rec6);
		expectedList1.add(rec7);
		expectedList1.add(rec8);
		expectedList1.add(rec9);
		expectedList1.add(rec10);
		expectedList1.add(rec11);
		expectedList1.add(rec12);
		expectedList1.add(rec13);
		expectedList1.add(rec14);
		expectedList1.add(rec15);
		expectedList1.add(rec16);
		expectedList1.add(rec17);
		expectedList1.add(rec18);
		
		ArrayList<IRecord> expectedList2 = new ArrayList<IRecord>();
		expectedList2.add(rec19);
		expectedList2.add(rec20);
		expectedList2.add(rec21);
		expectedList2.add(rec22);
		expectedList2.add(rec23);
		expectedList2.add(rec24);
		expectedList2.add(rec25);
		expectedList2.add(rec26);
		expectedList2.add(rec27);
		expectedList2.add(rec28);
		expectedList2.add(rec29);
		expectedList2.add(rec30);
		expectedList2.add(rec31);
		expectedList2.add(rec32);
		expectedList2.add(rec33);
		expectedList2.add(rec34);
		expectedList2.add(rec35);
		expectedList2.add(rec36);
		
		ArrayList<IRecord> actualList1 = parser1.getRecordsPerSubCategory(subcats, fields1);
		ArrayList<IRecord> actualList2 = parser2.getRecordsPerSubCategory(subcats, fields1);
		
		int nbDom1Records = expectedList1.size();
		
		for(int i = 0; i < nbDom1Records; i++) {
			IRecord expected = expectedList1.get(i);
			IRecord actual = actualList1.get(i);
			assertEquals(expected.getDomain().getName(), actual.getDomain().getName());
			assertEquals(expected.getCategory().getName(), actual.getCategory().getName());
			assertEquals(expected.getSubCategory().getName(), actual.getSubCategory().getName());
			assertEquals(expected.getField().getName(), actual.getField().getName());
			assertEquals(expected.getValue(), actual.getValue());
		}
		
		int nbDom2Records = expectedList2.size();
		
		for(int i = 0; i < nbDom2Records; i++) {
			IRecord expected = expectedList2.get(i);
			IRecord actual = actualList2.get(i);
			assertEquals(expected.getDomain().getName(), actual.getDomain().getName());
			assertEquals(expected.getCategory().getName(), actual.getCategory().getName());
			assertEquals(expected.getSubCategory().getName(), actual.getSubCategory().getName());
			assertEquals(expected.getField().getName(), actual.getField().getName());
			assertEquals(expected.getValue(), actual.getValue());
		}
	}

}
