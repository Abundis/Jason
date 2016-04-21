package mx.edu.utng.json;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivityCuatro extends AppCompatActivity {
	List<Question> quesListCuatro;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion, text,time;
	RadioButton rda, rdb, rdc;
	Button butNext;
	BloqueQuizCuatro session;
	private final int TIEMPO_ESPERA = 60000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		time = (TextView) findViewById(R.id.time);
		esperar();
	}

	public void esperar() {
		new CountDownTimer(TIEMPO_ESPERA, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				time.setText("Tiempo: " + (millisUntilFinished / 1000));
			}

			@Override
			public void onFinish() {
				time.setText("");

				finish();
			}
		}.start();
		session= new BloqueQuizCuatro(getApplicationContext());
		if (session.checkQuiz())
			finish();
		DbHelper db=new DbHelper(this);
		quesListCuatro=db.getAllQuestionsC();
		currentQ=quesListCuatro.get(qid);
		txtQuestion=(TextView)findViewById(R.id.txv_pregunta);
		rda=(RadioButton)findViewById(R.id.rd_pregunta_1);
		rdb=(RadioButton)findViewById(R.id.rd_pregunta_2);
		rdc=(RadioButton)findViewById(R.id.rd_pregunta_3);
		butNext=(Button)findViewById(R.id.btn_sig);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {

				RadioGroup grp=(RadioGroup)findViewById(R.id.rdg_quiz);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				grp.clearCheck();
				Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
				if(currentQ.getANSWER().equals(answer.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
				if(qid<3){
					currentQ=quesListCuatro.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivityCuatro.this, ResultActivityCuatro.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		}

		);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
		return true;
	}
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
	}
}
