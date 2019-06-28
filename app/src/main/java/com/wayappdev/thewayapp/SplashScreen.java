package com.wayappdev.thewayapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.google.firebase.messaging.FirebaseMessaging;



public class SplashScreen extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor prefsEditor ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        FirebaseMessaging.getInstance().subscribeToTopic("news");
        setContentView(R.layout.layout);
        preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        prefsEditor = preferences.edit();
        String FirstTimeUser = preferences.getString("firsttime", "0");
        if (FirstTimeUser.equals("0")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, WhatSchool.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
        if (FirstTimeUser.equals("1")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imsw.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
        if (FirstTimeUser.equals("2")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imwest.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
        if (FirstTimeUser.equals("3")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imeast.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
        if (FirstTimeUser.equals("4")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imflint.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }

        if (FirstTimeUser.equals("5")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imwaymi.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
        if (FirstTimeUser.equals("6")) {

            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(SplashScreen.this, imwayprog.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
            };
            timerThread.start();
        }
    }
    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }

}