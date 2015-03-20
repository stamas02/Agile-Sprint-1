package com.aptitudeguru.dashboard;

import java.util.ArrayList;
import java.util.List;

//import com.example.taptap.DBH;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;;;



enum TABLE_NAMES
{TABLE_TUTORIAL, TABLE_FAVOURITE, TABLE_SBTABLE, TABLE_PUZZLETABLE,
	TABLE_CLANGUAGE, TABLE_CPPLANGUAGE, TABLE_JAVALANGUAGE, TABLE_HTMLLANGUAGE,TABLE_VL,
	TABLE_OS,TABLE_DBMS,TABLE_DSA,QUANTITIVE_TABLE};


public class DatabaseHandler extends SQLiteOpenHelper {

	
	private static final int DATABASE_VERSION = 1;

	
	private static final String DATABASE_NAME = "aptitudedatabase";



	private static class TestTableNamesHashMap extends HashMap{
		public TestTableNamesHashMap()
		{
			this.put(TABLE_NAMES.QUANTITIVE_TABLE, "quants");
			this.put(TABLE_NAMES.TABLE_FAVOURITE, "favourite");
			this.put(TABLE_NAMES.TABLE_SBTABLE, "sbtable");
			this.put(TABLE_NAMES.TABLE_PUZZLETABLE, "PuzzleTable");
			this.put(TABLE_NAMES.TABLE_TUTORIAL, "tutorial");
			this.put(TABLE_NAMES.TABLE_CLANGUAGE, "clanguage");
			this.put(TABLE_NAMES.TABLE_CPPLANGUAGE, "cpplanguage");
			this.put(TABLE_NAMES.TABLE_JAVALANGUAGE, "javalanguage");
			this.put(TABLE_NAMES.TABLE_HTMLLANGUAGE, "htmllanguage");		
			this.put(TABLE_NAMES.TABLE_VL, "vl");
			this.put(TABLE_NAMES.TABLE_OS, "os");
			this.put(TABLE_NAMES.TABLE_DBMS, "dbms");
			this.put(TABLE_NAMES.TABLE_DSA, "dsa");			

		}
	}
	
	private static HashMap table_names_map = new TestTableNamesHashMap();	

	
	
	private static final String KEY_ID = "id";
	private static final String KEY_QUESTION_TEXT = "questiontext";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_SOLUTION = "sol";
	private static final String KEY_OPTION1 = "option1";
	private static final String KEY_OPTION2 = "option2";
	private static final String KEY_OPTION3 = "option3";
	private static final String KEY_OPTION4 = "option4";
	
	
	
	

	private static final String KEY_SBSECTION = "sbsection";
	private static final String KEY_SBSUBSECTION = "sbsubsection";
	private static final String KEY_SBDATETIME = "sbdatetime";
	private static final String KEY_SBSCORE = "sbscore";
	private static final String KEY_SBTT = "sbtt";





	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		for (TABLE_NAMES name : TABLE_NAMES.values()) {
			String new_table = "CREATE TABLE " + table_names_map.get(name) + "("
					+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_TEXT
					+ " TEXT," + KEY_CATEGORY + " TEXT," + KEY_OPTION1 + " TEXT,"
					+ KEY_OPTION2 + " TEXT," + KEY_OPTION3 + " TEXT," + KEY_OPTION4
					+ " TEXT," + KEY_SOLUTION + " TEXT" + ")";
			db.execSQL(new_table);
		}

		String CREATE_TUTORIAL_TABLE = "CREATE TABLE " + table_names_map.get(TABLE_NAMES.TABLE_TUTORIAL) + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATEGORY + " TEXT,"
				+ KEY_QUESTION_TEXT + " TEXT" + ")";



		String CREATE_SBTABLE_TABLE = "CREATE TABLE " + table_names_map.get(TABLE_NAMES.TABLE_SBTABLE) + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_SBSECTION + " TEXT,"
				+ KEY_SBSUBSECTION + " TEXT," + KEY_SBDATETIME + " TEXT,"
				+ KEY_SBSCORE + " TEXT," + KEY_SBTT + " TEXT" + ")";

		String CREATE_PUZZLE_TABLE = "CREATE TABLE " + table_names_map.get(TABLE_NAMES.TABLE_PUZZLETABLE) + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_TEXT
				+ " TEXT," + KEY_SOLUTION + " TEXT" + ")";

