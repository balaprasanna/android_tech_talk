package com.bala.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        final EditText location_edittext = (EditText) findViewById(R.id.locaton_edittext);
        Button addLocationButton = (Button) findViewById(R.id.add_location_button);
        Button cancelLocationButton = (Button) findViewById(R.id.cancel_location_button);

        addLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = location_edittext.getText().toString();
                Intent returnIntent = new Intent();
                if (!location.isEmpty()) {

                    returnIntent.putExtra("location",location);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                } else {
                    Toast.makeText(v.getContext(),"Please enter a valid location name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();
            }
        });

    }

}
