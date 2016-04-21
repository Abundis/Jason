package mx.edu.utng.json;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Base de datos del cuestionario
 */

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "quiz_jason";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		String sqld = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTD + " ( "
				+ KEY_IDD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESD
				+ " TEXT, " + KEY_ANSWERD+ " TEXT, "+KEY_OPTAD +" TEXT, "
				+KEY_OPTBD +" TEXT, "+KEY_OPTCD+" TEXT)";
		String sqlt = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTT + " ( "
				+ KEY_IDT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUEST
				+ " TEXT, " + KEY_ANSWERT+ " TEXT, "+KEY_OPTAT +" TEXT, "
				+KEY_OPTBT +" TEXT, "+KEY_OPTCT+" TEXT)";
		String sqlc = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTC + " ( "
				+ KEY_IDC+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESC
				+ " TEXT, " + KEY_ANSWERC+ " TEXT, "+KEY_OPTAC +" TEXT, "
				+KEY_OPTBC +" TEXT, "+KEY_OPTCC+" TEXT)";

		db.execSQL(sql);
		db.execSQL(sqld);
		db.execSQL(sqlt);
		db.execSQL(sqlc);
		//Rellenar Base de datos
		addQuestions();
		addQuestionsDos();
		addQuestionsTres();
		addQuestionsCuatro();
		//db.close();
	}

	/**
	 * Método que agrega preguntas al layout y dónde se verifica con la correcta que es la última
	 */
	private void addQuestions()
	{
		Question q1=new Question("¿Qué es JSON?","Es un formato ligero de intercambio de datos",
				"Base de Datos", "Lenguaje de base de datos", "Es un formato ligero de intercambio de datos");
		this.addQuestion(q1);
		Question q2=new Question("Significado de JSON", "JavaSecurity Object None", "JavaScript Object Notation",
				"JavaSuccesful Object Number", "JavaScript Object Notation");
		this.addQuestion(q2);
		Question q3=new Question("¿En que se basa JSON?","Archivos de BD", "Datos almacenados",
				"Literales de matrices y objetos","Literales de matrices y objetos");
		this.addQuestion(q3);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}

	//Tabla dos
	private static final String TABLE_QUESTD = "questdos";
	// tasks Table Columns names
	private static final String KEY_IDD = "id";
	private static final String KEY_QUESD = "question";
	private static final String KEY_ANSWERD = "answer"; //correct option
	private static final String KEY_OPTAD= "opta"; //option a
	private static final String KEY_OPTBD= "optb"; //option b
	private static final String KEY_OPTCD= "optc"; //option c
	/**
	 * Método que agrega preguntas al layout y dónde se verifica con la correcta que es la última
	 */
	private void addQuestionsDos()
	{
		Question q1=new Question("¿Cual es la sintaxis?","La mezcla de literales de objeto y matrices",
				"Objetos y Tags", "Clases y Objetos", "La mezcla de literales de objeto y matrices");
		this.addQuestiondos(q1);
		Question q2=new Question("Rellena lo que se pide \n" +
				"    {\"employees\":[\n" +
				"    {\"________\":\"Juan\", \"lastName\":\"Ramirez\"},\n" +
				"    {\"firstName\":\"Ana\", \"lastName\":\"Perez\"},\n" +
				"    {\"firstName\":\"Pedro\", \"_____\":\"Lopez\"}\n" +
				"]}", "firstName, lastName",
				"Nombre, Apellido",
				"Ninguna de las dos", "firstName, lastName");
		this.addQuestiondos(q2);
		Question q3=new Question("¿Que funcion transforma en objeto la cadena de información?","eval();",
				"toObject();","ParseObject();","eval();");
		this.addQuestiondos(q3);
	}

	// Adding new question
	public void addQuestiondos(Question questtio) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESD, questtio.getQUESTION());
		values.put(KEY_ANSWERD, questtio.getANSWER());
		values.put(KEY_OPTAD, questtio.getOPTA());
		values.put(KEY_OPTBD, questtio.getOPTB());
		values.put(KEY_OPTCD, questtio.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUESTD, null, values);
	}
	public List<Question> getAllQuestionsdos() {
		List<Question> quesListDos = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTD;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesListDos.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesListDos;
	}

