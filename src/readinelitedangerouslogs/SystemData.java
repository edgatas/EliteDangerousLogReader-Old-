package readinelitedangerouslogs;

import java.io.Serializable;

public class SystemData implements Serializable{
    String timeStamp;
    String systemName;
    String coordinateX;
    String coordinateY;
    String coordinateZ;
    double distance;
    
    public SystemData(String timeStamp, String systemName,
            String coordinateX, String coordinateY, String coordinateZ,
            double distance){
        
        this.timeStamp = timeStamp;
        this.systemName = systemName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.distance = distance;
    }
    
    public String getTimeStamp(){
        return timeStamp;
    }
    
    public String getSystemName(){
        return systemName;
    }
    
    public String getCoordinateX(){
        return coordinateX;
    }
    
    public String getCoordinateY(){
        return coordinateY;
    }
    
    public String getCoordinateZ(){
        return coordinateZ;
    }
    
    public double getDistance(){
        return distance;
    }

    public int compareSystemNameTo(SystemData system){
        String compareSystemName = system.getSystemName();
        return this.systemName.compareTo(compareSystemName);
    }
    
    public int compareTimeStampTo(SystemData system){
        String compareSystemName = system.getTimeStamp();
        return this.timeStamp.compareTo(compareSystemName);
    }
    
    public int compareDistanceTo(SystemData system){
        double compareSystemName = system.getDistance();
        if (this.distance > compareSystemName)
            return 1;
        else{
            return -1;
        }
    } 
}
