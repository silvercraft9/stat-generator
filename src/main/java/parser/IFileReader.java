/**
 * 
 */
package parser;

import java.util.ArrayList;

import core.IRecord;

/**
 * @author ro6k4
 *
 */
public interface IFileReader {
	
	/**
	 * 
	 * @return The path of file to parse
	 */
	public String getFilePath();
	
	/**
	 * 
	 * @return The list of records included in the file
	 */
	public ArrayList<IRecord> getRecords();

}
