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
public class NumericStatGenerator implements IStatGenerator {

	@Override
	public Double getSumForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAvgForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSumForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAvgForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getStdDrvForDomainAndCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getRatioPercentForDomainAndCategory(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField part, IField total) {
		// TODO Auto-generated method stub
		return null;
	}

}
