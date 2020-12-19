package utilities;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
public class ZBLogging {
 
    public static Logger logger = Logger.getLogger (ZBLogging.class);
 
    public ZBLogging () 
    {
    	
        String log4j2ConfigFile = System.getProperty("user.dir")
                + File.separator + "src\\test\\resources\\Configuration\\log4j2.properties";
        PropertyConfigurator.configure(log4j2ConfigFile);
        
        logger.debug("*** Specifying log4j2 config properties file ***");
        
        logger.info("<< It was my pleasure being a part of this automation class >>");

  }
 
}

