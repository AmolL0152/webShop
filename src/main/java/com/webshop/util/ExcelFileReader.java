package com.webshop.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	private File file;
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private int numberOfRows = 0;
	private int numberOfCell = 0;
	private Row row;
	private Cell cell;
	
	
	/* Methos used to load data text file
	 * @author - Amol
	 * 
	 */
	public void loadTestDataFile() throws Exception{
		
		file = new File("../webShop/testdata/testData.xlsx");
		setFis(new FileInputStream(file));
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheetAt(0);		
	}
	
	/* Methos used to retreievd username field
	 * @author - Amol
	 * 
	 */
	public String getUserName() throws Exception {
		
			loadTestDataFile();
			numberOfRows = sheet.getLastRowNum();
			for(int i =0; i<numberOfRows;i++){
				row = sheet.getRow(i);
				numberOfCell = row.getLastCellNum();
				for (int j=0;j<numberOfCell;j++){
					cell = row.getCell(j);
					if(cell.getStringCellValue().equals("UserName"))
						return row.getCell(j+1).getStringCellValue();
				}
			}
			return null;				
	}

	public String getPassword() throws Exception {
		
		loadTestDataFile();
		numberOfRows = sheet.getLastRowNum();
		for(int i =0; i<numberOfRows;i++){
			row = sheet.getRow(i);
			numberOfCell = row.getLastCellNum();
			for (int j=0;j<numberOfCell;j++){
				cell = row.getCell(j);
				if(cell.getStringCellValue().equals("Password"))
					return row.getCell(j+1).getStringCellValue();
			}
		}
		return null;				
}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfCell() {
		return numberOfCell;
	}

	public void setNumberOfCell(int numberOfCell) {
		this.numberOfCell = numberOfCell;
	}

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
}
