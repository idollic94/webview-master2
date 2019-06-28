package com.wayappdev.thewayapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.firebase.messaging.FirebaseMessaging;


public class westVeryFirstTimeMainActivity extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor prefsEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veryfirsttimemain);
        preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        prefsEditor = preferences.edit();
        final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        final CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        final CheckBox checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        final CheckBox checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        final Button button20 = (Button) findViewById(R.id.button20);
        final Button button21 = (Button) findViewById(R.id.button21);


        String msStudent = preferences.getString("westmsStudent", "0");
        String msParent = preferences.getString("westmsParent", "0");
        String hsStudent = preferences.getString("westhsStudent", "0");
        String hsParent = preferences.getString("westhsParent", "0");
        String none = preferences.getString("none", "0");




            if (msStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsWest");


        if (msParent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsWest");

        if (hsStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsWest");

            if (hsParent.equals("0"))//after button click
            {
                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsWest");

                {
                    checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox1.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msStudentsWest");
                                checkbox1.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("westmsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsWest");
                                checkbox1.setChecked(false);
                                prefsEditor.putString("westmsStudent", "0");
                                prefsEditor.commit();
                            }

                    };
                });
                {
                    checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox2.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msParentsWest");
                                checkbox2.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("westmsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsWest");
                                checkbox2.setChecked(false);
                                prefsEditor.putString("westmsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }

                {
                    checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox3.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsStudentsWest");
                                checkbox3.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("westhsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsWest");
                                checkbox3.setChecked(false);
                                prefsEditor.putString("westhsStudent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }


                {
                    checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox4.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsParentsWest");
                                checkbox4.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("westhsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsWest");
                                checkbox4.setChecked(false);
                                prefsEditor.putString("westhsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });

            }
        }}}}}}

    public void tonextnone(View view) {
        Intent intent = new Intent(westVeryFirstTimeMainActivity.this, FirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);



    }
    public void tonext(View view) {
        Intent intent = new Intent(westVeryFirstTimeMainActivity.this, imwest.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void onBackPressed() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsWest");
        prefsEditor.putString("westmsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsWest");
        prefsEditor.putString("westmsParent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsWest");
        prefsEditor.putString("westhsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsWest");
        prefsEditor.putString("westhsParent", "0");
        prefsEditor.commit();
        super.onBackPressed();

    }

}


