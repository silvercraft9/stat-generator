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
import core.ISubCategory;
import core.SubCategory;
import parser.ExcelFileParser;

/**
 * @author ro6k4
 *
 */
class ExcelFileParserTest {

	private static ExcelFileParser parser;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		IDomain domain = new Domain("Etablissement1", "brut");
		parser = new ExcelFileParser(domain, "dossier_test/Etablissement1.xlsx");
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
		
		HashMap<String, Integer> actual1 = parser.getFieldColumns(fields);
		
		assertEquals(expected.get("ChampX"), actual1.get("ChampX"));
		assertEquals(expected.get("ChampY"), actual1.get("ChampY"));
		assertEquals(expected.get("ChampZ"), actual1.get("ChampZ"));
	}

	/**
	 * Test method for {@link parser.ExcelFileParser#getRecords()}.
	 */
	@Test
	final void testGetRecords() {
		ArrayList<IField> fields = new ArrayList<IField>();
		IField fieldX = new Field("ChampX", "brut", 1);
		IField fieldY = new Field("ChampY", "brut", 2);
		IField fieldZ = new Field("ChampZ", "brut", 3);
		fields.add(fieldX);
		fields.add(fieldY);
		fields.add(fieldZ);
		
		Category cat1 = Mockito.mock(Category.class);
		Mockito.when(cat1.getName()).thenReturn("CategorieA");
		
		Category cat2 = Mockito.mock(Category.class);
		Mockito.when(cat2.getName()).thenReturn("CategorieB");
		
		Category cat3 = Mockito.mock(Category.class);
		Mockito.when(cat3.getName()).thenReturn("CategorieC");
		
		ArrayList<ISubCategory> subcats = new ArrayList<ISubCategory>();
		
		SubCategory subcat1 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat1.getName()).thenReturn("Sous_Categorie1");
		Mockito.when(subcat1.getParent()).thenReturn(cat1);
		
		SubCategory subcat2 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat2.getName()).thenReturn("Sous_Categorie2");
		Mockito.when(subcat2.getParent()).thenReturn(cat1);
		
		SubCategory subcat3 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat3.getName()).thenReturn("Sous_Categorie3");
		Mockito.when(subcat3.getParent()).thenReturn(cat2);
		
		SubCategory subcat4 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat4.getName()).thenReturn("Sous_Categorie4");
		Mockito.when(subcat4.getParent()).thenReturn(cat3);
		
		SubCategory subcat5 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat5.getName()).thenReturn("Sous_Categorie5");
		Mockito.when(subcat5.getParent()).thenReturn(cat3);
		
		SubCategory subcat6 = Mockito.mock(SubCategory.class);
		Mockito.when(subcat6.getName()).thenReturn("Sous_Categorie6");
		Mockito.when(subcat6.getParent()).thenReturn(cat3);
		
		subcats.add(subcat1);
		subcats.add(subcat2);
		subcats.add(subcat3);
		subcats.add(subcat4);
		subcats.add(subcat5);
		subcats.add(subcat6);
		
		parser.getRecordsPerSubCategory(subcats, fields);
		
	}

}
