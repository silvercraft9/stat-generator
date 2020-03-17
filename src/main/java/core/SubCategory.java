/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public class SubCategory implements ISubCategory {
	
	private String name;
	private ICategory parent;
	
	public SubCategory(String name, ICategory parent) {
		this.name = name;
		this.parent = parent;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public ICategory getParent() {
		return this.parent;
	}

}
