package readinelitedangerouslogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edgar
 */
public class ModifiedTraveledSystemsData{
    List<SystemData> traveledSystems;
        
    int state = 0;
    
    public ModifiedTraveledSystemsData() {
        this.traveledSystems = new ArrayList<>(Data.traveledSystems.listLength());
        
        for (SystemData system: Data.traveledSystems.traveledSystems){
            this.traveledSystems.add(system);
        }
    }
    
    public int listLength(){
        return this.traveledSystems.size();
    }
    
    public void listClear(){
        this.traveledSystems.clear();
    }
    
    
    /**
     * Get system data of a given system name
     * @param systemName String
     * @return SystemData
     */
    public SystemData getSystemData(String systemName){
        SystemData data = null;
        
        for(SystemData system: this.traveledSystems){
            if(system.systemName.equals(systemName)){
                data = system;
            }
        }
        return data;
    }
    
    public String[] getSystemNames(){
        int arrayLength = Data.mTraveledSystems.listLength();
        if (arrayLength == 0){
            return null;
        }
        else{
            String allSystemNames[] = new String[arrayLength];
            int i = 0;
            for (SystemData system: this.traveledSystems){
                allSystemNames[i] = system.systemName;
                i++;
            }
            return allSystemNames;
        }
    }

    public String[][] getDataToLogTable(){
        int arrayLength = Data.mTraveledSystems.listLength();
        if (arrayLength == 0){
            return null;
        }
        else{
            String dataForTable[][] = new String[arrayLength][3];
            int i = 0;
            int j = 0;
            for (SystemData system: this.traveledSystems){
                dataForTable[i][j] = system.getSystemName();
                dataForTable[i][j+1] = system.getTimeStamp();
                dataForTable[i][j+2] = String.valueOf(system.getDistance());
                i++;
            }
            return dataForTable;
        }
    }
    
    public boolean timeStampExists(String timeStamp){
        if (Data.mTraveledSystems.listLength() == 0){
            return false;
        }
        else{
            return this.traveledSystems.stream().anyMatch((system) -> (system.getTimeStamp().equals(timeStamp)));
        }
    }
    /**
     * Method will return a system data in a specified place in the list
     * @param index
     * @return SystemData
     */
    public SystemData getSystemWithIndex(int index){
        return this.traveledSystems.get(index);
    }
    
    public void SortBySystemName(){
        if(Data.travelHistorySortByNameState == 0){
            Collections.sort(traveledSystems, SystemData::compareSystemNameTo);
            Data.travelHistorySortByNameState = 1;
            MainFrame.processInfo.setText("Systems sorted alphabetic order");
        }
        else{
            Collections.sort(traveledSystems, (SystemData o1, SystemData o2) -> o2.compareSystemNameTo(o1));
            Data.travelHistorySortByNameState = 0;
            MainFrame.processInfo.setText("Systems sorted reverse alphabetic order");
        }
    }
    
    public void SortByTimeStamp(){
        if(Data.travelHistorySortByTimestampState == 0){
            Collections.sort(traveledSystems, SystemData::compareTimeStampTo);
            Data.travelHistorySortByTimestampState = 1;
            MainFrame.processInfo.setText("Systems sorted by visit date");
        }
        else{
            Collections.sort(traveledSystems, (SystemData o1, SystemData o2) -> o2.compareTimeStampTo(o1));
            Data.travelHistorySortByTimestampState = 0;
            MainFrame.processInfo.setText("Systems sorted by reverse visit date");
        }
    }
    
    public void SortByDistance(){
        if(Data.travelHistorySortByDistanceState == 0){
            Collections.sort(traveledSystems, SystemData::compareDistanceTo);
            Data.travelHistorySortByDistanceState = 1;
            MainFrame.processInfo.setText("Systems sorted by jump distance (increasing)");
        }
        else{
            Collections.sort(traveledSystems, (SystemData o1, SystemData o2) -> o2.compareDistanceTo(o1));
            Data.travelHistorySortByDistanceState = 0;
            MainFrame.processInfo.setText("Systems sorted by jump distance (decreasing)");
        }
    }
    
    public void filterByTime(String timeStamp){
        Data.mTraveledSystems.traveledSystems.clear();
        for (SystemData system: Data.traveledSystems.traveledSystems){
            String timeStamp2 = system.getTimeStamp();
            System.out.println(timeStamp+" "+timeStamp2+" > 0   "+timeStamp.compareTo(timeStamp2));
            if(timeStamp.compareTo(timeStamp2)< 0){
                Data.mTraveledSystems.traveledSystems.add(system);
            }
        }
    }
}
