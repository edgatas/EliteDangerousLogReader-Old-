package readinelitedangerouslogs;

import java.io.Serializable;

public class SystemDataForAllSystems implements Serializable{
    String systemName;
    String coordinateX;
    String coordinateY;
    String coordinateZ;
    
    public SystemDataForAllSystems(String timeStamp, String systemName,
            String coordinateX, String coordinateY, String coordinateZ,
            double distance){
        
        this.systemName = systemName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
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
}
