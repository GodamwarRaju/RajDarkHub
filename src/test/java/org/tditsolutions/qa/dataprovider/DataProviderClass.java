package org.tditsolutions.qa.dataprovider;

import org.tditsolutions.qa.utils.ExcelReader;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider
    public Object[][] createAccount(){
        ExcelReader excelReader=new ExcelReader("AddAccount");
        return excelReader.getAllData();
    }
    @DataProvider
    public Object[][] updateAccount(){
        ExcelReader excelReader=new ExcelReader("AddAccount");
        return excelReader.getAllData();
    }

}
