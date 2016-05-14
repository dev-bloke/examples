package com.meridal.itunes.helper;

/**
 * Time format helper.
 * For album / track times, this is simpler and more flexible than using Date and DateFormat objects.
 * @author Martin Ingram
 */
public class TimeHelper {
	
	private static final int MINS = 60000;
	private static final int HOURS = 3600000;
	
	private TimeHelper() {
	}
	
	public static String getTimeFromMillis(Integer millis) {
		String result = "0:00";
		if (millis != null) {
			if (millis < HOURS) {
				result = getMinsTimeFromMillis(millis);
			}
			else {
				result = getHoursTimeFromMillis(millis);
			}
		}
		return result;
	}
	
	public static String getMinsTimeFromMillis(Integer millis) {
		String result = "0:00";
		if (millis != null) {
			int mins = millis / MINS;
			int secs = (millis % MINS) / 1000;
			StringBuilder sb = new StringBuilder()
			    .append(mins)
				.append(':');
			if (secs < 10) {
				sb.append('0');
			}
			sb.append(secs);
			result = sb.toString();
		}
		return result;
	}
	
	public static String getHoursTimeFromMillis(Integer millis) {
		String result = "0:00:00";
		if (millis != null) {
			int hours = millis / HOURS;
			int minMillis = millis % HOURS;
			String mins = getMinsTimeFromMillis(minMillis);
			StringBuilder sb = new StringBuilder()
				.append(hours)
				.append(':');
			if (mins.length() < 5) {
				sb.append('0');
			}
			sb.append(mins);
			result = sb.toString();
		}
		return result;
	}

}
