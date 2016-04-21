package mx.edu.utng.json;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by MSI on 15/02/2016.
 */
public class AudiosActivity extends ActionBarActivity {
    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button play = (Button) findViewById(R.id.btn_start);
        Button pause = (Button) findViewById(R.id.btn_pause);
        Button stop = (Button) findViewById(R.id.btn_stop);

        final MediaPlayer mp = MediaPlayer.create(AudiosActivity.this, R.raw.audio_json_introduccion);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    mp.start();
                    playing = true;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mp.pause();
                    playing = false;
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mp.stop();
                    playing = false;
                }
                AudiosActivity.this.finish();
            }
        });

    }

}
