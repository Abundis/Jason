package mx.edu.utng.json;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivityTres extends Activity {

	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();

	BloqueQuizTres session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		session= new BloqueQuizTres(getApplicationContext());
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.rtB_resultado);
		bar.setNumStars(3);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.txv_result);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		bar.setRating(score);

		switch (score)
		{
		case 1: t.setText(R.string.puntuacion);

		case 2: t.setText(R.string.puntuacion);
				g.setNombre(getString(R.string.json));
				g.setSigla(getString((R.string.cu1)));
				g.setVotos(7);
				db.insertResult(g);
				session.createUserQuiz("pass", "pass");
				Intent o=new Intent(getApplicationContext(), GraficoActivityDos.class);
				o.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				o.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(o);
				finish();
		break;
			case 3:t.setText(R.string.excelente);
				g.setNombre(getString(R.string.codificar));
				g.setSigla(getString(R.string.cu3));
				g.setVotos(0);
				db.insertResult(g);
				session.createUserQuiz("pass", "pass");
				Intent i=new Intent(getApplicationContext(), GraficoActivityDos.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();

		break;

		default: t.setText(R.string.again);
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
		return true;
	}
}
