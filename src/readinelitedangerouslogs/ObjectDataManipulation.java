
package readinelitedangerouslogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class ObjectDataManipulation extends Data {
    
    public static void systemDataObjectWrite() throws FileNotFoundException, IOException{
    
        LogFile.writeToLog("Saving traveled systems objects\n");
        MainFrame.processInfo.setText("Saving Travel History");
        TraveledSystemsData systemsList = Data.traveledSystems;
        FileOutputStream fos = new FileOutputStream("traveledSystems.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            int listLength = systemsList.listLength();
            
            for(int i = 0; i < listLength; i++){
                SystemData temp = systemsList.getSystemWithIndex(i);
                oos.writeObject(temp);
            }
        }
        LogFile.writeToLog("Saving of traveled systems objects completed\n");
        MainFrame.processInfo.setText("Saving Completed");
    }
    
    public static void systemDataObjectRead() throws FileNotFoundException, IOException, ClassNotFoundException{

        LogFile.writeToLog("Reading Objects from file for traveled systems\n");
        
        File check = new File("traveledSystems.ser");
        if (check.exists()){
            FileInputStream fis = new FileInputStream("traveledSystems.ser");
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (true){
                    Data.traveledSystems.addSystem((SystemData)ois.readObject());
                }
            }
            catch(java.io.EOFException e){
                LogFile.writeToLog("The end of the file is reachd\n");
            }
        LogFile.writeToLog("Reading of traveled systems objects completed\n");
        }
        else{
            LogFile.writeToLog("Traveled systems object file now found\n");
        }

    }
    
    public static void DeleteFile(){
        File check = new File("t.ser");
        check.delete();
        LogFile.writeToLog("Traveled systems object file was deleted\n");
    }
}
