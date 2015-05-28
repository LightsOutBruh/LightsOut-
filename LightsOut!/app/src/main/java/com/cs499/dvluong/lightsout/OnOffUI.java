package com.cs499.dvluong.lightsout;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;



public class OnOffUI extends Activity {
    Button toggleButton;
    MediaPlayer clickSound;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_off_ui);
        // button sound
        clickSound = MediaPlayer.create(this, R.raw.button_click);
        image = (ImageView)findViewById(R.id.onView);
        toggleButton = (Button) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if (image.getVisibility() == View.INVISIBLE) {
                    new ConnectionOn().execute();
                    image.setVisibility(View.VISIBLE);
                } else {
                    new ConnectionOff().execute();
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private class ConnectionOn extends AsyncTask {
        @Override
        protected Object doInBackground(Object... arg0) {
            connectOn();
            return null;
        }
    }

    private class ConnectionOff extends AsyncTask {
        @Override
        protected Object doInBackground(Object... arg0) {
            connectOff();
            return null;
        }
    }
    private void connectOff() {
        try {
            DefaultHttpClient client = new DefaultHttpClient();

            // This should be http://c14071c2.ngrok.io/off, but they are reversed
            HttpGet request = new HttpGet("http://c14071c2.ngrok.io/on");

            HttpResponse response = client.execute(request);
        } catch (ClientProtocolException e) {
            Log.d("HTTPCLIENT", e.getLocalizedMessage());
        } catch (IOException e) {
            Log.d("HTTPCLIENT", e.getLocalizedMessage());
        }
    }

    private void connectOn() {
        try {
            DefaultHttpClient client = new DefaultHttpClient();

            // This should be http://c14071c2.ngrok.io/on, but they are reversed
            HttpGet request = new HttpGet("http://c14071c2.ngrok.io/off");

            HttpResponse response = client.execute(request);
        } catch (ClientProtocolException e) {
            Log.d("HTTPCLIENT", e.getLocalizedMessage());
        } catch (IOException e) {
            Log.d("HTTPCLIENT", e.getLocalizedMessage());
        }
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
