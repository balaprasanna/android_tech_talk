package com.bala.weatherapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;



public class WeatherActivity extends AppCompatActivity {

    final static String APIKEY = "8a81d247d650cb16469c4ba3ceb7d265";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Receive Location Name in this page
        Bundle b = getIntent().getExtras();
        String location = b.getString("location");


        String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&APPID="+APIKEY;
        System.out.print(url);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String data = getDataFromUrl(url);
        String desc = "";

        try {
            JSONObject reader = new JSONObject(data);
            double _long =  reader.getJSONObject("coord").getDouble("lon");
            double _lat =  reader.getJSONObject("coord").getDouble("lon");

            JSONObject jsonObject = (JSONObject) reader.getJSONArray("weather").get(0);
            desc = jsonObject.getString("main");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        TextView tv = (TextView) findViewById(R.id.weather_info_tv);
        tv.setText("Weather info - "+ location +"\n"+ desc);

    }

    public String getDataFromUrl(String url_string){
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(url_string);
             HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
             InputStreamReader in = new InputStreamReader( urlconnection.getInputStream() );
             int read;
             char[] buff = new char[1024];
             while ((read = in.read(buff)) != -1) {
                 response.append(buff,0,read);
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(">>>>>>>>>>>>" +response.toString());
        return response.toString();
    }

}
