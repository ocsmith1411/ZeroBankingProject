package rough;

import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import org.apache.logging.log4j.message.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingWithLog4j {

	public static Logger logger = LogManager.getLogger(rough.LoggingWithLog4j.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println("Hello World this is a test");	

    logger.trace("This is a trace");
	logger.info("This is information message");
    logger.warn("This is a warning");
    logger.error("This is Error message");
    logger.fatal("This is a fatal message");
    
    System.out.println("This test is now completed");
    
    
	}
}