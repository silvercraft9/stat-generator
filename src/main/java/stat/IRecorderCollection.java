/**
 * 
 */
package stat;

import java.util.ArrayList;

import core.ICategory;
import core.IDomain;
import core.IField;
import core.IRecord;

/**
 * @author ro6k4
 *
 */
public interface IRecorderCollection {
	
	/**
	 * 
	 * @param record a record to add in the collection
	 */
	public void addRecord(IRecord record);
	
	/**
	 * 
	 * @param domain the domain to consider
	 * @return This method returns all records associated to this domain
	 */
	public ArrayList<IRecord> getAllRecordsForDomain(IDomain domain);
	
	/**
	 * 
	 * @param category the category to  consider
	 * @return This method returns all records associated to this category
	 */
	public ArrayList<IRecord> getAllRecordsForCategory(ICategory category);
	
	/**
	 * 
	 * @param field the field to consider
	 * @return This method returns all records associated to this field
	 */
	public ArrayList<IRecord> getAllRecordsForField(IField field);
	
	/**
	 * 
	 * @param domain the domain to consider
	 * @param category the category to consider
	 * @return This method returns all records associated to the domain and only the category to consider
	 */
	public ArrayList<IRecord> getAllRecordsForDomainAndCategory(IDomain domain, ICategory category);
	
	/**
	 * 
	 * @param domain the domain to consider
	 * @param field the field to consider
	 * @return This method returns all records associated to the domain and only the field to consider
	 */
	public ArrayList<IRecord> getAllRecordsForDomainAndField(IDomain domain, IField field);
	
	/**
	 * 
	 * @param domain the domain to consider
	 * @param category the category to consider
	 * @param field the category to consider
	 * @return This method returns all records associated to the domain and only the category and the field to consider
	 */
	public ArrayList<IRecord> getAllRecordsForDomainAndCategoryAndField(IDomain domain, ICategory category, IField field);

}