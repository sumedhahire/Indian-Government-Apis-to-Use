package com.example;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;



public class ApiWithoutExternalLib {
    
    public static void main(String[] args) throws Exception {
        URL url= new URL("https://api.data.gov.in/resource/6176ee09-3d56-4a3b-8115-21841576b2f6?api-key="+Resources.getApiKey()+"&format=json");
    
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        int responseCode=conn.getResponseCode();

        if(responseCode!=200){
            System.out.println(responseCode);
        }else{
            Scanner sc=new Scanner(url.openStream());

            String response="";

            while(sc.hasNextLine()){
                response+=sc.nextLine();
            }

            System.out.println(response);

            
        }

    
    
    }

}
