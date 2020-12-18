package com.titans.scrapwale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {
private static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(LoginActivity.PREFS_NAME,0);
                boolean hasLoggedIn= sharedPreferences.getBoolean("hasLoggedIn",false);
                if (hasLoggedIn){
                    Intent intent = new Intent(splashscreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent= new Intent(splashscreen.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIME_OUT);

}
}