/**
 * 
 */
package config;

import java.util.ArrayList;

import core.ICategory;
import core.IDomain;
import core.IField;
import core.ISubCategory;

/**
 * @author ro6k4
 *
 */
public interface IConfigReader {

	/**
	 * 
	 */
	public void init();
	
	/**
	 * 
	 * @return The list of all domains to consider
	 */
	public ArrayList<IDomain> getDomains();
	
	/**
	 * 
	 * @return The list of all categories to consider
	 */
	public ArrayList<ICategory> getCategories();
	
	/**
	 * 
	 * @return The list of all subcategories to consider
	 */
	public ArrayList<ISubCategory> getSubCategories();
	
	/**
	 * 
	 * @return  The list of all fields to consider
	 */
	public ArrayList<IField> getFields();
	
}
