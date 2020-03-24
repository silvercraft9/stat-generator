/**
 * 
 */
package config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import core.Category;
import core.Domain;
import core.Field;
import core.ICategory;
import core.IDomain;
import core.IField;
import core.ISubCategory;
import core.SubCategory;

/**
 * @author ro6k4
 *
 */
class XmlConfigReaderTest {
	
	private static XmlConfigReader confReader;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		confReader = new XmlConfigReader();
		confReader.init();
		
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getDomainFolder()}.
	 */
	@Test
	void testGetDomainFolder() {
		String expected = "dossier_test";
		assertEquals(expected, confReader.getDomainFolder());
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getDomains()}.
	 */
	@Test
	void testGetDomains() {
		ArrayList<IDomain> domains = new ArrayList<IDomain>();
		
		Domain dom1 = Mockito.mock(Domain.class);
		Mockito.when(dom1.getName()).thenReturn("Etablissement1");
		Mockito.when(dom1.getType()).thenReturn("brut");
		
		Domain dom2 = Mockito.mock(Domain.class);
		Mockito.when(dom2.getName()).thenReturn("Etablissement2");
		Mockito.when(dom2.getType()).thenReturn("brut");
		
		Domain dom3 = Mockito.mock(Domain.class);
		Mockito.when(dom3.getName()).thenReturn("Etablissement3");
		Mockito.when(dom3.getType()).thenReturn("precalcule");
		
		Domain dom4 = Mockito.mock(Domain.class);
		Mockito.when(dom4.getName()).thenReturn("Etablissement4");
		Mockito.when(dom4.getType()).thenReturn("precalcule");
		
		domains.add(dom1);
		domains.add(dom2);
		domains.add(dom3);
		domains.add(dom4);
		
		ArrayList<IDomain> actualDomains = confReader.getDomains();
		int n = actualDomains.size();
		for(int i = 0; i < n; i++) {
			IDomain actual = actualDomains.get(i);
			IDomain expected = domains.get(i);
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getType(), actual.getType());
		}
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getCategories()}.
	 */
	@Test
	void testGetCategories() {
		ArrayList<ICategory> categories = new ArrayList<ICategory>();
		
		Category cat1 = Mockito.mock(Category.class);
		Mockito.when(cat1.getName()).thenReturn("CategorieA");
		
		Category cat2 = Mockito.mock(Category.class);
		Mockito.when(cat2.getName()).thenReturn("CategorieB");
		
		Category cat3 = Mockito.mock(Category.class);
		Mockito.when(cat3.getName()).thenReturn("CategorieC");
		
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);

		ArrayList<ICategory> actualCategories = confReader.getCategories();
		int n = actualCategories.size();
		for(int i = 0; i < n; i++) {
			ICategory actual = actualCategories.get(i);
			ICategory expected = categories.get(i);
			assertEquals(expected.getName(), actual.getName());
		}

	}

	/**
	 * Test method for {@link config.XmlConfigReader#getSubCategories()}.
	 */
	@Test
	void testGetSubCategories() {
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
		
		ArrayList<ISubCategory> actualSubCats = confReader.getSubCategories();
		int n = actualSubCats.size();
		for(int i = 0; i < n; i++) {
			ISubCategory actual = actualSubCats.get(i);
			ISubCategory expected = subcats.get(i);
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getParent().getName(), actual.getParent().getName());
		}
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getFields()}.
	 */
	@Test
	void testGetFields() {
		ArrayList<IField> fields = new ArrayList<IField>();
		
		IField field1 = Mockito.mock(Field.class);
		Mockito.when(field1.getName()).thenReturn("ChampX");
		Mockito.when(field1.getType()).thenReturn("brut");
		Mockito.when(field1.getRank()).thenReturn(1);
		
		IField field2 = Mockito.mock(Field.class);
		Mockito.when(field2.getName()).thenReturn("ChampY");
		Mockito.when(field2.getType()).thenReturn("brut");
		Mockito.when(field2.getRank()).thenReturn(2);
		
		IField field3 = Mockito.mock(Field.class);
		Mockito.when(field3.getName()).thenReturn("ChampZ");
		Mockito.when(field3.getType()).thenReturn("brut");
		Mockito.when(field3.getRank()).thenReturn(3);
		
		IField field4 = Mockito.mock(Field.class);
		Mockito.when(field4.getName()).thenReturn("ChampN");
		Mockito.when(field4.getType()).thenReturn("precalcule");
		Mockito.when(field4.getRank()).thenReturn(1);
		
		IField field5 = Mockito.mock(Field.class);
		Mockito.when(field5.getName()).thenReturn("ChampO");
		Mockito.when(field5.getType()).thenReturn("precalcule");
		Mockito.when(field5.getRank()).thenReturn(2);
		
		fields.add(field1);
		fields.add(field2);
		fields.add(field3);
		fields.add(field4);
		fields.add(field5);
		
		ArrayList<IField> actualFields = confReader.getFields();
		int n = actualFields.size();
		for(int i = 0; i < n; i++) {
			IField actual = actualFields.get(i);
			IField expected = fields.get(i);
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getType(), actual.getType());
			assertEquals(expected.getRank(), actual.getRank());
		}
	}

}
