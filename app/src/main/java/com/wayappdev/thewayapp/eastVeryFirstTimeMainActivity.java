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


public class eastVeryFirstTimeMainActivity extends Activity {
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


        String msStudent = preferences.getString("eastmsStudent", "0");
        String msParent = preferences.getString("eastmsParent", "0");
        String hsStudent = preferences.getString("easthsStudent", "0");
        String hsParent = preferences.getString("easthsParent", "0");
        String none = preferences.getString("none", "0");




            if (msStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentseast");


        if (msParent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentseast");

        if (hsStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentseast");

            if (hsParent.equals("0"))//after button click
            {
                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentseast");

                {
                    checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox1.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msStudentseast");
                                checkbox1.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("eastmsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentseast");
                                checkbox1.setChecked(false);
                                prefsEditor.putString("eastmsStudent", "0");
                                prefsEditor.commit();
                            }

                    };
                });
                {
                    checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox2.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msParentseast");
                                checkbox2.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("eastmsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentseast");
                                checkbox2.setChecked(false);
                                prefsEditor.putString("eastmsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }

                {
                    checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox3.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsStudentseast");
                                checkbox3.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("easthsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentseast");
                                checkbox3.setChecked(false);
                                prefsEditor.putString("easthsStudent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }


                {
                    checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox4.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsParentseast");
                                checkbox4.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("easthsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentseast");
                                checkbox4.setChecked(false);
                                prefsEditor.putString("easthsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });

            }
        }}}}}}

    public void tonextnone(View view) {
        Intent intent = new Intent(eastVeryFirstTimeMainActivity.this, FirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




    }
    public void tonext(View view) {
        Intent intent = new Intent(eastVeryFirstTimeMainActivity.this, imeast .class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void onBackPressed() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentseast");
        prefsEditor.putString("eastmsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentseast");
        prefsEditor.putString("eastmsParent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentseast");
        prefsEditor.putString("easthsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentseast");
        prefsEditor.putString("easthsParent", "0");
        prefsEditor.commit();
        super.onBackPressed();

    }


}


