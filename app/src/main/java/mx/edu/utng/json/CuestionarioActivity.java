package mx.edu.utng.json;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Es la parte que se visualiza en el layout
 */

public class CuestionarioActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_activity);


        Button btnQuiz1=(Button)findViewById(R.id.btn_tema1);
        Button btnQuiz2=(Button)findViewById(R.id.btn_tema2);
        Button btnQuiz3=(Button)findViewById(R.id.btn_tema3);
        Button btnQuiz4=(Button)findViewById(R.id.btn_tema4);
        btnQuiz1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  Intent btnQuiz1=new Intent(CuestionarioActivity.this, QuizActivity.class);
                   startActivity(btnQuiz1);
               }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnQuiz2=new Intent(CuestionarioActivity.this, QuizActivityDos.class);
                startActivity(btnQuiz2);
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnQuiz3=new Intent(CuestionarioActivity.this, QuizActivityTres.class);
                startActivity(btnQuiz3);
            }
        });
        btnQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnQuiz4=new Intent(CuestionarioActivity.this, QuizActivityCuatro.class);
                startActivity(btnQuiz4);
            }
        });
    }

}
