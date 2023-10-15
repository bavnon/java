package analog;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BaseTime {
	static Calendar calendar = GregorianCalendar.getInstance();

	public BaseTime() {
		calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(new Date()); // assigns calendar to given date
		calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		calendar.get(Calendar.HOUR); // gets hour in 12h format
		calendar.get(Calendar.MONTH); // gets month number, NOTE this is zero based!
	}

	public static int getHour() {
		calendar.setTime(new Date());
		return calendar.get(Calendar.HOUR);
	}

	public static int getMinute() {
		calendar.setTime(new Date());
		return calendar.get(Calendar.MINUTE);
	}

	public static int getSecond() {
		calendar.setTime(new Date());
		return calendar.get(Calendar.SECOND);
	}
}