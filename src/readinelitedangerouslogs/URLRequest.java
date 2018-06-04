
package readinelitedangerouslogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRequest {
    
    static String edsm_server_address = "http://beta.edsm.net:8080/";
    
    public static void requestAllSystems() throws MalformedURLException, IOException{
        
        String startDate = "2016-11-20 06:00:00";
        String endDate = "2016-11-29 12:00:00";
        String url0 = "api-v1/systems";
        String url1 = "&startdatetime=";
        String url2 = "&enddatetime=";
        String url3 = "&coords=1";
        String url14 = "?sysname=";
        String url10 = URLEncoder.encode(startDate, "UTF-8");
        String url11 = URLEncoder.encode(endDate, "UTF-8");
        
        String url19 = "api-v1/cube-systems";
        String url20 = "?x=50.0&y=50.0&z=50.0&n=10";
        
//        System.out.println(edsm_server_address+url0+url1+url10+url2+url11+url3);
//        URL api = new URL(edsm_server_address+url0+url1+url10+url2+url11+url3);

        System.out.println(edsm_server_address+url0+url14+url1+url10+url2+url11+url3);
        URL api = new URL(edsm_server_address+url0+url14+url1+url10+url2+url11+url3);
        
        BufferedReader incoming = new BufferedReader(new InputStreamReader(api.openStream()));
        

        
        String inputLine = incoming.readLine();
        
        
        
        Scanner scan = new Scanner(inputLine);
        
        String DELIMITER1 = "\"";
        System.out.println(inputLine);
        
        Pattern patternForSystemName = Pattern.compile("\":\"(.*?)\",\"");
        Pattern patternForX = Pattern.compile("x\":(.*?),\"");
        Pattern patternForY = Pattern.compile("y\":(.*?),\"");
        Pattern patternForZ = Pattern.compile("z\":(.*?)\\}");
        
        
        Matcher matcherForSystemName = patternForSystemName.matcher(inputLine);
        Matcher matcherForX = patternForX.matcher(inputLine);
        Matcher matcherForY = patternForY.matcher(inputLine);
        Matcher matcherForZ = patternForZ.matcher(inputLine);
        
        int i = 0;
        while (matcherForSystemName.find()){
            System.out.println("");
            System.out.print(matcherForSystemName.group(1));
            if(matcherForX.find()){
                System.out.print(" X: "+matcherForX.group(1));
                matcherForY.find();
                System.out.print(" Y: "+matcherForY.group(1));
                matcherForZ.find();
                System.out.print(" Z: "+matcherForZ.group(1));
                i++;
            }
        }
        System.out.println("");
        System.out.println("Systems: "+i);
            
    }
        //System.out.println(inputLine);
        //String systemName = scan.next()

    
    
}
