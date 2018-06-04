package readinelitedangerouslogs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author edgar
 * version 0.1.1
 */
public class DatabaseManipulation {
    //private static String host = "jdbc:sqlite:C:/edgatas/Database/testDatabase";
    private static String host = "jdbc:derby://localhost:1527/System DataBase;";
    private static String name = "serverName";
    private static String password = "serverPassword";
    
    
    public static Statement makeConnectionToDatabase() throws SQLException{
        //Connection con = DriverManager.getConnection(host,name,password);
        Connection con = DriverManager.getConnection(host, name, password);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return stmt;
    }
    
    
    public static void readRecords() throws SQLException{

        Connection con = DriverManager.getConnection(host, name, password);
        //Connection con = DriverManager.getConnection(host,name,password);
        Statement stmt = con.createStatement();
        
        String SQL = "SELECT * FROM visited_Systems";
        
        ResultSet rs = stmt.executeQuery(SQL);
        
        while(rs.next()){
            String timeStamp = rs.getString("timeStamp");
            String system_name = rs.getString("System_name");
            Double coordX = rs.getDouble("coord_x");
            Double coordY = rs.getDouble("coord_y");
            Double coordZ = rs.getDouble("coord_z");
            Double distance = rs.getDouble("distance");

           //System.out.println("Time: "+timeStamp" System name: "+system_name+" X:"+coordX+" Y:"
           //        +coordY+" Z:"+coordZ+" Distance: "+distance+"ly");
        }
       
    }
    public static void writeNewSystem(ArrayList systems)throws SQLException{

        String SQL = "SELECT * FROM VISITED_SYSTEMS";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);

//        while(rs.next()){
//            rs.next();
//        }
        rs.last();
        String checkname = "";
        String systemName;

        int arrayLenght = systems.size();
        for (int i = 0;i<arrayLenght;i++){
            String[] data = (String[]) systems.get(i);

            double X = Double.parseDouble(data[2]);
            double Y = Double.parseDouble(data[3]);
            double Z = Double.parseDouble(data[4]);
            String timeStamp = data[0];
            systemName = data[1];
            String distance = data[5];

            if (i > 0){
            checkname = rs.getString("system_name");
            }
            if (!checkname.equals(systemName)){

                rs.moveToInsertRow();
                rs.updateString("timestamp",timeStamp);
                rs.updateString("system_name",systemName);
                rs.updateDouble("coord_x", X);
                rs.updateDouble("coord_y", Y);
                rs.updateDouble("coord_z", Z);
                rs.updateDouble("distance", Double.parseDouble(distance));
                rs.insertRow();
            }
        }
        rs.close();
    }
    
    public static void deleteDataFromTable() throws SQLException{
        String SQL = "DELETE FROM VISITED_SYSTEMS";
        makeConnectionToDatabase().executeUpdate(SQL);
    }
    
    public static BigDecimal[] getCoordinatesOfSystem(String systemName) throws SQLException{
        systemName = miniPrograms.checkForApostrophe(systemName);
        String SQL = "SELECT * FROM VISITED_SYSTEMS WHERE system_Name = '"+systemName+"'";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);

        BigDecimal[] coordinates = new BigDecimal[3];
        if (!rs.isBeforeFirst() ) {    
            coordinates = null;
        } 
        else{
            rs.first();
            coordinates[0] = new BigDecimal(rs.getDouble("coord_x"));
            coordinates[1] = new BigDecimal(rs.getDouble("coord_y"));
            coordinates[2] = new BigDecimal(rs.getDouble("coord_z"));
        }
        rs.close();
        return coordinates;
    }
    
    public static double getMaxJumpWithinDate(String dateFrom,String dateTo) throws SQLException{
        String SQL = "SELECT MAX(DISTANCE) AS \"distance\" FROM VISITED_SYSTEMS WHERE date >= '"+dateFrom+"' AND date <='"+dateTo+"'";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);

        Double distance = null;
        if (!rs.isBeforeFirst() ) {    
            distance = null;
        } 
        else{
            rs.first();
            distance = rs.getDouble("distance");
        }
        return distance;
    }

    
    public static double getMinJumpWithinDate(String dateFrom,String dateTo) throws SQLException{
        Double distance = null;
        
        String SQL = "SELECT MIN(DISTANCE) AS \"distance\" FROM VISITED_SYSTEMS WHERE date >= '"+dateFrom+"' AND date <='"+dateTo+"'";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);

        if (!rs.isBeforeFirst() ) {    
            distance = null;
        } 
        else{
            rs.first();
            distance = rs.getDouble("distance");
        }
    return distance;
    }
    
    public static String[] getAllSystems() throws SQLException{
        String SQL = "SELECT COUNT(system_name) AS \"ammount\" FROM VISITED_SYSTEMS";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);
        int i = 0;
        if (!rs.isBeforeFirst() ) {    
            i = 0;
        } 
        else{
            rs.next();
            i = rs.getInt("ammount");
        }
        rs.close();
        SQL = "SELECT system_name AS \"systems\" FROM VISITED_SYSTEMS GROUP BY system_name ORDER BY system_name";
        rs = makeConnectionToDatabase().executeQuery(SQL);
        String[] allSystems = new String[i];
        int t = 0;
        while (rs.next()){
            allSystems[t] = rs.getString("systems");
            allSystems[t] = miniPrograms.returnToOriginalNameWithApostrophe(allSystems[t]);
            t++;
        }
    return allSystems;
    }
    
    public static String[] SearchSystems(String sysName) throws SQLException{
        String SQL = "SELECT COUNT(system_name) AS \"ammount\" FROM VISITED_SYSTEMS WHERE system_name LIKE '"+sysName+"%'";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);
        int i = 0;
        if (!rs.isBeforeFirst() ) {    
            i = 0;
            System.out.println("non");
        } 
        else{
            rs.next();
            i = rs.getInt("ammount");
            System.out.println("found "+ i);
        }
        rs.close();
        SQL = "SELECT system_name AS \"systems\" FROM VISITED_SYSTEMS WHERE system_name LIKE '"+sysName+"%' ORDER BY system_name";
        rs = makeConnectionToDatabase().executeQuery(SQL);
        String[] allSystems = new String[i];
        int t = 0;
        while (rs.next()){
            allSystems[t] = rs.getString("systems");
            t++;
        }
        return allSystems;
    }

    public static String[][] getDataToTable(String date) throws SQLException, ParseException{
        String SQL = "SELECT COUNT(system_name) AS \"ammount\" FROM VISITED_SYSTEMS";
        ResultSet rs = makeConnectionToDatabase().executeQuery(SQL);
        int i = 0;
        if (!rs.isBeforeFirst() ) {    
            i = 0;
        } 
        else{
            rs.next();
            i = rs.getInt("ammount");
        }
        rs.close();
        String setPeriod = Calculations.timeFrameToDateStamp(date);
        System.out.println(setPeriod);
        SQL = "SELECT system_name, timeStamp, distance FROM VISITED_SYSTEMS WHERE timeStamp>'"+setPeriod+"' ORDER BY timeStamp DESC";
        rs = makeConnectionToDatabase().executeQuery(SQL);
        int j = 0;
        String[][] dataForTable = new String[i][3];
        int t = 0;
        while (rs.next()){
            dataForTable[t][j] = rs.getString("system_name");
            dataForTable[t][j+1] = rs.getString("timeStamp").substring(0, 19);
            dataForTable[t][j+2] = rs.getString("distance");
            t++;
        }    
    return dataForTable;
    }
}