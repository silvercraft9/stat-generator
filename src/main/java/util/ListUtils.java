/**
 * 
 */
package util;

import java.util.ArrayList;

/**
 * @author ro6k4
 *
 */
public class ListUtils {

	/**
	 * 
	 * @param list A list of string values
	 * @param value A string to find in the list
	 * @return The position of the value if it belongs to the list, -1 otherwise
	 */
	public static int belongToList(ArrayList<String> list, String value) {
		int result = -1;
		int size = list.size();
		int i = 0;
		while (i < size) {
			String current = list.get(i);
			if(current.equalsIgnoreCase(value)) {
				result = i;
				break;
			}
			i++;
		}
		return result;
	}
}
