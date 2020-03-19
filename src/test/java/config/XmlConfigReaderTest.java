/**
 * 
 */
package config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import core.Domain;
import core.IDomain;

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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getSubCategories()}.
	 */
	@Test
	void testGetSubCategories() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link config.XmlConfigReader#getFields()}.
	 */
	@Test
	void testGetFields() {
		fail("Not yet implemented");
	}

}
