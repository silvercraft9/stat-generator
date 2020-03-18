/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public class Record implements IRecord {

	private IDomain domain;
	private ICategory category;
	private ISubCategory subcat;
	private Double value;
	
	public Record(IDomain domain,  ICategory category, ISubCategory subcat, Double value) {
		this.domain = domain;
		this.category = category;
		this.subcat = subcat;
		this.value = value;
	}
	
	@Override
	public IDomain getDomain() {
		return this.domain;
	}

	@Override
	public ICategory getCategory() {
		return this.category;
	}

	@Override
	public ISubCategory getSubCategory() {
		return this.subcat;
	}

	@Override
	public Double getValue() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object o) {
		Record record = (Record) o;
		return this.getDomain().equals(record.getDomain()) && this.getCategory().equals(record.getCategory()) && this.getSubCategory().equals(record.getSubCategory()) && this.getValue() == record.getValue();
	}
	
}
