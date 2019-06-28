package com.wayappdev.thewayapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.messaging.FirebaseMessaging;

public class WhatSchool extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor prefsEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatschool);
        preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        prefsEditor = preferences.edit();
        ImageView swlogo = (ImageView) findViewById(R.id.swlogo);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.way_southwest)
                .into(swlogo);
        ImageView swbuilding = (ImageView) findViewById(R.id.swbuilding);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.swbuilding)
                .into(swbuilding);
        ImageView westlogo = (ImageView) findViewById(R.id.westlogo);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.way_west)
                .into(westlogo);
        ImageView westbuilding = (ImageView) findViewById(R.id.westbuilding);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.westbuilding)
                .into(westbuilding);
        ImageView eastlogo = (ImageView) findViewById(R.id.eastlogo);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.way_east)
                .into(eastlogo);
        ImageView eastbuilding = (ImageView) findViewById(R.id.eastbuilding);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.eastbuilding)
                .into(eastbuilding);
        ImageView flintlogo = (ImageView) findViewById(R.id.flintlogo);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.way_flint)
                .into(flintlogo);
        ImageView flintbuilding = (ImageView) findViewById(R.id.flintbuilding);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.flintbuilding)
                .into(flintbuilding);
        ImageView waymilogo = (ImageView) findViewById(R.id.waymilogo);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.way_michigan)
                .into(waymilogo);
        ImageView waymibuilding = (ImageView) findViewById(R.id.waymibuilding);
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.waymichiganbuilding)
                .into(waymibuilding);

        final CheckBox buildingbox1 = (CheckBox) findViewById(R.id.buildingbox1);
        final CheckBox buildingbox2 = (CheckBox) findViewById(R.id.buildingbox2);
        final CheckBox buildingbox3 = (CheckBox) findViewById(R.id.buildingbox3);
        final CheckBox buildingbox4 = (CheckBox) findViewById(R.id.buildingbox4);
        final CheckBox buildingbox5 = (CheckBox) findViewById(R.id.buildingbox5);
        final Button button30 = (Button) findViewById(R.id.button30);
        final Button button31 = (Button) findViewById(R.id.button31);
        final Button button32 = (Button) findViewById(R.id.button32);
        final Button button33 = (Button) findViewById(R.id.button33);
        final Button button34 = (Button) findViewById(R.id.button34);
        final Button button35 = (Button) findViewById(R.id.button35);

        String sendtosw = preferences.getString("sendtosw", "0");
        String sendtowest = preferences.getString("sendtowest", "0");
        String sendtoflint = preferences.getString("sendtoflint", "0");
        String sendtoeast = preferences.getString("sendtoeast", "0");
        String sendtowaymi = preferences.getString("sendtowaymi", "0");
        String none = ("0");
        if (sendtosw.equals("1"))//after button click
        {
            buildingbox1.setChecked(true);
        } else buildingbox1.setChecked(false);
        if (sendtowest.equals("1"))//after button click
        {
            buildingbox2.setChecked(true);
        } else buildingbox2.setChecked(false);
        if (sendtoflint.equals("1"))//after button click
        {
            buildingbox3.setChecked(true);
        } else buildingbox3.setChecked(false);
        if (sendtoeast.equals("1"))//after button click
        {
            buildingbox4.setChecked(true);
        } else buildingbox4.setChecked(false);
        if (sendtowaymi.equals("1"))//after button click
        {
            buildingbox5.setChecked(true);
        } else buildingbox5.setChecked(false);
        {
            buildingbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buildingbox1.isChecked()) {
                        buildingbox1.setChecked(true);
                        buildingbox2.setChecked(false);
                        buildingbox3.setChecked(false);
                        buildingbox4.setChecked(false);
                        buildingbox5.setChecked(false);
                        button31.setVisibility(View.VISIBLE);
                        button30.setVisibility(View.GONE);
                        button32.setVisibility(View.GONE);
                        button33.setVisibility(View.GONE);
                        button34.setVisibility(View.GONE);
                        button35.setVisibility(View.GONE);
                        prefsEditor.putString("sendtosw", "1");
                        prefsEditor.commit();
                    } else {
                        buildingbox1.setChecked(false);
                        prefsEditor.putString("sendtosw", "0");
                        prefsEditor.commit();
                    }

                }


            });
        }

        {
            buildingbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buildingbox2.isChecked()) {
                        buildingbox2.setChecked(true);
                        buildingbox1.setChecked(false);
                        buildingbox3.setChecked(false);
                        buildingbox4.setChecked(false);
                        buildingbox5.setChecked(false);
                        button32.setVisibility(View.VISIBLE);
                        button30.setVisibility(View.GONE);
                        button31.setVisibility(View.GONE);
                        button33.setVisibility(View.GONE);
                        button34.setVisibility(View.GONE);
                        button35.setVisibility(View.GONE);
                        prefsEditor.putString("sendtowest", "1");
                        prefsEditor.commit();
                    } else {
                        buildingbox2.setChecked(false);
                        prefsEditor.putString("sendtowest", "0");
                        prefsEditor.commit();
                    }

                }


            });
        }
        {
            buildingbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buildingbox3.isChecked()) {
                        buildingbox3.setChecked(true);
                        buildingbox2.setChecked(false);
                        buildingbox1.setChecked(false);
                        buildingbox4.setChecked(false);
                        buildingbox5.setChecked(false);
                        button33.setVisibility(View.VISIBLE);
                        button30.setVisibility(View.GONE);
                        button32.setVisibility(View.GONE);
                        button31.setVisibility(View.GONE);
                        button34.setVisibility(View.GONE);
                        button35.setVisibility(View.GONE);
                        prefsEditor.putString("sendtoeast", "1");
                        prefsEditor.commit();
                    } else {
                        buildingbox3.setChecked(false);
                        prefsEditor.putString("sendtoeast", "0");
                        prefsEditor.commit();
                    }

                }


            });
        }
        {
            buildingbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buildingbox4.isChecked()) {
                        buildingbox4.setChecked(true);
                        buildingbox2.setChecked(false);
                        buildingbox3.setChecked(false);
                        buildingbox1.setChecked(false);
                        buildingbox5.setChecked(false);
                        button34.setVisibility(View.VISIBLE);
                        button30.setVisibility(View.GONE);
                        button32.setVisibility(View.GONE);
                        button33.setVisibility(View.GONE);
                        button31.setVisibility(View.GONE);
                        button35.setVisibility(View.GONE);

                        prefsEditor.putString("sendtoflint", "1");
                        prefsEditor.commit();
                    } else {
                        buildingbox4.setChecked(false);
                        prefsEditor.putString("sendtoflint", "0");
                        prefsEditor.commit();
                    }

                }


            });
        }
        {
            buildingbox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buildingbox5.isChecked()) {
                        buildingbox5.setChecked(true);
                        buildingbox2.setChecked(false);
                        buildingbox3.setChecked(false);
                        buildingbox4.setChecked(false);
                        buildingbox1.setChecked(false);
                        button35.setVisibility(View.VISIBLE);
                        button30.setVisibility(View.GONE);
                        button32.setVisibility(View.GONE);
                        button33.setVisibility(View.GONE);
                        button31.setVisibility(View.GONE);
                        button34.setVisibility(View.GONE);
                        prefsEditor.putString("sendtowaymi", "1");
                        prefsEditor.commit();
                    } else {
                        buildingbox5.setChecked(false);
                        prefsEditor.putString("sendtowaymi", "0");
                        prefsEditor.commit();
                    }

                }


            });
        }




    }

    public void tonextprogram (View view){
        Intent intent = new Intent(WhatSchool.this, wayprogVeryFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void tonextsw (View view){
        Intent intent = new Intent(WhatSchool.this, swVeryFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public void tonextwest (View view){
        Intent intent = new Intent(WhatSchool.this, westVeryFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public void tonexteast (View view){
        Intent intent = new Intent(WhatSchool.this, eastVeryFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public void tonextflint (View view){
        Intent intent = new Intent(WhatSchool.this, flintVeryFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public void tonextwaymi (View view){
        Intent intent = new Intent(WhatSchool.this, waymiFirstTimeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    }

