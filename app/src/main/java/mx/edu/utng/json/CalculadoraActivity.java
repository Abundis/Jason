package mx.edu.utng.json;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * Se usa como una calculadora normal y está configurada con botones
 */

public class CalculadoraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    Double numero1,numero2,resultado;
    String operador;

    /**
     * Botón que nos dara el resultado de la operación
     * @param miView
     */
    public void onClickIgual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        numero2 = Double.parseDouble(tv.getText().toString());

        if(operador.equals("+"))
        {
            resultado= numero1+numero2;
        }
        else if(operador.equals("-"))
        {
            resultado= numero1-numero2;
        }
        else if(operador.equals("*"))
        {
            resultado= numero1*numero2;
        }
        else if(operador.equals("/"))
        {
            resultado= numero1/numero2;
        }
        tv.setText(resultado.toString());
    }

    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtnPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + ".");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText("");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "1");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn2(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "2");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn3(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "3");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn4(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "4");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn5(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "5");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn6(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "6");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn7(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "7");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn8(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "8");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn9(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "9");
    }
    /**
     * Boton que tomando el parametro de la vista hace la operación
     * @param miView
     */
    public void onClickBtn0(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txv_numero) ;
        tv.setText(tv.getText() + "0");
    }

}
