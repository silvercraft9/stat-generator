package writer;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements IWriter {

	private XSSFWorkbook workbook;
	private String filename;
	
	public ExcelWriter(String filename) {
		this.filename = filename;
		this.workbook = new XSSFWorkbook();
	}
	
	
	@Override
	public int write(ArrayList<ArrayList<String>> lines) {
		int res = 0; // 0 is the code for nothing written in a file
		//TODO
		return res;
	}

}
