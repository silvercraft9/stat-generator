package writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.IField;

public class ExcelWriter implements IWriter {

	private XSSFWorkbook workbook;
	private String filename;
	
	public ExcelWriter(String filename) {
		this.filename = filename;
		this.workbook = new XSSFWorkbook();
	}
	
	
	@Override
	public int writeData(ArrayList<ArrayList<Object>> lines) {
		XSSFSheet sheet = workbook.createSheet("Données");
		int res = 0; // 0 is the code for nothing written in a file
		int n = lines.size();
		for(int i = 0; i < n; i++) {
			ArrayList<Object> line = lines.get(i);
			int m = line.size();		
			int lineIndex = i + 1;
			Row row = sheet.createRow(lineIndex);
			for(int j = 0; j < m; j++) {
				int columnIndex = j + 1; 
				Object value = line.get(j);
				Cell cell = row.createCell(columnIndex);
                if (value instanceof String) {
                    cell.setCellValue((String) value);
                } else if (value instanceof Double) {
                    cell.setCellValue((Double) value);
                }
			}
		}
		
		try {
			FileOutputStream outputStream = new FileOutputStream(this.filename);
			workbook.write(outputStream);
			workbook.close();
			res = 1; // 1 is the code when everything went right
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}


	@Override
	public ArrayList<Object> getFieldNames(ArrayList<IField> fields) {
		ArrayList<Object> res = new ArrayList<Object>();
		int n = fields.size();
		for(int i = 0; i < n; i++) {
			IField field = fields.get(i);
			String name = field.getName();
			res.add(name);
		}
		
		return res;
	}

}
