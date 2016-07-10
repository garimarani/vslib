package org.vsfamily.vslib.web.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 * Calendar formatter, used for converting String to Calendar and Calendar to String the variables received / supplied to the pages.
 */
@Component
public class CalendarFormatter implements Formatter<Calendar> {

	@Override
	public String print(Calendar cal, Locale arg1) {
		if (cal == null)
			cal = Calendar.getInstance();
		DateTime dt = new DateTime(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));
		return dt.toString("dd-MM-yyyy");
	}

	@Override
	public Calendar parse(String str, Locale arg1) throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		date = (Date) formatter.parse(str);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
