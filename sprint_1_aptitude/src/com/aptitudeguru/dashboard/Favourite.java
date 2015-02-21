package com.aptitudeguru.dashboard;

public class Favourite {
	
	int _favouriteid;
	String _favouriteques;
	
	String[] options = new String[4];
	String _sol;
	
	public Favourite() {

	}

	
	public Favourite(int favouriteid, String favouriteques, String[] options, String sol) {
		this._favouriteid = favouriteid;
		this._favouriteques = favouriteques;
		this.options = options;
		this._sol = sol;
	}

	public Favourite(String favouriteques, String[] options, String sol) {

		this._favouriteques = favouriteques;
		
		this.options = options;
		this._sol = sol;
	}

	
	public int getID() {
		return this._favouriteid;
	}

	
	public void setID(int favouriteid) {
		this._favouriteid = favouriteid;
	}

	
	public String getQues() {
		return this._favouriteques;
	}

	
	public void setQues(String favouriteques) {
		this._favouriteques = favouriteques;
	}

	
	
	
	public String[] getOptions() {
		return this.options;
	}

	public String getSol() {
		return this._sol;
	}

	public void setSol(String sol) {
		this._sol = sol;
	}

}
