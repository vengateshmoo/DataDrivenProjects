package bestdatadriven_examples;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoIJarExcelData {
	
	
	public void readExcelFile() throws IOException {
		FileInputStream excelfile=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\DataDrivenNotes\\ApachepoiInput.xlsx");
	Workbook workbook =new XSSFWorkbook(excelfile);
	Sheet sheet =workbook.getSheetAt(0);
	sheet.iterator();
	
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
	

}
