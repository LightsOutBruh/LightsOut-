package com.cs499.dvluong.lightsout;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.transition.Transition;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.Toast;


public class OnOffUI extends Activity {
    Button toggleButton;
    Button onButton;
    Button offButton;
    MediaPlayer clickSound;
    ViewGroup rootContainer;
    Scene sceneOff;
    Scene sceneOn;
    Transition transitionManager;
    RelativeLayout layout;
    ImageView image;
    boolean on = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_off_ui);

        // button sound
        clickSound = MediaPlayer.create(this, R.raw.button_click);
        rootContainer = (ViewGroup) findViewById(R.id.rootContainer);
        transitionManager = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        sceneOff = Scene.getSceneForLayout(rootContainer, R.layout.activity_on_off_ui, this);
        sceneOn = Scene.getSceneForLayout(rootContainer, R.layout.transition_file, this);
        toggleButton = (Button) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                sceneOn.enter();

            }
        });


    }

    public void goToOnScene(View view){
        clickSound = MediaPlayer.create(this, R.raw.button_click);
        TransitionManager.go(sceneOn);
        clickSound.start();
    }

    public void goToOffScene(View view){
        clickSound = MediaPlayer.create(this, R.raw.button_click);
        TransitionManager.go(sceneOff);
        clickSound.start();
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
