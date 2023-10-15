package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* demonstrate log4 j */
public class LoggerTest {
	
	public final static String LOG_BENNY = "Bennyws logger : ";

	   protected static final Logger LOG = LogManager.getLogger(); 
	public static void main(String[] args) {
			for (int i=0; i < 100; i++) {
				LOG.error(LOG_BENNY+ " Loging test " +i);
			}
 
	}

}
