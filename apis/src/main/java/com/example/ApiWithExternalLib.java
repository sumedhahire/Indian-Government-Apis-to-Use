package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class ApiWithExternalLib {
    public static String fetching(String Url,String method) throws Exception{
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
            System.out.println(responseCode);
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


    public static void main( String[] args ) throws Exception{
        
        String url="https://api.data.gov.in/resource/6176ee09-3d56-4a3b-8115-21841576b2f6?api-key="+Resources.getApiKey()+"&format=json";

        System.out.println(Resources.getApiKey());

        System.out.println(fetching(url, "GET"));

        JSONObject jsonObject=new JSONObject(fetching("", "GET"));

       System.out.println(jsonObject.toString());
        
        
    }
}
