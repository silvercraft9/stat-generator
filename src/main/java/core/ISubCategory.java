/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public interface ISubCategory {
	
	/**
	 * 
	 * @return The name of the subcategory
	 */
	public String getName();
	
	/**
	 * 
	 * @return The parent category of the subcategory
	 */
	public ICategory getParent();

}
