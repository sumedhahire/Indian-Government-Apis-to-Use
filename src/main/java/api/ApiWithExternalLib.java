package api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
/**
 * 
 */

 
public class ApiWithExternalLib
{

    public static String fetching(String Url,String method){
        
        /*
         * URL object and type cast it into an HttpURLConnection
         *  object so that we can set request types and get response codes back
         */
        URL url =new URL(Url);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();

        //set request type
        conn.setRequestMethod(method);
        conn.connect();

        int responseCode=conn.getResponseCode();

        //if error then null
        if(responseCode!=200){
            return null;
        }else{
            //
            Scanner sc=new Scanner(url.openStream());
            String response="";

            while(sc.hasNext()){
                response += sc.nextLine();
            }

            sc.close();

            return response;

        }

    }


    public static void main( String[] args ){
        



    }
}
