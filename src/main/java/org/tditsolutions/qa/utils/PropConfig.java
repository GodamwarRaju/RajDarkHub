package org.tditsolutions.qa.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropConfig {
    private static PropConfig propConfig;
    private PropConfig()
    {

    }

    public static PropConfig getInstance()
    {
        if(propConfig==null)
        {
            propConfig = new PropConfig();
            return propConfig;
        }
        else
        {
            return propConfig;
        }
    }

    public static Properties load_prop(String env) throws IOException
    {
        String fullPath="";
        if(env.equals("QA"))
        {
            String basePath=System.getProperty("user.dir");
            System.out.println(basePath);
            fullPath=basePath+"\\src\\main\\resources\\config\\qa.config.properties";
            System.out.println(fullPath);

        }
        else if (env.equals("UAT"))
        {
            String basePath=System.getProperty("user.dir");
            System.out.println(basePath);
            fullPath=basePath+"\\src\\main\\resources\\config\\uat.config.properties";
            System.out.println(fullPath);
        }
        else
        {
            System.out.println("Please enter correct Env name: [QA, UAT]");
            System.exit(0);
        }

        FileReader file = new FileReader(new File(fullPath));
        Properties prop =new Properties();
        prop.load(file);
        return prop;
    }
}
