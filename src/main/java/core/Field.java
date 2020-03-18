/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public class Field implements IField {

	private String name;
	private String type;
	private Integer rank;
	
	public Field(String name, String type, Integer rank) {
		this.name = name;
		this.type = type;
		this.rank = rank;
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
	public Integer getRank() {
		return this.rank;
	}
	
	@Override
	public boolean equals(Object o) {
		Field field = (Field) o;
		return this.getName().equalsIgnoreCase(field.getName()) && this.getType().equalsIgnoreCase(field.getType()) && this.getRank() == field.getRank();
	}

}
