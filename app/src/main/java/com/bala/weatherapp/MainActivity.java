package com.bala.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.*;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayList<String> locations;
    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locations = new ArrayList<String>();
        locations.add("Singapore");
        locations.add("India");

        adapter = new ArrayAdapter<String>(this,R.layout.list_item,   locations);

        ListView listView = (ListView) findViewById(R.id.locations_listview);
        listView.setAdapter(adapter);

        // On click listener for Listview
        OnItemClickListener onItemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView )view;
                String location_name = tv.getText().toString();
                openWeatherPage( location_name );
            }
        };

        listView.setOnItemClickListener(onItemClickListener);

    }

    public void openWeatherPage(String location){
        Intent i = new Intent(this, WeatherActivity.class);
        i.putExtra("location",location);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Get the current selected Menu Id
        int id = item.getItemId();

        if (id == R.id.addlocation) {
            System.out.println("Clicked..");
            Intent i = new Intent(this, AddLocationActivity.class);
            startActivityForResult(i, 1);
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result_data = data.getStringExtra("location");
                locations.add(result_data);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
