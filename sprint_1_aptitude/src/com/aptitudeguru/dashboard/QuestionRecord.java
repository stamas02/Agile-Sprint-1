package com.aptitudeguru.dashboard;

import java.util.Locale;

public class QuestionRecord {

	
	int _questionid;
	String _questiontext;
	String _questioncategory;
	String[] options = new String[4];
	String _solution;

	
	public QuestionRecord() {

	}

	
	public QuestionRecord(int questionid, String questiontext, String questioncategory,
			String option1, String option2, String option3, String option4,
			String solution) {
		this._questionid = questionid;
		this._questiontext = questiontext;
		this._questioncategory = questioncategory;
		this.options[0] = option1;
		this.options[1] = option2;
		this.options[2] = option3;
		this.options[3] = option4;
		this._solution = solution;
	}

	public QuestionRecord(String quantsques, String quantscat, String option1,
			String option2, String option3, String option4, String sol) {

		this._questiontext = quantsques;
		this._questioncategory = quantscat;
		this.options[0] = option1;
		this.options[1] = option2;
		this.options[2] = option3;
		this.options[3] = option4;
		this._solution = sol;
	}

	
	public int getID() {
		return this._questionid;
	}


	public void setID(int quantsid) {
		this._questionid = quantsid;
	}


	public String getQuestion() {
		
		String checkedTestQestion = "";
		
		if ( Locale.getDefault().toString().contains("GB") && _questiontext.contains("Rs.") ) {
			checkedTestQestion = _questiontext.replaceAll("Rs\\. ", "\\£");
			return checkedTestQestion;
		} if ( Locale.getDefault().toString().contains("US") && _questiontext.contains("Rs.") ) {
			checkedTestQestion = _questiontext.replaceAll("Rs\\. ", "\\$");
			return checkedTestQestion;
		} if ( Locale.getDefault().toString().contains("FR") && _questiontext.contains("Rs.") ) {
			checkedTestQestion = _questiontext.replaceAll("Rs\\. ", "\\€");
			return checkedTestQestion;
		} else {
			return this._questiontext;
		}
		
		//return this._questiontext; 	// the original code of the method (yes, just that 1 line)
	}

	
	public void setQuestion(String quantsques) {
		this._questiontext = quantsques;
	}

	
	public String getCategory() {
		return this._questioncategory;
	}

	
	public void setCategory(String quantscat) {
		this._questioncategory = quantscat;
	}

	
	
	public String[] getOptions() {
		return this.options;
	}


	public String getSolution() {
		return this._solution;
	}

	public void setSolution(String sol) {
		this._solution = sol;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

}
