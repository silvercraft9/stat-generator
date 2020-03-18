/**
 * 
 */
package config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		fail("Not yet implemented");
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
