package readinelitedangerouslogs;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author edgar
 * version 0.0.2
 */
public class ReadinEliteDangerousLogs extends Thread {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        LogFile.writeToLog("Program Started\n");
        Data.loadStartingData();
        Thread mainThread = new Thread();
        mainThread.start();
        MainFrame.main(args);
    }
}
