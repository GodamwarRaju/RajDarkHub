package org.tditsolutions.qa.utils;

import java.io.IOException;
import java.util.Properties;

public class TestClass {
    public static void main(String[] args) throws IOException {
//        PropConfig propConfig = PropConfig.getInstance();
//        Properties prop = propConfig.load_prop("QA");
//
//        System.out.println(prop.get("app_url"));
//        System.out.println(prop.get("username"));
        String basePath=System.getProperty("user.dir");
        String filePath="\\src\\test\\resources\\testdata";
        String fullPath=basePath+filePath;
        System.out.println(fullPath);
        ExcelReader excelReader=new ExcelReader(fullPath);
        Object obj[][]=excelReader.getAllData();
        for (int i=0;i< obj.length;i++){
            for (int j=0;j<obj[0].length;j++){
                System.out.println(obj[i][j]);
            }
        }

    }

}
