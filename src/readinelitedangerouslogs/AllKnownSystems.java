package readinelitedangerouslogs;

import java.util.ArrayList;
import java.util.List;

public class AllKnownSystems {

    List<SystemDataForAllSystems> allKnownSystems;

    public AllKnownSystems() {
        this.allKnownSystems = new ArrayList<>();
    }
    
    public void addSystem(SystemDataForAllSystems newSystem){
        this.allKnownSystems.add(newSystem);
    }
    
    public int listLength(){
        return this.allKnownSystems.size();
    }
    
    public void listClear(){
        this.allKnownSystems.clear();
    }
}
