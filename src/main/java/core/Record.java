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
	private IField field;
	private Double value;
	
	public Record(IDomain domain,  ICategory category, ISubCategory subcat, IField field, Double value) {
		this.domain = domain;
		this.category = category;
		this.subcat = subcat;
		this.field = field;
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
	public IField getField() {
		return this.field;
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
	
	@Override
	public String toString() {
		return "Record{Domain: " + this.getDomain().getName() + ";Category: " + this.getCategory().getName() + ";Sub-category: " + this.getSubCategory().getName() + ";Field: " + this.getField().getName() + ";Value: " + this.getValue() + "}";
	}

	
	
}
