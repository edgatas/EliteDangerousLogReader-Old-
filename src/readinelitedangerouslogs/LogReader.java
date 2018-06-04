package readinelitedangerouslogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author edgar
 * version 0.2.0
 * time     14s
 */
public class LogReader {
    
    public static TraveledSystemsData traveledSystems;
    
    public static void LogReading(){
        // Address to the folder
        String address = "C:\\edgatas\\Programs\\Steam\\steamapps\\common\\Elite Dangerous\\Products\\elite-dangerous-64\\logs";
        LogFile.writeToLog("Reading logs from: "+address+"\n");
        File folder = new File(address);
        // Adding all names of the files to an array
        String[] fileName = folder.list();
        // Getting the length of the array
        int numberOfFiles = fileName.length;
        
        // Counting the number of operations
        // This number is send to database operations to know if it is the first run of the program
        int i = 0;
        
        traveledSystems = new TraveledSystemsData();
        String date;
        String time;
        String systemName;
        String systemNameCheck = "";
        Double coordinateX;
        Double xCheck = null;
        Double coordinateY;
        Double yCheck = null;
        Double coordinateZ;
        Double zCheck = null;
        Double distance;
        distance = Double.parseDouble("0.00");
        String timeStamp;
        String previousTime = null;
        long dateArray[];
        boolean firstTimeCheck = true;
        boolean nextFile = false;
        
        
        
        // Delimiters for extracting wanted information from the line
        final String DELIMITER2 = "\\.";
        final String DELIMITER3 = "\"";
        final String DELIMITER4 = "\\(";
        final String DELIMITER5 = ",";
        final String DELIMITER6 = "\\)";
        final String DELIMITER7 = "\\{";
        final String DELIMITER8 = "\\}";
        
        // Every string in the array is going to be placed in the path 
        for (int t = 0;t<(numberOfFiles);t++){

            // Check the file name if it starts with netLog to read only
            // nessessary files.
            if (fileName[t].startsWith("netLog")){
                
                Path fileAddress = Paths.get(address+"\\"+fileName[t]);
                
                LogFile.writeToLog("Reading: "+fileName[t]+"\n");
                MainFrame.processInfo.setText("Reading: "+(t+1)+"/"+numberOfFiles+" "+fileName[t]);
                try {
                    // Trying to read the file name
                    Scanner fileScan = new Scanner (fileName[t]); 
                    
                    // Skipping unnecessary data
                    fileScan.useDelimiter(DELIMITER2);
                    fileScan.skip("netLog.");
                    
                    // Taking the number from the name and extracting year,
                    // month and day from it.
                    long dateCode = fileScan.nextLong();
                    dateArray = DateAndTimeCalculations.fileNameToDate(dateCode);
                                        
                    // Trying to read the file
                    
                    BufferedReader reader = Files.newBufferedReader(fileAddress);
                    String data;
                    
                    // Looping through file while there is a next line in it
                    while((data = reader.readLine()) != null){
                        // First line filter: Checking if the line starts with { symbol
                        if (data.startsWith("{")){
                            Scanner lineScan = new Scanner(data);
                            
                            // Skipping data to get to the second filter
                            
                            
                            lineScan.useDelimiter(" ");
                            lineScan.next();
                            String systemTest = lineScan.next();
                            
                            
                            // WORKS regular
                            //String systemTest = lineScan.findInLine("[S][y][s][t][e][m]");
                            
                            // Second line filter: Checking if the next string starts with System
                            
                            // WORKS regular
                            //if (systemTest!=null){                          
                            
                            if (systemTest.startsWith("System")){                          
                                lineScan = new Scanner(data);
                                
                                // WORKS
                                //Scanner lineScan2 = new Scanner(data);
                                //String time2 = lineScan2.findInLine("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]");
                                
                                // Skipping { sign
                                lineScan.skip(DELIMITER7);                              
                                // Taking time from the log
                                lineScan.useDelimiter(DELIMITER8);
                                time = lineScan.next();
                                

                                
                                //System.out.println("Manual: "+time);
                                //System.out.println("Regular: "+time2);
                                
                                // Skipping unnecessary data
                                lineScan.useDelimiter(DELIMITER3);
                                lineScan.next();
                                lineScan.skip(DELIMITER3);
                                // Taking system name
                                systemName = miniPrograms.checkForApostrophe(lineScan.next());
                                
                                // Checking if the system is the same as the one scanned before
                                if (!(systemName.equals(systemNameCheck)) || i==0){
                                    // Skipping unnesessary data
                                    lineScan.useDelimiter(DELIMITER4);                                    
                                    lineScan.next();                                   
                                    lineScan.skip(DELIMITER4);
                                    // Taking 1st and 2nd coordinates and sending to
                                    // precision calculation
                                    lineScan.useDelimiter(DELIMITER5);                                  
                                    coordinateX = Calculations.precisionCalculation(lineScan.nextDouble());                                  
                                    coordinateY = Calculations.precisionCalculation(lineScan.nextDouble());                                  
                                    // Skipping , symbol
                                    lineScan.skip(DELIMITER5);                                  
                                    // Taking 3rd coordinate
                                    lineScan.useDelimiter(DELIMITER6);                                 
                                    coordinateZ = Calculations.precisionCalculation(lineScan.nextDouble());                                   
                                    
                                    if (xCheck!=null){
                                        distance = Calculations.calculatingStarDistance(coordinateX, coordinateY, coordinateZ, xCheck, yCheck, zCheck);
                                    }

                                    
                                    boolean dateChange = false;
                                    if (!firstTimeCheck){
                                        dateChange = DateAndTimeCalculations.checkDayChange(time, previousTime);
                                    }
                                    else{
                                        firstTimeCheck = false;
                                    }
                                    previousTime = time;

                                    if (dateChange && !nextFile){
                                        dateArray[2]++;
                                    }
                                    nextFile = false;
                                    // fusing year, month and day to date
                                    date = DateAndTimeCalculations.modifyWithZeroes(dateArray[0], dateArray[1], dateArray[2]);
 
                                    
                                    timeStamp = date+" "+time;

                                    systemNameCheck = systemName;
                                    
                                    xCheck = coordinateX;
                                    yCheck = coordinateY;
                                    zCheck = coordinateZ;
                                    

                                    if (i==0){
                                        i++;
                                    }

                                    SystemData newSystem = new SystemData(timeStamp,systemName,coordinateX.toString(),coordinateY.toString(),coordinateZ.toString(), distance);
                                    
                                    if(!(Data.traveledSystems.timeStampExists(newSystem.getTimeStamp()))){
                                        Data.traveledSystems.addSystem(newSystem);
                                    }
                                }
                            }
                        }
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(LogReader.class.getName()).log(Level.SEVERE, null, ex);
                    MainFrame.processInfo.setText("LogReader error: "+ex.getMessage());
                    break;
                }
                int allSystems = Data.traveledSystems.listLength();
                LogFile.writeToLog("Lenght: "+allSystems+"\n");
            }
            nextFile = true;
        }
    MainFrame.processInfo.setText("Reading Completed");
    }
}

