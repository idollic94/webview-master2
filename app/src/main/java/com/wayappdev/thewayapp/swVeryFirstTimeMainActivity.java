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


public class swVeryFirstTimeMainActivity extends Activity {
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


        String msStudent = preferences.getString("msStudent", "0");
        String msParent = preferences.getString("msParent", "0");
        String hsStudent = preferences.getString("hsStudent", "0");
        String hsParent = preferences.getString("hsParent", "0");
        String none = preferences.getString("none", "0");




            if (msStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsSW");


        if (msParent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsSW");

        if (hsStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsSW");

            if (hsParent.equals("0"))//after button click
            {
                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsSW");

                {
                    checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox1.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msStudentsSW");
                                checkbox1.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("msStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsSW");
                                checkbox1.setChecked(false);
                                prefsEditor.putString("msStudent", "0");
                                prefsEditor.commit();
                            }

                    };
                });
                {
                    checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox2.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msParentsSW");
                                checkbox2.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("msParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsSW");
                                checkbox2.setChecked(false);
                                prefsEditor.putString("msParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }

                {
                    checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox3.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsStudentsSW");
                                checkbox3.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("hsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsSW");
                                checkbox3.setChecked(false);
                                prefsEditor.putString("hsStudent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }


                {
                    checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox4.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsParentsSW");
                                checkbox4.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("hsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsSW");
                                checkbox4.setChecked(false);
                                prefsEditor.putString("hsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });

            }
        }}}}}}

    public void tonextnone(View view) {
        Intent intent = new Intent(swVeryFirstTimeMainActivity.this, FirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);



    }
    public void tonext(View view) {
        Intent intent = new Intent(swVeryFirstTimeMainActivity.this, imsw.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
    public void onBackPressed() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsSW");
        prefsEditor.putString("msStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsSW");
        prefsEditor.putString("msParent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsSW");
        prefsEditor.putString("hsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsSW");
        prefsEditor.putString("hsParent", "0");
        prefsEditor.commit();
        super.onBackPressed();

    }

}


