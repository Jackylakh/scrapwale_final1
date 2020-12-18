package com.titans.scrapwale;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutUs extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}

        //Assign variable



   /* public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickAccount(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickMyRequest(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickMyOffers(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickShare(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickContactUs(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }



    public void ClickAboutUs(View view){
        //Recreate activity
        recreate();
    }

    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }


    */