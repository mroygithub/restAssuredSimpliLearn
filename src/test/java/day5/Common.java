package day5;

import com.aventstack.extentreports.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Common {

    public static void main(String[] args) {

        Students obj = new Students();
       // obj.Display_different_messages();

        Common CM = new Common();
        System.out.println(CM.read_PropertiesFile("url"));

    }





    public String read_PropertiesFile(String key){

        Properties prop = new Properties();
        String value=null;
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/global.properties"));
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
