/**
 * 
 */
package writer;

import java.util.ArrayList;

import core.IField;

/**
 * @author ro6k4
 *
 */
public interface IWriter {

	/**
	 * 
	 * @param fields
	 * @return
	 */
	public ArrayList<Object> getFieldNames(ArrayList<IField> fields);
	
	/**
	 * 
	 * @param lines
	 * @return
	 */
	public int writeData (ArrayList<ArrayList<Object>> lines); 
}
