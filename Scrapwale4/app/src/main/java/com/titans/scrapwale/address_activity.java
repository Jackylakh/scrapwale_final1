package com.titans.scrapwale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import static com.titans.scrapwale.MainActivity.redirectActivity;

public class address_activity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_activity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Enter your Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void Successdone(View view){
        // Redirect activity to profile
        redirectActivity(this,Success_activity.class);
    }
}