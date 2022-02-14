package com.UtilityLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderData
{
	public static XSSFWorkbook workbook;

	public ExcelReaderData(String excelPath) {
		File f = new File(excelPath);
		try {
			FileInputStream fis = new FileInputStream(f);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getData(int sheetIndex, int rows, int cells) {
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		return sheet.getRow(rows).getCell(cells).getStringCellValue();
	}

	public int totalRows(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum();
	}

	public int totalColumns(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}

}
