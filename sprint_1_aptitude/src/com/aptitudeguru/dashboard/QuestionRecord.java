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
		
		String questionText =  this._questiontext;
		String checkedTestQestion = "";
		
		if ( Locale.getDefault().toString().contains("GB") ) {
			
			
			if (questionText.contains("Rs.")) {
				checkedTestQestion = questionText.replaceAll("Rs. ", "\\£");
				return checkedTestQestion;
			}
			if (questionText.contains("Rs")) {
				checkedTestQestion = questionText.replaceAll("Rs ", "\\£");
				return checkedTestQestion;
			}
			if (questionText.contains("rupee")) {
				checkedTestQestion = questionText.replaceAll("rupee", "pound");
				return checkedTestQestion;
			}
			
			// breaks for questions 178, 176
			if (questionText.contains("km")) { 
				checkedTestQestion = questionText.replaceAll("km", " miles");
				return checkedTestQestion;
			}
			if (questionText.contains("km/hr")) {
				checkedTestQestion = questionText.replaceAll("km/hr", " mph");
				return checkedTestQestion;
			}	
			if (questionText.contains("kmph")) { 
				checkedTestQestion = questionText.replaceAll("kmph", " mph");
				return checkedTestQestion;
			}
							
				
			/*	
			} else if (_questiontext.contains("km")) {
				if (_questiontext.contains("km/hr")) {
					checkedTestQestion = _questiontext.replaceAll("km/hr", " mph");
				} else if (_questiontext.contains("km ")) { 
					checkedTestQestion = _questiontext.replaceAll("km ", " miles ");
				}				
			} 
			*/
						
			
		} if ( Locale.getDefault().toString().contains("US") && questionText.contains("Rs.") ) {
			
			if (questionText.contains("Rs.")) {
				checkedTestQestion = questionText.replaceAll("Rs. ", "\\$");
				return checkedTestQestion;
			}
			if (questionText.contains("Rs")) {
				checkedTestQestion = questionText.replaceAll("Rs ", "\\$");
				return checkedTestQestion;
			}
			if (questionText.contains("rupee")) {
				checkedTestQestion = questionText.replaceAll("rupee", "dollar");
				return checkedTestQestion;
			}
			
			// breaks for questions 178, 176
			if (questionText.contains("km")) { 
				checkedTestQestion = questionText.replaceAll("km", " miles");
				return checkedTestQestion;
			}
			if (questionText.contains("km/hr")) {
				checkedTestQestion = questionText.replaceAll("km/hr", " mph");
				return checkedTestQestion;
			}	
			if (questionText.contains("kmph")) { 
				checkedTestQestion = questionText.replaceAll("kmph", " mph");
				return checkedTestQestion;
			}
		}
		
		
		
		if ( Locale.getDefault().toString().contains("FR") && questionText.contains("Rs.") ) {
			checkedTestQestion = questionText.replaceAll("Rs\\. ", "\\€");
			return checkedTestQestion;
		} else {
			return questionText;
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
				
		
		String[] optionsNew = this.options;
		String asnwer1 = optionsNew[0]; 
		String asnwer2 = optionsNew[1];
		String asnwer3 = optionsNew[2];
		String asnwer4 = optionsNew[3];
		
		if (asnwer1.endsWith("kmph")) {
			String newAns1 = asnwer1.replaceAll("kmph", "mph");
			String newAns2 = asnwer2.replaceAll("kmph", "mph");
			String newAns3 = asnwer3.replaceAll("kmph", "mph");
			String newAns4 = asnwer4.replaceAll("kmph", "mph");
			optionsNew = new String[]{newAns1,newAns2,newAns3,newAns4};			
		}
		if (asnwer1.endsWith("km")) {
			String newAns1 = asnwer1.replaceAll("km", " miles");
			String newAns2 = asnwer2.replaceAll("km", " miles");
			String newAns3 = asnwer3.replaceAll("km", " miles");
			String newAns4 = asnwer4.replaceAll("km", " miles");
			optionsNew = new String[]{newAns1,newAns2,newAns3,newAns4};			
		}		
		else if (!asnwer1.contains("kmph")) {
			optionsNew = new String[]{asnwer1,asnwer2,asnwer3,asnwer4};
			
		}
		return optionsNew;
		
		
		//return this.options;
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
