package mx.edu.utng.json;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
/**
 * La clase bloqueo tendrá la finalidad de no permitir que el usuario
 * ingrese a algún quiz si no cumple con la aprobación del anterior
 */

public class BloqueQuizTres {

    SharedPreferences pref;


    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE=0;

    private static final String PREFER_NAME="QuizTres";

    private static final String IS_USER_LOGIN="IsUserLogin";

    public static final String KEY_NAME=" name";

    public static final String KEY_PASSWORD="pass";

    public BloqueQuizTres(Context context){
        this._context=context;
        pref=context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor=pref.edit();

    }

    public void createUserQuiz(String name, String pass){
        editor.putBoolean(IS_USER_LOGIN, true);

        editor.putString(KEY_NAME, name);

        editor.putString(KEY_PASSWORD, pass);

        editor.commit();

    }


    public boolean checkQuiz(){
        if(!this.isUserLogged()){
            Intent i=new Intent(_context, QuizActivityDos.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);

            return true;
        }return false;
    }

    public boolean isUserLogged(){
        return pref.getBoolean(IS_USER_LOGIN, false);
    }

    public void logoutUser(){

        editor.clear();
        editor.commit();

    }


}