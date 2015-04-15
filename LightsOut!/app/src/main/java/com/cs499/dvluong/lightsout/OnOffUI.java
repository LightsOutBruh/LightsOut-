package com.cs499.dvluong.lightsout;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class OnOffUI extends Activity {
    Button onButton;
    Button offButton;
    MediaPlayer onClick;
    MediaPlayer offClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_off_ui);

        // button sound
        onClick = MediaPlayer.create(this, R.raw.button_click);

        onButton = (Button) findViewById(R.id.onButton);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(OnOffUI.this, "Light's On!", Toast.LENGTH_SHORT).show();

                onClick.start();
                new AlertDialog.Builder(OnOffUI.this)
                        .setTitle("Lights On!")
                        .setMessage("You have turned the lights on!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // select ok exits dialog
                            }
                        }).show();
            }
        });

        // button sound
        offClick = MediaPlayer.create(this, R.raw.button_click);

        // button animation


        offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(OnOffUI.this, "Light's Off!", Toast.LENGTH_SHORT).show();

                offClick.start();

                new AlertDialog.Builder(OnOffUI.this)
                        .setTitle("Lights Off!")
                        .setMessage("You have turned the lights off!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // select ok exits dialog
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_on_off_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
