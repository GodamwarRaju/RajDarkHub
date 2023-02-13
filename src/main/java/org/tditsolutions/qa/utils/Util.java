package org.tditsolutions.qa.utils;

import org.testng.asserts.SoftAssert;

import java.util.List;

public class Util {
    public static SoftAssert compareList(List<String> actualList,List<String> expectedList){
        SoftAssert softAssert=new SoftAssert();
        for (int i=0;i<expectedList.size();i++){
            try
            {
                softAssert.assertEquals(actualList,expectedList);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return softAssert;
    }
}
