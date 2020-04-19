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
public interface IStatGenerator {
	
	/**
	 * 
	 * @param records
	 * @param category
	 * @param field
	 * @return
	 */
	public Double getSumForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field);
	
	/**
	 * 
	 * @param records
	 * @param category
	 * @param field
	 * @return
	 */
	public Double getAvgForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field);
	
	/**
	 * 
	 * @param records
	 * @param domain
	 * @param category
	 * @param field
	 * @return
	 */
	public Double getSumForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category, IField field); 

	/**
	 * 
	 * @param records
	 * @param domain
	 * @param category
	 * @param field
	 * @return
	 */
	public Double getAvgForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category, IField field);
	
	/**
	 * 
	 * @param records
	 * @param category
	 * @param field
	 * @return
	 */
	public Double getStdDrvForDomainAndCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field);
	
	/**
	 * 
	 * @param records
	 * @param domain
	 * @param category
	 * @param part
	 * @param total
	 * @return
	 */
	public Double getRatioPercentForDomainAndCategory(ArrayList<IRecord> records, IDomain domain, ICategory category, IField part, IField total);
}
