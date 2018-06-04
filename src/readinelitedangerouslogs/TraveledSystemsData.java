package readinelitedangerouslogs;

import java.util.ArrayList;
import java.util.List;

public class TraveledSystemsData {
    List<SystemData> traveledSystems;

    public TraveledSystemsData() {
        this.traveledSystems = new ArrayList<>();
    }
    
    public void addSystem(SystemData newSystem){
        this.traveledSystems.add(newSystem);
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
}

