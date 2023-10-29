package migdal;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCasche {
	public final static String LOG_BENNY = "Bennyws logger : ";

	//protected static final Logger LOG = LogManager.getLogger();

	public static void main(String[] args) {
		
		Casche<String> cash = new Casche<>(100);
		
		for (int i = 0; i <= 1000; i++) {
			cash.put("="+i, " Loging test " + i);
			//LOG.error(LOG_BENNY + " Loging test " + i);
		}
		
		
		List<String> keys = cash.getKeys();
		System.out.println("size =" +keys.size());
		keys.stream().forEach(key -> System.out.println(key + ":" +cash.get(key)));

	}

}
