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
	
}
