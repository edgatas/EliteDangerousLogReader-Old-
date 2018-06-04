package readinelitedangerouslogs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author edgar
 */
public class DateAndTimeCalculations {
    
    
    /**
     * Method will return current date and time
     * @return String with format yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateWithFormat(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long currentTime = date.getTime();
        String currentDate = dateFormat.format(currentTime);
        return currentDate;
    }
    
    /**
     * Method will return Calendar type of date and convert it to String
     * @param date of type Calendar
     * @return String with format yyyy-MM-dd HH:mm:ss
     */
    public static String calendarToDateWithFormat(Calendar date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tempDate = date.getTime();
        String currentDate = dateFormat.format(tempDate);
        return currentDate;
    }
    
    
    /**
     * Method will take year, month and day and will add them to a string
     * @param year 
     * @param month
     * @param day
     * @return String with format yyyy-MM-dd
     */
    public static String modifyWithZeroes(long year, long month, long day){
        String date;
        if (month < 10){
            if(day <10){
                date = year+"-0"+month+"-0"+day;
            }
            else{
                date = year+"-0"+month+"-"+day;
            }
        }
        else{
            if(day <10){
                date = year+"-"+month+"-0"+day;
            }
            else{
                date = year+"-"+month+"-"+day;
            }
        }
        return date;
    }
    
    /**
     * Specific method for Elite Dangerous logs name to extract date from it's
     * number substring of the name.
     * @param fullDate long
     * @return long[] with year, month and day in order
     */
    public static long[] fileNameToDate(long fullDate){
        long date[] = new long[3];
        date[0] = ((fullDate / 100000)/100000)+2000;
        date[1] = (fullDate/100000000)%100;
        date[2] = (fullDate/1000000)%100;
        return date;
    }
    
    /**
     * This methods compares 2 given times and will return true if the day 
     * have changed. Method compares hours of time and if second one is smaller, it
     * will be considered as a day change.
     * CAUTION:
     * This method is intended to work correctly only when the game was running
     * while the day have changed
     * @param time1
     * @param time2
     * @return boolean
     */
    public static boolean checkDayChange(String time1, String time2){
        int hour1 = Integer.parseInt(time1.substring(0, 2));
        int hour2 = Integer.parseInt(time2.substring(0, 2));
        return hour1<hour2;
    }
    
    /**
     * Method to get current date and time for file names. 
     * @return String of type yyyyMMddHHmmss
     */
    public static String printCurrentTimeForFileNames(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        long currentTime = date.getTime();
        String currentDate = dateFormat.format(currentTime);
        return currentDate;
    }
    
}
