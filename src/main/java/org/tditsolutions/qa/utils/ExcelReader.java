package org.tditsolutions.qa.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    XSSFWorkbook workbook;
    FileInputStream fis;
    XSSFSheet sheet;

    public static String path ="\\src\\test\\resources\\testdata";

    public ExcelReader(String sheetName)
    {
        try {
            String basePath = System.getProperty("user.dir");
            String fullPath = basePath +path;
            fis = new FileInputStream(fullPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public int getRowNum()
    {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColNum()
    {
        return sheet.getRow(0).getLastCellNum();
    }


    public List<Object> getRowData(int rowNum)
    {
        List<Object> list = new ArrayList<Object>();

        XSSFRow row = sheet.getRow(rowNum);

        for(int j=0; j<getColNum(); j++)
        {

            list.add(row.getCell(j).getNumericCellValue());
        }

        return list;
    }


    public Object[][] getAllData()
    {
        Object[][] obj = new Object[getRowNum()-1][getColNum()];

        for(int i=1; i<getRowNum();i++)
        {
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<getColNum();j++)
            {
                obj[i-1][j] = row.getCell(j).toString();
            }
        }

        return obj;
    }
}
