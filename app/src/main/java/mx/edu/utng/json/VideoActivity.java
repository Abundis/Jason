package mx.edu.utng.json;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by MSI on 02/03/2016.
 */
public class VideoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        VideoView videoView = (VideoView) findViewById(R.id.vdo_json);
        Uri path = Uri.parse("android.resource://mx.edu.utng.json/" + R.raw.json_introduccion);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        videoView.setVideoURI(path);
        videoView.start();
    }

}