//Tabla tres
private static final String TABLE_QUESTT = "questt";
	// tasks Table Columns names
	private static final String KEY_IDT = "id";
	private static final String KEY_QUEST = "question";
	private static final String KEY_ANSWERT = "answer"; //correct option
	private static final String KEY_OPTAT= "opta"; //option a
	private static final String KEY_OPTBT= "optb"; //option b
	private static final String KEY_OPTCT= "optc"; //option c

	/**
	 * Método que agrega preguntas al layout y dónde se verifica con la correcta que es la última
	 */
	private void addQuestionsTres()
	{
		Question q1=new Question("¿Cual es el problema de eval();?","Evalúa cualquier código JavaScript",
				"No codifica todo el codigo","Solo funciona con ciertos datos", "Evalúa cualquier código JavaScript");
		this.addQuestionT(q1);
		Question q2=new Question("Rellena lo que se pide\n " +
				"var str = JSON._____(objeto);", "decode", "encode",
				"toString", "encode");
		this.addQuestionT(q2);
		Question q3=new Question("¿Para que sirve JSON.encode(objeto)?","Para codificar codigo",
				"Para hacer figuras","Para pasar un Objeto Javascript a un simple String","Para pasar" +
				" un Objeto Javascript a un simple String");
		this.addQuestionT(q3);
	}

	// Adding new question
	public void addQuestionT(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUEST, quest.getQUESTION());
		values.put(KEY_ANSWERT, quest.getANSWER());
		values.put(KEY_OPTAT, quest.getOPTA());
		values.put(KEY_OPTBT, quest.getOPTB());
		values.put(KEY_OPTCT, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUESTT, null, values);
	}
	public List<Question> getAllQuestionsTres() {
		List<Question> quesListTres = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTT;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesListTres.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesListTres;
	}

//Creacion de tabla 4
	private static final String TABLE_QUESTC = "questc";
	// tasks Table Columns names
	private static final String KEY_IDC = "id";
	private static final String KEY_QUESC = "question";
	private static final String KEY_ANSWERC = "answer"; //correct option
	private static final String KEY_OPTAC= "opta"; //option a
	private static final String KEY_OPTBC= "optb"; //option b
	private static final String KEY_OPTCC= "optc"; //option c
	/**
	 * Método que agrega preguntas al layout y dónde se verifica con la correcta que es la última
	 */

	private void addQuestionsCuatro() {
		Question q1=new Question("¿Para qué sirve Request.JSON?","Para enviar y recibir objetos JSON mediante AJAX",
				"Para hacer una peticion", "Para mandar una respuesta", "Para enviar y recibir objetos JSON mediante AJAX");
		this.addQuestionC(q1);
		Question q2=new Question("¿De dónde se heredan los metodos y propiedades para trabajar con AJAX?",
				"De la clase Request", "Del package AJAX", "De un Jar para java", "De la clase Request");
		this.addQuestionC(q2);
		Question q3=new Question("Una vez que tenemos los datos en formato JSON, ¿Qué sigue?","Llenar la Base de Datos",
				"Mandarlo mediante AJAX","Mostrarlo con JavaScript","Mostrarlo con JavaScript");
		this.addQuestionC(q3);
	}
	// Adding new question
	public void addQuestionC(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESC, quest.getQUESTION());
		values.put(KEY_ANSWERC, quest.getANSWER());
		values.put(KEY_OPTAC, quest.getOPTA());
		values.put(KEY_OPTBC, quest.getOPTB());
		values.put(KEY_OPTCC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUESTC, null, values);
	}
	public List<Question> getAllQuestionsC() {
		List<Question> quesListCuatro = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTC;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesListCuatro.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesListCuatro;
	}
}
