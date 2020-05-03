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
		double res = 0.0;
		int size = records.size();
		for(int i = 0; i < size; i++) {
			IRecord record = records.get(i);
			ICategory currCategory = record.getCategory();
			IField currField = record.getField();
			if(currCategory.equals(category) && currField.equals(field)) {
				Double value = record.getValue();
				res += value;
			}
		}
		return res;
	}

	@Override
	public Double getAvgForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field) {
		double res = 0.0;
		int nbRecs = 0;
		int size = records.size();
		for(int i = 0; i < size; i++) {
			IRecord record = records.get(i);
			ICategory currCategory = record.getCategory();
			IField currField = record.getField();
			if(currCategory.equals(category) && currField.equals(field)) {
				Double value = record.getValue();
				res += value;
				nbRecs++;
			}
		}
		
		if(nbRecs > 0) {
			res = res / nbRecs;
		}
		
		return res;
	}

	@Override
	public Double getSumForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField field) {
		double res = 0.0;
		int size = records.size();
		for(int i = 0; i < size; i++) {
			IRecord record = records.get(i);
			IDomain currDomain = record.getDomain();
			ICategory currCategory = record.getCategory();
			IField currField = record.getField();
			if(currDomain.equals(domain) && currCategory.equals(category) && currField.equals(field)) {
				Double value = record.getValue();
				res += value;
			}
		}
		return res;
	}

	@Override
	public Double getAvgForDomainAndCategoryAndField(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField field) {
		double res = 0.0;
		int nbRecs = 0;
		int size = records.size();
		for(int i = 0; i < size; i++) {
			IRecord record = records.get(i);
			IDomain currDomain = record.getDomain();
			ICategory currCategory = record.getCategory();
			IField currField = record.getField();
			if(currDomain.equals(domain) && currCategory.equals(category) && currField.equals(field)) {
				Double value = record.getValue();
				res += value;
				nbRecs++;
			}
		}
		
		if(nbRecs > 0) {
			res = res / nbRecs;
		}
		
		return res;
	}

	@Override
	public Double getStdDrvForCategoryAndField(ArrayList<IRecord> records, ICategory category, IField field) {
		double res = 0.0;
		int nbRecs = 0;
		double avgValue = getAvgForCategoryAndField(records, category, field);
		int size = records.size();
		for(int i = 0; i < size; i++) {
			IRecord record = records.get(i);
			ICategory currCategory = record.getCategory();
			IField currField = record.getField();
			if(currCategory.equals(category) && currField.equals(field)) {
				Double value = record.getValue();
				Double derivation = (value - avgValue) * (value - avgValue);
				res += derivation;
				nbRecs++;
			}
		}
		
		if(nbRecs > 0) {
			res = Math.sqrt(res / nbRecs);
		}
		
		return res;
	}

	@Override
	public Double getRatioPercentForDomainAndCategory(ArrayList<IRecord> records, IDomain domain, ICategory category,
			IField part, IField total) {
		double res = 0.0;
		Double partSum = getSumForDomainAndCategoryAndField(records, domain, category, part);
		Double totalSum = getSumForDomainAndCategoryAndField(records, domain, category, total);
		
		if(totalSum > 0) {
			res = (partSum / totalSum) * 100;
		}
		
		return res;
	}

}
