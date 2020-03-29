package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ListUtilsTest {
	
	private static ArrayList<String> list = new ArrayList<String>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
	}

	@Test
	final void testBelongToList() {
		assertEquals(0, ListUtils.belongToList(list, "0"));
		assertEquals(1, ListUtils.belongToList(list, "1"));
		assertEquals(2, ListUtils.belongToList(list, "2"));
		assertEquals(3, ListUtils.belongToList(list, "3"));
		assertEquals(4, ListUtils.belongToList(list, "4"));
		assertEquals(5, ListUtils.belongToList(list, "5"));
		assertEquals(6, ListUtils.belongToList(list, "6"));
		assertEquals(7, ListUtils.belongToList(list, "7"));
		assertEquals(8, ListUtils.belongToList(list, "8"));
		assertEquals(9, ListUtils.belongToList(list, "9"));
		assertEquals(-1, ListUtils.belongToList(list, "10"));
		assertEquals(-1, ListUtils.belongToList(list, "A"));
	}

}
