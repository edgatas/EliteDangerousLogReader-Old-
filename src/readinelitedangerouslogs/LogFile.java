
package readinelitedangerouslogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogFile {
    
    private static String currentLogName;
    private static boolean fileCreated = false;
    
    public static void writeToLog(String message){
        
        if (fileCreated == false){
            createLogFile();
        }
        File file = new File(currentLogName);
        FileWriter writer;
        try {
            writer = new FileWriter(file,true);
            writer.write(message);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LogFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createLogFile(){ 
        File file = new File(fileName());
        fileCreated = true;
        writeToLog("Log file created. Log name: "+currentLogName+"\n");
    }
    
    private static String fileName(){
        String fileName = "Log"+DateAndTimeCalculations.printCurrentTimeForFileNames()+".txt";
        currentLogName = fileName;
        return fileName;
    }

}
