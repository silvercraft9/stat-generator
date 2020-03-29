/**
 * 
 */
package parser;

import java.util.ArrayList;

import core.ICategory;
import core.IField;
import core.IRecord;
import core.ISubCategory;

/**
 * @author ro6k4
 *
 */
public interface IFileParser {
	
	/**
	 * 
	 * @return The path of file to parse
	 */
	public String getFilePath();
	
	/**
	 * 
	 * @return The list of records included in the file
	 */
	public ArrayList<IRecord> getRecordsPerCategory(ArrayList<ICategory> categories, ArrayList<IField> fields);
	
	/**
	 * 
	 * @return The list of records included in the file
	 */
	public ArrayList<IRecord> getRecordsPerSubCategory(ArrayList<ISubCategory> subCategories, ArrayList<IField> fields);

}
