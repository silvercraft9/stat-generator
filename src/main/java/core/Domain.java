/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public class Domain implements IDomain {

	private String name;
	private String type;
	
	public Domain(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object o) {
		Domain domain = (Domain) o;
		return this.getName().equalsIgnoreCase(domain.getName()) && this.getType().equalsIgnoreCase(domain.getType());
	}
}
