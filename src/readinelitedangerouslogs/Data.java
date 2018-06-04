
package readinelitedangerouslogs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Data {
    protected static TraveledSystemsData traveledSystems;
    protected static ModifiedTraveledSystemsData mTraveledSystems;
    public static int travelHistorySortByNameState = 0;
    public static int travelHistorySortByTimestampState = 0;
    public static int travelHistorySortByDistanceState = 0;
    
    
    public static void loadStartingData(){
        createTraveledSystemsList();
        createNewModifiedList();
    }
    
    public static void saveStartingData(){
        
    }

    private static void createTraveledSystemsList(){
        traveledSystems = new TraveledSystemsData();
        LogFile.writeToLog("New traveled systems list was created\n");
        try {
            ObjectDataManipulation.systemDataObjectRead();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createNewModifiedList(){
        mTraveledSystems = new ModifiedTraveledSystemsData();
    }
    
}
