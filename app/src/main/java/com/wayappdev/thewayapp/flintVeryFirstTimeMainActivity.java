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


public class flintVeryFirstTimeMainActivity extends Activity {
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


        String msStudent = preferences.getString("flintmsStudent", "0");
        String msParent = preferences.getString("flintmsParent", "0");
        String hsStudent = preferences.getString("flinthsStudent", "0");
        String hsParent = preferences.getString("flinthsParent", "0");
        String none = preferences.getString("none", "0");




            if (msStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsflint");


        if (msParent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsflint");

        if (hsStudent.equals("0"))//after button click
        {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsflint");

            if (hsParent.equals("0"))//after button click
            {
                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsflint");

                {
                    checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox1.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msStudentsflint");
                                checkbox1.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("flintmsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsflint");
                                checkbox1.setChecked(false);
                                prefsEditor.putString("flintmsStudent", "0");
                                prefsEditor.commit();
                            }

                    };
                });
                {
                    checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox2.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("msParentsflint");
                                checkbox2.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("flintmsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsflint");
                                checkbox2.setChecked(false);
                                prefsEditor.putString("flintmsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }

                {
                    checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox3.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsStudentsflint");
                                checkbox3.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("flinthsStudent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsflint");
                                checkbox3.setChecked(false);
                                prefsEditor.putString("flinthsStudent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });
                }


                {
                    checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (checkbox4.isChecked()) {
                                FirebaseMessaging.getInstance().subscribeToTopic("hsParentsflint");
                                checkbox4.setChecked(true);
                                button21.setVisibility(View.VISIBLE);
                                button20.setVisibility(View.GONE);
                                prefsEditor.putString("flinthsParent", "1");
                                prefsEditor.commit();
                            } else {
                                FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsflint");
                                checkbox4.setChecked(false);
                                prefsEditor.putString("flinthsParent", "0");
                                prefsEditor.commit();
                            }

                        }

                    });

            }
        }}}}}}

    public void tonextnone(View view) {
        Intent intent = new Intent(flintVeryFirstTimeMainActivity.this, FirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




    }
    public void tonext(View view) {
        Intent intent = new Intent(flintVeryFirstTimeMainActivity.this, imflint.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void onBackPressed() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msStudentsflint");
        prefsEditor.putString("flintmsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("msParentsflint");
        prefsEditor.putString("flintmsParent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsStudentsflint");
        prefsEditor.putString("flinthsStudent", "0");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("hsParentsflint");
        prefsEditor.putString("flinthsParent", "0");
        prefsEditor.commit();
        super.onBackPressed();

    }

}


