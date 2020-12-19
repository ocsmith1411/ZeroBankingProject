package rough;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
public class PropertiesFileLog4jExample {
 
    static Logger logger = Logger.getLogger(PropertiesFileLog4jExample.class);
 
    public static void main(String[] args) {
        String log4j2ConfigFile = System.getProperty("user.dir")
                + File.separator + "src\\test\\resources\\Configuration\\log4j2.properties";
        PropertyConfigurator.configure(log4j2ConfigFile);
        logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
        logger.error("this is a error log message");
    }
 
}