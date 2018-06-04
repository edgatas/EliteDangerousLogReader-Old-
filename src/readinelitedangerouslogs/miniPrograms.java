package readinelitedangerouslogs;

import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author edgar
 * Version 0.0.3
 */
public class miniPrograms {
    
    /**
     * Method will take 2 systems and return the distance between those two
     * systems
     * @param systemName1 String
     * @param systemName2 String
     * @return double  
     */
    public static double getDistanceBetweenSystems(String systemName1, String systemName2){
        
        SystemData system1 = Data.traveledSystems.getSystemData(systemName1);
        SystemData system2 = Data.traveledSystems.getSystemData(systemName2);
        
        BigDecimal[] system1Coordinates = miniPrograms.getSystemCoordinates(system1);
        BigDecimal[] system2Coordinates = miniPrograms.getSystemCoordinates(system2);
        
        Double distance = 0000.00;
        if (system1Coordinates==null || system2Coordinates==null){
            if (system1Coordinates==null){
                LogFile.writeToLog("System: "+systemName1+" does not exist or does not have known coordiantes");
                MainFrame.processInfo.setText("System: "+systemName1+" does not exist or does not have known coordiantes");
            }
            else{
                LogFile.writeToLog("System: "+systemName2+" does not exist or does not have known coordiantes");
                MainFrame.processInfo.setText("System: "+systemName2+" does not exist or does not have known coordiantes");
            }
        }
        else{
            distance = Calculations.distanceCalculation(system1Coordinates[0], system1Coordinates[1], system1Coordinates[2]
                , system2Coordinates[0], system2Coordinates[1], system2Coordinates[2]);
            MainFrame.processInfo.setText("The distance between "+systemName1+" and "+systemName2+" is "+distance+"ly");
        }
        return distance;
    }

    // Check for aposthrophe to work with databases. Security issue
    public static String checkForApostrophe(String systemName){
        if (systemName.contains("\'")){
            systemName = systemName.replace("\'", "\''");
        }
        return systemName;
    }
    
    // Changing back the double aposthrophe to single one. Security issue 
    public static String returnToOriginalNameWithApostrophe(String systemName){
        if (systemName.contains("\'\'")){
            systemName = systemName.replace("\'\'", "\'");
        }
        return systemName;
    }
    
    /**
     * Getting system coordinates in a BigDecimal array
     * @param system SystemData
     * @return BigDecimal array
     */
    public static BigDecimal[] getSystemCoordinates(SystemData system){
        BigDecimal coordinates[] = new BigDecimal[3];
        coordinates[0] = new BigDecimal(system.coordinateX);
        coordinates[1] = new BigDecimal(system.coordinateY);
        coordinates[2] = new BigDecimal(system.coordinateZ);
        return coordinates;
    }
}
