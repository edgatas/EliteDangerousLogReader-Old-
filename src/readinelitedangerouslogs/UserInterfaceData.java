
package readinelitedangerouslogs;

public class UserInterfaceData {
    
    /**
     * Method will return Travel Log header row names.
     * @return String[]
     */
    public static String[] getTravelLogHeaderNames(){
        String [] columnNames = new String[]{"System Name","Time","Distance"};
        return columnNames;
    }
    
    public static String[] emptyStringArray(){
        String [] columnNames = null;
        return columnNames;
    }
    
}
