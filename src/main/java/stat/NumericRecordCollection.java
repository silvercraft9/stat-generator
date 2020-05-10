/**
 * 
 */
package stat;

import java.util.ArrayList;

import core.ICategory;
import core.IDomain;
import core.IField;
import core.IRecord;
import core.Record;

/**
 * @author ro6k4
 *
 */
public class NumericRecordCollection implements IRecorderCollection {
	
	public ArrayList<IRecord> records;
	
	public NumericRecordCollection() {
		this.records = new ArrayList<IRecord>();
	}
	
	@Override
	public void addRecord(IRecord record) {
		this.records.add(record);
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForDomain(IDomain domain) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			IDomain currDomain = currRecord.getDomain();
			if(currDomain.equals(domain)) {
				result.add(currRecord);
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForCategory(ICategory category) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			ICategory currCategory = currRecord.getCategory();
			if(currCategory.equals(category)) {
				result.add(currRecord);
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForField(IField field) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			IField currField = currRecord.getField();
			if(currField.equals(field)) {
				result.add(currRecord);
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForDomainAndCategory(IDomain domain, ICategory category) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			IDomain currDomain = currRecord.getDomain();
			ICategory currCategory = currRecord.getCategory();
			if(currDomain.equals(domain) && currCategory.equals(category)) {
				result.add(currRecord);
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForDomainAndField(IDomain domain, IField field) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			IDomain currDomain = currRecord.getDomain();
			IField currField = currRecord.getField();
			if(currDomain.equals(domain) && currField.equals(field)) {
				result.add(currRecord);
			}
		}
		return result;
	}

	@Override
	public ArrayList<IRecord> getAllRecordsForDomainAndCategoryAndField(IDomain domain, ICategory category,
			IField field) {
		ArrayList<IRecord> result = new ArrayList<IRecord>();
		int n = this.records.size();
		for(int i = 0; i < n; i++) {
			IRecord currRecord = this.records.get(i);
			IDomain currDomain = currRecord.getDomain();
			ICategory currCategory = currRecord.getCategory();
			IField currField = currRecord.getField();
			if(currDomain.equals(domain) && currCategory.equals(category) && currField.equals(field)) {
				result.add(currRecord);
			}
		}
		return result;
	}
	
	@Override
	public Double getValueForDomainAndCategoryAndField(IDomain domain, ICategory category, IField field) {
		Double result = 0.0;
		ArrayList<IRecord> records = this.getAllRecordsForDomainAndCategoryAndField(domain, category, field);
		int nbRecords = records.size();
		for(int i = 0; i < nbRecords; i++) {
			Double value = records.get(i).getValue();
			result += value;
		}
		return result;
	}

	@Override
	public void addRatioCategory(IField field, IField part, IField total, IDomain domain, ArrayList<ICategory> categories) {
		
		int n = categories.size();
		for(int i = 0; i < n; i++) {
			ICategory category = categories.get(i);
			
			
			Double partValue = this.getValueForDomainAndCategoryAndField(domain, category, part);
			Double totalValue = this.getValueForDomainAndCategoryAndField(domain, category, total);
			
			Double resValue = partValue / totalValue;
			IRecord record = new Record(domain, category, null, field, resValue);
			this.addRecord(record);
		}
	}

	@Override
	public void addPercentRatioCategory(IField field, IField part, IField total, IDomain domain, ArrayList<ICategory> categories) {
		int n = categories.size();
		for(int i = 0; i < n; i++) {
			ICategory category = categories.get(i);
			
			
			Double partValue = this.getValueForDomainAndCategoryAndField(domain, category, part);
			Double totalValue = this.getValueForDomainAndCategoryAndField(domain, category, total);
			
			Double resValue = 100 * (partValue / totalValue);
			IRecord record = new Record(domain, category, null, field, resValue);
			this.addRecord(record);
		}
	}
	
}
