package reusable;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;




public class FirstLof {
    static Logger log = Logger.getLogger(FirstLof.class);




    public static void main(String[] args) {
        //PropertiesConfigurator is used to configure logger from a properties file
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/resources/log4j.properties");
        //log the message to file

        log.info("TThis Test Case is PASS");
        log.info("TThis Test Case is FAIL");
    }
}