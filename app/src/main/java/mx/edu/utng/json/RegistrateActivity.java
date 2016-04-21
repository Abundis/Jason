package mx.edu.utng.json;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MSI on 01/03/2016.
 */
public class RegistrateActivity extends Activity {
    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_login);

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.btn_sign_in);
        btnSignUp=(Button)findViewById(R.id.btn_sign_up);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(intentSignUP);

            }
        });
    }
    // Methos to handleClick Event of Sign n Button
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(RegistrateActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the Refferences of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                  //  Intent i=new Intent(RegistrateActivity.this, EstrategiasActivity.class);
                  //  startActivity(i);
                    //Toast.makeText(RegistrateActivity.this, "Genial: Login realizado", Toast.LENGTH_LONG).show();
                    //dialog.dismiss();
                }
                else
                {
                    Toast.makeText(RegistrateActivity.this, "Usuario o contraseña no es correcto", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}
