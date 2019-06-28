package com.wayappdev.thewayapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.wayappdev.thewayapp.VeryFirstTimeMainActivity;


import com.google.firebase.messaging.FirebaseMessaging;



public class FirstTimeMainActivity extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor prefsEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttimemain);
        preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        prefsEditor = preferences.edit();
        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        final Switch switch2 = (Switch) findViewById(R.id.switch2);
        final Switch switch3 = (Switch) findViewById(R.id.switch3);
        final Switch switch4 = (Switch) findViewById(R.id.switch4);
        final Switch switch5 = (Switch) findViewById(R.id.switch5);


        String SWSwitch = preferences.getString("SWSwitch", "0");
        String WestSwitch = preferences.getString("WestSwitch", "0");
        String EastSwitch = preferences.getString("EastSwitch", "0");
        String FlintSwitch = preferences.getString("FlintSwitch", "0");
        String WAYMISwitch = preferences.getString("WAYMISwitch", "0");
        if (SWSwitch.equals("1"))//after button click
        {
            switch1.setChecked(true);
        }
else switch1.setChecked(false);
        if (WestSwitch.equals("1"))//after button click
        {
            switch2.setChecked(true);
        }
        else switch2.setChecked(false);
        if (EastSwitch.equals("1"))//after button click
        {
            switch3.setChecked(true);
        }
        else switch3.setChecked(false);
        if (FlintSwitch.equals("1"))//after button click
        {
            switch4.setChecked(true);
        }
        else switch4.setChecked(false);
        if (WAYMISwitch.equals("1"))//after button click
        {
            switch5.setChecked(true);
        }
        else switch5.setChecked(false);
       {
           switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (switch1.isChecked()) {
                       FirebaseMessaging.getInstance().subscribeToTopic("SW");
                       switch1.setChecked(true);
                       prefsEditor.putString("SWSwitch", "1");
                       prefsEditor.commit();
                   } else {
                       FirebaseMessaging.getInstance().unsubscribeFromTopic("SW");
                       switch1.setChecked(false);
                       prefsEditor.putString("SWSwitch", "0");
                       prefsEditor.commit();
                   }

               }



        });}
        {
            switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (switch2.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("West");
                        switch2.setChecked(true);
                        prefsEditor.putString("WestSwitch", "1");
                        prefsEditor.commit();
                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("West");
                        switch2.setChecked(false);
                        prefsEditor.putString("WestSwitch", "0");
                        prefsEditor.commit();
                    }

                }

    });}

        {
            switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (switch3.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("East");
                        switch3.setChecked(true);
                        prefsEditor.putString("EastSwitch", "1");
                        prefsEditor.commit();
                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("East");
                        switch3.setChecked(false);
                        prefsEditor.putString("EastSwitch", "0");
                        prefsEditor.commit();
                    }

                }

            });}


        {
            switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (switch4.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("Flint");
                        switch4.setChecked(true);
                        prefsEditor.putString("FlintSwitch", "1");
                        prefsEditor.commit();
                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Flint");
                        switch4.setChecked(false);
                        prefsEditor.putString("FlintSwitch", "0");
                        prefsEditor.commit();
                    }

                }

            });}

        {
            switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (switch5.isChecked()) {
                        FirebaseMessaging.getInstance().subscribeToTopic("WAYMI");
                        switch5.setChecked(true);
                        prefsEditor.putString("WAYMISwitch", "1");
                        prefsEditor.commit();
                    } else {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("WAYMI");
                        switch5.setChecked(false);
                        prefsEditor.putString("WAYMISwitch", "0");
                        prefsEditor.commit();
                    }

                }

            });}

    }


    public void tomain(View view) {
        Intent intent = new Intent(FirstTimeMainActivity.this, imwayprog.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


    }
}




