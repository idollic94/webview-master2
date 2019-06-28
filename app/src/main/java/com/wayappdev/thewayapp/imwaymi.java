package com.wayappdev.thewayapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class imwaymi extends Activity {

    SharedPreferences preferences;
    SharedPreferences.Editor prefsEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imsw);
        preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        prefsEditor = preferences.edit();
        prefsEditor.putString("firsttime", "5");
        prefsEditor.commit();
        final ImageButton questionmark = (ImageButton) findViewById(R.id.questionmark);
        final Button dismiss = (Button) findViewById(R.id.dismiss);
        final CardView helper = (CardView) findViewById(R.id.helper);

        questionmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton questionmark = (ImageButton) v;
                helper.setVisibility(View.VISIBLE);

            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button dismiss = (Button) v;
                helper.setVisibility(View.GONE);
            }
        });
    }

    public void swinsta (View view){

        Intent intent = new Intent(imwaymi.this, igwaymi.class);
        startActivity(intent);
    }
    public void swfb (View view){

        Intent intent = new Intent(imwaymi.this, fbwaymi.class);
        startActivity(intent);
    }
    public void swtwitter (View view){

        Intent intent = new Intent(imwaymi.this, twwaymi.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