		db.execSQL(CREATE_TUTORIAL_TABLE);
		db.execSQL(CREATE_SBTABLE_TABLE);
		db.execSQL(CREATE_PUZZLE_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		for (TABLE_NAMES name : TABLE_NAMES.values()) 
			db.execSQL("DROP TABLE IF EXISTS " + table_names_map.get(name));
		
		// Create tables again
		onCreate(db);

	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new PUZZLE TABLE(SBTABLE)
	void addPuzzle(PuzzleTable q) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESTION_TEXT, q.getQues()); 
		values.put(KEY_SOLUTION, q.getSol());
		db.insert((String)table_names_map.get(TABLE_NAMES.TABLE_PUZZLETABLE), null, values);		
		db.close();
	}
	
	
	


	void addSbtable(sbtable q) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_SBSECTION, q.getSection()); // Contact Name
		values.put(KEY_SBSUBSECTION, q.getSubsection());
		values.put(KEY_SBDATETIME, q.getDatetime());
		values.put(KEY_SBSCORE, q.getScore());
		values.put(KEY_SBTT, q.gettt());
		db.insert((String)table_names_map.get(TABLE_NAMES.TABLE_SBTABLE), null, values);		
		db.close(); // Closing database connection
	}

	void addQuestion(TABLE_NAMES t_name, Favourite q) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_QUESTION_TEXT, q.getQues()); // Contact Name

		values.put(KEY_OPTION1, q.getOptions()[0]);
		values.put(KEY_OPTION2, q.getOptions()[1]);
		values.put(KEY_OPTION3, q.getOptions()[2]);
		values.put(KEY_OPTION4, q.getOptions()[3]);
		values.put(KEY_SOLUTION, q.getSol());
		// Contact Phone

		// Inserting Row
		db.insert((String) this.table_names_map.get(t_name), null, values);
		
		db.close(); // Closing database connection
	}

	sbtable getSbtable(String cat) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query((String)table_names_map.get(TABLE_NAMES.TABLE_SBTABLE), new String[] { KEY_ID,
				KEY_SBSECTION, KEY_SBSUBSECTION, KEY_SBDATETIME, KEY_SBSCORE },
				KEY_SBSUBSECTION + "=?", new String[] { String.valueOf(cat) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		sbtable v = new sbtable(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5));
		// return contact
		return v;
	}

	PuzzleTable getPuzzle(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query((String)table_names_map.get(TABLE_NAMES.TABLE_PUZZLETABLE), new String[] {
				KEY_ID, KEY_QUESTION_TEXT, KEY_SOLUTION }, KEY_ID
				+ "=?", new String[] { String.valueOf(id) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		PuzzleTable v = new PuzzleTable(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return contact
		return v;
	}

	public List<PuzzleTable> getAllPuzzle() {
		List<PuzzleTable> VList = new ArrayList<PuzzleTable>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + (String)table_names_map.get(TABLE_NAMES.TABLE_PUZZLETABLE);
	
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to li
		if (cursor.moveToFirst()) {
			do {
				
				PuzzleTable v = new PuzzleTable();
				v.setID(Integer.parseInt(cursor.getString(0)));
				v.setQues(cursor.getString(1));
				// v.setCat(cursor.getString(2));

				v.setSol(cursor.getString(2));
				// Adding contact to list
				VList.add(v);
			} while (cursor.moveToNext());
		}

		// return contact list
		return VList;
	}
	
	public List<sbtable> getAllsbtable(String cat) {
		List<sbtable> quantsList = new ArrayList<sbtable>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + (String)table_names_map.get(TABLE_NAMES.TABLE_SBTABLE) + " where "
				+ KEY_SBSUBSECTION + "=" + "'" + cat + "'";
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		// looping through all rows and adding to li
		if (cursor.moveToFirst()) {
			do {

				
				sbtable quants = new sbtable();
				quants.setID(Integer.parseInt(cursor.getString(0)));
				quants.setSection(cursor.getString(1));
				quants.setSubsection(cursor.getString(2));
				quants.setdatetime(cursor.getString(3));
				quants.setScore(cursor.getString(4));
				quants.settt(cursor.getString(5));

				// Adding contact to list
				quantsList.add(quants);

				
			} while (cursor.moveToNext());
		}

		// return contact list
		db.close();
		return quantsList;
		
	}

	public List<QuestionRecord> getQuestions(TABLE_NAMES type, String cat) {
		
		List<QuestionRecord> quantsList = new ArrayList<QuestionRecord>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + table_names_map.get(type) + " WHERE "
				+ KEY_CATEGORY + "=" + "'" + cat + "'";	
				
					//String selectQuery = "SELECT  * FROM " + table_types_map.get(type);		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
	
		// looping through all rows and adding to li
		if (cursor.moveToFirst()) {
			do {				
				QuestionRecord question = new QuestionRecord();
				question.setID(Integer.parseInt(cursor.getString(0)));
				question.setQuestion(cursor.getString(1));
				question.setCategory(cursor.getString(2));
				String[] options = new String[]{cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)};
				question.setOptions(options);
				question.setSolution(cursor.getString(7));
				quantsList.add(question);
				
			} while (cursor.moveToNext());
		}

		// return contact list
		db.close();
		return quantsList;
	}
	public List<QuestionRecord> getAllQuestions(TABLE_NAMES type) {
		
		List<QuestionRecord> quantsList = new ArrayList<QuestionRecord>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + table_names_map.get(type);
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
	
		// looping through all rows and adding to li
		if (cursor.moveToFirst()) {
			do {

				
				QuestionRecord question = new QuestionRecord();
				question.setID(Integer.parseInt(cursor.getString(0)));
				question.setQuestion(cursor.getString(1));
				question.setCategory(cursor.getString(2));
				String[] options = new String[]{cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)};
				question.setOptions(options);
				question.setSolution(cursor.getString(7));
				// Adding contact to list
				quantsList.add(question);

				
			} while (cursor.moveToNext());
		}

		// return contact list
		db.close();
		return quantsList;
	}	
	
	QuestionRecord getQuestion(TABLE_NAMES type, int id) {
		
		List<QuestionRecord> quantsList = new ArrayList<QuestionRecord>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + table_names_map.get(type) + " where "
				+ KEY_ID + "=" + "'" + id + "'";		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
	
		if (cursor != null)
			cursor.moveToFirst();
		
		QuestionRecord question = new QuestionRecord();
		question.setID(Integer.parseInt(cursor.getString(0)));
		question.setQuestion(cursor.getString(1));
		question.setCategory(cursor.getString(2));
		String[] options = new String[]{cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)};
		question.setOptions(options);
		question.setSolution(cursor.getString(7));

		return question;

	}
	
	QuestionRecord getQuestion(TABLE_NAMES type, int id, String cat) {
		
		List<QuestionRecord> quantsList = new ArrayList<QuestionRecord>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + table_names_map.get(type) + " where "
				+ KEY_ID + "=" + "'" + id + "'" +" AND " + KEY_CATEGORY + "=" + "'" + cat + "'";		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
	
		if (cursor != null)
			cursor.moveToFirst();
		
		QuestionRecord question = new QuestionRecord();
		question.setID(Integer.parseInt(cursor.getString(0)));
		question.setQuestion(cursor.getString(1));
		question.setCategory(cursor.getString(2));
		String[] options = new String[]{cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)};
		question.setOptions(options);
		question.setSolution(cursor.getString(7));

		return question;

	}

	public int updateQuestion(TABLE_NAMES type, QuestionRecord question) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_QUESTION_TEXT, question.getQuestion()); // Contact Name
		values.put(KEY_CATEGORY, question.getCategory());
		String[] options = question.getOptions();
		values.put(KEY_OPTION1, options[0]);
		values.put(KEY_OPTION2, options[1]);
		values.put(KEY_OPTION3, options[2]);
		values.put(KEY_OPTION4, options[3]);
		values.put(KEY_SOLUTION, question.getSolution());

		// updating row
		return db.update((String) table_names_map.get(type), values, KEY_ID + " = ?",
				new String[] { String.valueOf(question.getID()) });
	}

	public void deleteQuestion(TABLE_NAMES type, QuestionRecord quants) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete((String) table_names_map.get(type), KEY_ID + " = ?",
				new String[] { String.valueOf(quants.getID()) });
		db.close();
	}

	public void deletesb(sbtable v) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete((String)table_names_map.get(TABLE_NAMES.TABLE_SBTABLE), KEY_ID + " = ?",
				new String[] { String.valueOf(v.getID()) });
		db.close();
	}

	public int getQuestionsCount(TABLE_NAMES type) {
		return this.getAllQuestions(type).size();
	}

}