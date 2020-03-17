/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public class Category implements ICategory {

	private String name;
	
	public Category(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
