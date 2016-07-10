package org.vsfamily.vslib.common.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * DateAndTime class, use for conversions between string and date.
 */
public class DateAndTime {

	public DateAndTime() {
		/*Calendar fromDate = Calendar.getInstance();
		System.out.println("\nfromDate: " + fromDate.getTime().toString());
		Calendar toDate = Calendar.getInstance();
		System.out.println("\ntoDate: " + toDate.getTime().toString());
		fromDate.add(Calendar.MONTH, 6);
		System.out.println("\nNew fromDate: " + fromDate.getTime().toString());
		toDate.add(Calendar.MONTH, 13);
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("\nNew toDate: " + toDate.getTime().toString());
		System.out.println("\nString of fromDate: " + this.getStringFromCalendar(fromDate));
		System.out.println("\nString with time of fromDate: " + this.getStringWithTimeFromCalendar(fromDate));
		System.out.println("\nNumber of completed days: " + this.getNumberOfCompletedDays(fromDate, toDate));
		System.out.println("\nNumber of completed months: " + this.getNumberOfCompletedMonths(fromDate, toDate));
		System.out.println("\nNumber of completed years: " + this.getNumberOfCompletedYears(fromDate, toDate));
		*/
	}
	
	public String paddedDayMonth(int xyz){
		if (xyz==0){
			return "00";
		}else if (xyz < 10){
			return "0" + xyz;
		} else {
			return "" + xyz;
		}
	}
	
	/**
	 * Fetches the string representation of the Calendar object.
	 * The format will be dd-MM-yyyy
	 * @param calendar the calendar object
	 * @return the string representation of the calendar object
	 */
	public String getStringFromCalendar(Calendar calendar){
		if (calendar == null){
			return "00-00-0000";
		} else {
			String str = "";
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			
			str = this.paddedDayMonth(day) + "-" + this.paddedDayMonth(month) + "-" + year;
			return str;
		}
		
	}
	

	/**
	 * Fetches the string representation of the Calendar object.
	 * The format will be dd-MM-yyyy HH:mm:ss
	 * @param calendar the calendar object
	 * @return the string representation of the calendar object
	 */
	public String getStringWithTimeFromCalendar(Calendar calendar){
		if (calendar == null){
			return "00-00-0000 00:00:00";
		} else {
			String str = "";
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			int hour = calendar.get(Calendar.HOUR);
			int min = calendar.get(Calendar.MINUTE);
			int sec = calendar.get(Calendar.SECOND);
			
			str = this.paddedDayMonth(day) 
					+ "-" + this.paddedDayMonth(month) 
					+ "-" + year
					+ " " + this.paddedDayMonth(hour)
					+ ":" + this.paddedDayMonth(min)
					+ ":" + this.paddedDayMonth(sec);
			return str;
		}
	}
	
	/**
	 * Gets date as Calendar object from string.
	 * @param calendar - the date in String form.
	 * @return the date as Calendar object
	 */
	public Calendar getCalendarFromString(String calendar){
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Calendar cal = Calendar.getInstance();
		Date date;
		
		try {
			date = dateFormat.parse(calendar);
			cal.setTime(date);
			return cal;
		} catch (Exception e){
			System.out.println("Calendar conversion error: " + e);
			return null;
		}
	}
	
	/**
	 * Gets date as Calendar object from string along with time.
	 * @param calendar - the date in String form
	 * @return the date as Calendar object
	 */
	public Calendar getCalendarFromStringWithTime(String calendar){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		Date date;
		
		try {
			date = dateFormat.parse(calendar);
			cal.setTime(date);
			return cal;
		} catch (Exception e){
			System.out.println("Calendar conversion error: " + e);
			return null;
		}
	}
	
	/**
	 * Gets the number of completed days between the two dates.
	 * @param fromDate - the from date
	 * @param toDate - the to date
	 * @return the number of days
	 */
	public int getNumberOfCompletedDays(Calendar fromDate, Calendar toDate){
		if (fromDate==null || toDate==null){
			return 0;
		} else {
			Calendar dt = Calendar.getInstance();
			dt.setTime(fromDate.getTime());
			
			Calendar dtTo = Calendar.getInstance();
			dtTo.setTime(toDate.getTime());
			
			int count = 0;
			while (this.compareDates(dt, dtTo) < 0){
				count ++;
				dt.add(Calendar.DAY_OF_YEAR, 1);
			}
			return count;
		}
	}
	
	/**
	 * Gets the number of completed months between the two dates.
	 * @param fromDate - the from date
	 * @param toDate - the to date
	 * @return the number of months
	 */
	public int getNumberOfCompletedMonths(Calendar fromDate, Calendar toDate){
		if (fromDate==null || toDate==null){
			return 0;
		} else {
			Calendar dt = Calendar.getInstance();
			dt.setTime(fromDate.getTime());
			
			Calendar dtTo = Calendar.getInstance();
			dtTo.setTime(toDate.getTime());
			
			int count = 0;
			while (this.compareDates(dt, dtTo) < 0){
				int dtYear = dt.get(Calendar.YEAR);
				int dtMonth = dt.get(Calendar.MONTH);
				int dtDay = dt.get(Calendar.DAY_OF_MONTH);
				
				int dtToYear = dtTo.get(Calendar.YEAR);
				int dtToMonth = dtTo.get(Calendar.MONTH);
				int dtToDay = dtTo.get(Calendar.DAY_OF_MONTH);
				
				if (dtYear == dtToYear && dtMonth == dtToMonth){
					if (dtDay < dtToDay){
						count++;
					}
				} else {
					count++;
				}
				//System.out.println(dt.getTime() + " ::: " + dtTo.getTime());
				//System.out.println("Count: " + count);
				dt.add(Calendar.MONTH, 1);
			}
			return count;
		}
	}
	
	/**
	 * Gets the number of completed years between the two dates.
	 * @param fromDate - the from date
	 * @param toDate - the to date
	 * @return the number of completed years
	 */
	public int getNumberOfCompletedYears(Calendar fromDate, Calendar toDate){
		return (int) this.getNumberOfCompletedMonths(fromDate, toDate)/12;
	}
	
	/**
	 * Compare the two dates.
	 * @param fd - the from date
	 * @param td - the to date
	 * @return 0 if both are same, -1 if from date is before to date, and 1 if from date is after to date
	 */
	public int compareDates(Calendar fd, Calendar td){
		
		int fdYear = fd.get(Calendar.YEAR);
		int fdMonth = fd.get(Calendar.MONTH);
		int fdDay = fd.get(Calendar.DAY_OF_MONTH);
		
		int tdYear = td.get(Calendar.YEAR);
		int tdMonth = td.get(Calendar.MONTH);
		int tdDay = td.get(Calendar.DAY_OF_MONTH);
		
		if (fdYear == tdYear && fdMonth == tdMonth && fdDay == tdDay){
			return 0;
		} else {
			if (fdYear == tdYear){
				if (fdMonth == tdMonth){
					if (fdDay == tdDay) {
						return 0;
					} else {
						if (fdDay < tdDay) return -1;
						return 1;
					}
				} else {
					if (fdMonth < tdMonth) return -1;
					return 1;
				}
				
			} else {
				if (fdYear < tdYear) return -1;
				return 1;
			}
		}
	}
}
