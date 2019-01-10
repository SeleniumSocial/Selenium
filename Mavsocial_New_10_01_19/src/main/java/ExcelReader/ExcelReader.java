package ExcelReader;

import java.io.File;
import java.io.IOException;
import BusinessFunctions.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader extends TestBase{

	public String[][] readExcel(String excellocation, String sheetName) throws BiffException, IOException
	{
	File f= new File(excellocation);
	Workbook w=Workbook.getWorkbook(f);
	Sheet s=w.getSheet(sheetName);
	int rows=s.getRows();
	int columns=s.getColumns();
	//System.out.println(rows);
	//System.out.println(columns);
	String inputData[][]=new String[rows][columns];
	for(int i=0;i<rows;i++)
	{
	 for(int j=0;j<columns;j++)
	 {
		 Cell c=s.getCell(j, i);
		 inputData[i][j]=c.getContents();
		// System.out.println(inputData[i][j]);
	 }
	}
	return inputData;
	}

}