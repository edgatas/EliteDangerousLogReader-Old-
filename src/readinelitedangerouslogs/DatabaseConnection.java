package readinelitedangerouslogs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * @author edgar
 * version 0.0.1
 */
public class DatabaseConnection {

    public static void main(String[] args) {
        String fileName = "testDatabase";
        String url = "jdbc:sqlite:C:/edgatas/Database/"+fileName;
        createTable(url);
        
    }
    
    private static void createTable(String url){
       
        // SQL statement to create databse table with set parameters
        String SQL = "CREATE TABLE IF NOT EXISTS VISITED_SYSTEMS("
                + "system_name VARCHAR(30),\n"
                + "timestamp TIMESTAMP,\n"
                + "coordX DOUBLE NOT NULL,\n"
                + "coordY DOUBLE NOT NULL,\n"
                + "coordZ DOUBLE NOT NULL,\n"
                + "distance DOUBLE NOT NULL,\n"
                + "PRIMARY KEY(system_name,timestamp))";
        
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()){
            stmt.execute(SQL);
            System.out.println("Table was created or already existing");
        } 
        catch(SQLException e){
            System.out.println("Error in creating a table "+e);
        }
        
    }
}
