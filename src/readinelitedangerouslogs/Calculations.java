package readinelitedangerouslogs;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.util.Calendar;

/**
 *
 * @author edgar
 * Version 0.0.3
 */
public class Calculations {
    
    
    // This is a methods to make number fit in 8 bit space. This make no changed
    // for this program, but developers of the game are saving their space using
    // this way of storing data
    public static Double precisionCalculation(Double coordinates){
        Long tempCoordinates  = Math.round(coordinates*32);
        Double newCoordinates = (double)tempCoordinates/32;
        return newCoordinates;
    }
    
    private static final BigDecimal TWO = BigDecimal.valueOf(2);
    
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);
        }
        return x1;
    }
    
    public static Double distanceCalculation(BigDecimal x1,BigDecimal y1,BigDecimal z1,BigDecimal x2,BigDecimal y2,BigDecimal z2){
            // Taking the difference between 2 coordinates
            BigDecimal difx = x1.subtract(x2);
            BigDecimal dify = y1.subtract(y2);
            BigDecimal difz = z1.subtract(z2);

            // Multiplaying differneces to start calculating distance 
            BigDecimal tempDistanceX = difx.multiply(difx);
            BigDecimal tempDistanceY = dify.multiply(dify);
            BigDecimal tempDistanceZ = difz.multiply(difz);
            
            // Adding all the distances together
            BigDecimal tempDistance = tempDistanceX.add(tempDistanceY).add(tempDistanceZ);
            
            // Taking the root to get the distance with format.
            BigDecimal distance2 = Calculations.sqrt(tempDistance, 2);
            Double distance = distance2.doubleValue();
            return distance;
    }
    
    public static double calculatingStarDistance(double giveX1, double giveY1, double giveZ1, double giveX2, double giveY2, double giveZ2){
        
        // if there are no previous systems
        Double distance = 0.00;

        BigDecimal x1 = new BigDecimal(giveX1);
        BigDecimal y1 = new BigDecimal(giveY1);
        BigDecimal z1 = new BigDecimal(giveZ1);

        // Converting doubles to BigDecimals with new coordinates
        BigDecimal x2 = new BigDecimal(giveX2);
        BigDecimal y2 = new BigDecimal(giveY2);
        BigDecimal z2 = new BigDecimal(giveZ2);

        distance = Calculations.distanceCalculation(x1, y1, z1, x2, y2, z2);
        return distance;
    }
    
    public static String timeFrameToDateStamp(String timeFrame){
        
        Calendar currentDate = Calendar.getInstance();
        
        switch(timeFrame){
            case "All":
                currentDate.add(Calendar.YEAR, -3);
                break;
            case "3 Months":
                currentDate.add(Calendar.MONTH, -3);
                break;
            case "1 Month":
                currentDate.add(Calendar.MONTH, -1);
                break;
            case "2 Weeks":
                currentDate.add(Calendar.DATE, -14);
            case "1 Week":
                currentDate.add(Calendar.DATE, -7);
                break;
            case "3 Days":
                currentDate.add(Calendar.DATE, -3);
                break;
            case "1 Day":
                currentDate.add(Calendar.DATE, -1);
                break;
            case "12 Hours":
                currentDate.add(Calendar.HOUR, -12);
                break;
            case "3 Hour":
                currentDate.add(Calendar.HOUR, -3);
                break;
        }
        
        String dateStamp = DateAndTimeCalculations.calendarToDateWithFormat(currentDate);
        return dateStamp;
    }
}
