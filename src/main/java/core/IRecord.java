/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public interface IRecord {
	
	/**
	 * 
	 * @return The domain associated to the record
	 */
	public IDomain getDomain();
	
	/**
	 * 
	 * @return The category associated to the record
	 */
	public ICategory getCategory();
	
	/**
	 * 
	 * @return The subcategory associated to the record
	 */
	public ISubCategory getSubCategory();
	
	/**
	 * 
	 * @return The field associated to the record
	 */
	public IField getField();
	
	/**
	 * 
	 * @return The value associated to the record
	 */
	public Double getValue();
}
