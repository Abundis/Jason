package mx.edu.utng.json;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by MSI on 02/03/2016.
 */
public class CorreoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correo_layout);

        Button btnSend = (Button) findViewById(R.id.btn_Send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = (EditText)findViewById(R.id.edt_Email);
                //EditText etSubject = (EditText) findViewById(R.id.edt_Subject);
                //EditText etBody = (EditText) findViewById(R.id.edt_Body);

                Intent itSend = new Intent(android.content.Intent.ACTION_SEND);

                itSend.setType("plain/text");

                itSend.putExtra(android.content.Intent.EXTRA_EMAIL, etEmail.getText());
                itSend.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.learn));
                itSend.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.body));
                startActivity(itSend);

            }
        });
    }
}
