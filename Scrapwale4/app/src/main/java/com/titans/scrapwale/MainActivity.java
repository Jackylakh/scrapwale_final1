package com.titans.scrapwale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;



public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
        SwitchCompat switchCompat;
    SharedPreferences sharedPreferences = null;

    public void clickedButton(View view){
        redirectActivity(this,address_activity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

}

    public void ClickMenu(View view){
       //Open Drawer
    openDrawer(drawerLayout);
}

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer layout
        closeDrawer(drawerLayout);
    }

    public void Darktheme(View view){
        // Redirect activity to profile
        redirectActivity(this,DarkTheme.class);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickAccount(View view){
        // Redirect activity to profile
        redirectActivity(this,EditProfile.class);
    }

    public void ClickMyRequest(View view){
        // Redirect activity to profile
        redirectActivity(this,MyRequest.class);
    }

    public void ClickMyOffers(View view){
        // Redirect activity to profile
        redirectActivity(this,MyOffers.class);
    }

    public void ClickShare(View view){
        // Redirect activity to profile
        //redirectActivity(this,Share.class);
        try {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Scrapwale");
            intent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
            startActivity(Intent.createChooser(intent, "Share With"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void ClickContactUs(View view){
        // Redirect activity to profile
        redirectActivity(this,ContactUs.class);
    }

    public void ClickAboutUs(View view){
        // Redirect activity to profile
        redirectActivity(this,AboutUs.class);
    }

    public  void ClickLogout(View view){
        //Close App
        logout(this);
    }



    public void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout ?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity

                activity.finishAffinity();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                sharedPreferences.edit().clear().commit();
                finish();
                //Exit app
                //System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Dismiss dialog
               dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //Initial intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity

        activity.startActivity(intent);
    }

    }