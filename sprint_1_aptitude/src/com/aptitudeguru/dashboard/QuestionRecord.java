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
		
		
		if (Locale.getDefault().toString().contains("GB")) {

			if (questionText.contains("km/hr")) {
				checkedTestQestion = questionText.replaceAll("km/hr", "mph");
				// System.out.println(checkedTestQestion);
				// return checkedTestQestion;
			} else {
				checkedTestQestion = questionText;
			}

			if (checkedTestQestion.contains("kmph")) {
				checkedTestQestion = checkedTestQestion.replaceAll("kmph", "mph");
				// System.out.println(questionText);
				// return questionText;
			}			
			if (checkedTestQestion.contains("km")) {
				checkedTestQestion = checkedTestQestion.replaceAll("km", "miles");
				// System.out.println(checkedTestQestion);
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("Rs.")) {
				checkedTestQestion = checkedTestQestion.replaceAll("Rs.", "\\£");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("Rs")) {
				checkedTestQestion = checkedTestQestion.replaceAll("Rs", "\\£");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupees")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupees", "pounds");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupee")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupee", "pound");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" feet")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" feet", " meters");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" ft")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" ft", " meters");
				// return checkedTestQestion;
			}
		}
		
				
		else if (Locale.getDefault().toString().contains("US")) {
			
			if (questionText.contains("km/hr")) {
				checkedTestQestion = questionText.replaceAll("km/hr", "mph");
				// System.out.println(checkedTestQestion);
				// return checkedTestQestion;
			} else {
				checkedTestQestion = questionText;
			}

			if (checkedTestQestion.contains("kmph")) {
				checkedTestQestion = checkedTestQestion.replaceAll("kmph", "mph");
				// System.out.println(questionText);
				// return questionText;
			}
			if (checkedTestQestion.contains("km")) {
				checkedTestQestion = checkedTestQestion.replaceAll("km", "miles");
				// System.out.println(checkedTestQestion);
				// return checkedTestQestion;
			}
			// Log.d("OUTPUT: ", checkedTestQestion);
			// return checkedTestQestion;

			if (checkedTestQestion.contains(" Rs.")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" Rs.", " \\$");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" Rs")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" Rs", " \\$");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupees")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupees", "dollars");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupee")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupee", "dollar");
				// return checkedTestQestion;
			}
						
			if (checkedTestQestion.contains("kg")) {
				checkedTestQestion = checkedTestQestion.replaceAll("kg", "pound(s)");
			}
			if (checkedTestQestion.contains("centimetres")) {
				checkedTestQestion = checkedTestQestion.replaceAll("centimetres", "inches");
			}
			if (checkedTestQestion.contains("centimetre")) {
				checkedTestQestion = checkedTestQestion.replaceAll("centimetre", "inch");
			}			
			if (checkedTestQestion.contains(" cm")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" cm", " inches");
			}
			if (checkedTestQestion.contains(" cm.")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" cm.", " inches.");
			}
			if (checkedTestQestion.contains(" metres")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" metres", " feet");
			}
			if (checkedTestQestion.contains(" metre")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" metre", "foot");
			}
			if (checkedTestQestion.contains(" m3")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" m3", " inches3");
			}
			if (checkedTestQestion.contains(" m2")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" m2", " inches2");
			}
			if (checkedTestQestion.contains(" mm")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" mm", " 1/10*inches");
			}
			if (checkedTestQestion.contains(" m.")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" m.", " feet,");
			}			
			if (checkedTestQestion.contains(" m,") ) {
				checkedTestQestion = checkedTestQestion.replaceAll(" m,", " feet,");
			}			
			if (checkedTestQestion.contains(" m ")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" m ", " feet ");
			}
			if (checkedTestQestion.contains(" g/")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" g/", " (1/1000*pound)/");
			}
			if (checkedTestQestion.contains(" g")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" g ", " 1/1000*pound ");
			}
			if (checkedTestQestion.contains(" g.")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" g ", " 1/1000*pound.");
			}
			
		}
		
		
		else if (Locale.getDefault().toString().contains("FR")) {
			
			if (questionText.contains(" Rs.")) {
				checkedTestQestion = questionText.replaceAll(" Rs.", " \\€");
				// return checkedTestQestion;
			} else {
				checkedTestQestion = questionText;
			}
			if (checkedTestQestion.contains(" Rs")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" Rs", " \\€");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupees")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupees", "euros");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains("rupee")) {
				checkedTestQestion = checkedTestQestion.replaceAll("rupee", "euro");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" feet")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" feet", " meters");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" ft")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" ft", " meters");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" miles")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" miles", " km");
				// return checkedTestQestion;
			}
			if (checkedTestQestion.contains(" mile")) {
				checkedTestQestion = checkedTestQestion.replaceAll(" mile", " km");
				// return checkedTestQestion;
			}
		}

		return checkedTestQestion;

		// return this._questiontext; // the original code of the method (yes,just that 1 line)
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
		String answer1 = optionsNew[0]; 
		String answer2 = optionsNew[1];
		String answer3 = optionsNew[2];
		String answer4 = optionsNew[3];
		
		String newAns1 = answer1;
		String newAns2 = answer2;
		String newAns3 = answer3;
		String newAns4 = answer4;
		
		
		/* because the answers in the database were written by someone that
		 * apparently didn't care about formatting even the slightest
		 * and I am trying to minimise coupling
		 * I am checking to see if there is a whitespace before the first answer:
		 */
		
		if (Locale.getDefault().toString().contains("GB")) {
			if (answer1.startsWith("Rs.") || answer1.startsWith(" Rs.")) {
				 newAns1 = answer1.replaceAll("Rs.", "\\£");
				 newAns2 = answer2.replaceAll("Rs.", "\\£");
				 newAns3 = answer3.replaceAll("Rs.", "\\£");
				 newAns4 = answer4.replaceAll("Rs.", "\\£");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.startsWith("Rs") || answer1.startsWith(" Rs")) {
				 newAns1 = answer1.replaceAll("Rs", "\\£");
				 newAns2 = answer2.replaceAll("Rs", "\\£");
				 newAns3 = answer3.replaceAll("Rs", "\\£");
				 newAns4 = answer4.replaceAll("Rs", "\\£");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.endsWith("kmph")) {
				 newAns1 = answer1.replaceAll("kmph", "mph");
				 newAns2 = answer2.replaceAll("kmph", "mph");
				 newAns3 = answer3.replaceAll("kmph", "mph");
				 newAns4 = answer4.replaceAll("kmph", "mph");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.endsWith("km")) {
				 newAns2 = answer2.replaceAll("km", " miles");
				 newAns3 = answer3.replaceAll("km", " miles");
				 newAns4 = answer4.replaceAll("km", " miles");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			} 
			else if (answer1.endsWith(" ft")) {
				 newAns1 = answer1.replaceAll(" ft", " m");
				 newAns2 = answer2.replaceAll(" ft", " m");
				 newAns3 = answer3.replaceAll(" ft", " m");
				 newAns4 = answer4.replaceAll(" ft", " m");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
		}
		
		
		else if (Locale.getDefault().toString().contains("US")) {
			if (answer1.startsWith("Rs.") || answer1.startsWith(" Rs.")) {
				 newAns1 = answer1.replaceAll("Rs.", "\\$");
				 newAns2 = answer2.replaceAll("Rs.", "\\$");
				 newAns3 = answer3.replaceAll("Rs.", "\\$");
				 newAns4 = answer4.replaceAll("Rs.", "\\$");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.startsWith("Rs") || answer1.startsWith(" Rs")) {
				 newAns1 = answer1.replaceAll("Rs", "\\$");
				 newAns2 = answer2.replaceAll("Rs", "\\$");
				 newAns3 = answer3.replaceAll("Rs", "\\$");
				 newAns4 = answer4.replaceAll("Rs", "\\$");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.endsWith("kmph")) {
				 newAns1 = answer1.replaceAll("kmph", "mph");
				 newAns2 = answer2.replaceAll("kmph", "mph");
				 newAns3 = answer3.replaceAll("kmph", "mph");
				 newAns4 = answer4.replaceAll("kmph", "mph");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.endsWith("km")) {
				 newAns1 = answer1.replaceAll("km", " miles");
				 newAns2 = answer2.replaceAll("km", " miles");
				 newAns3 = answer3.replaceAll("km", " miles");
				 newAns4 = answer4.replaceAll("km", " miles");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.endsWith("kg")) {
				 newAns1 = answer1.replaceAll("kg", " pounds");
				 newAns2 = answer2.replaceAll("kg", " pounds");
				 newAns3 = answer3.replaceAll("kg", " pounds");
				 newAns4 = answer4.replaceAll("kg", " pounds");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			} else {

				if (answer1.endsWith("metres")) {
					 newAns1 = answer1.replaceAll(" metres", " feet");
				} else if (answer1.endsWith(" cm3")) {
					 newAns1 = answer1.replaceAll(" cm3", " inches3");
				} else if (answer1.endsWith(" cm2")) {
					 newAns1 = answer1.replaceAll(" cm2", " inches2");
				} else if (answer1.endsWith(" cm")) {
					 newAns1 = answer1.replaceAll(" cm", " inches");
				} else if (answer1.endsWith(" m3")) {
					 newAns1 = answer1.replaceAll(" m3", " feet3");
				} else if (answer1.endsWith(" m2")) {
					 newAns1 = answer1.replaceAll(" m2", " feet2");
				} else if (answer1.endsWith(" m")) {
					 newAns1 = answer1.replaceAll(" m", " feet");
				}  

				 if (answer2.endsWith("metres")) {
					 newAns2 = answer2.replaceAll("metres", " feet");
				} else if (answer2.endsWith(" dm")) {
					 newAns2 = answer2.replaceAll(" dm", " 1/10*feet");
				} else if (answer2.endsWith(" cm3")) {
					 newAns2 = answer2.replaceAll(" cm3", " inches3");
				} else if (answer2.endsWith(" cm2")) {
					 newAns2 = answer2.replaceAll(" cm2", " inches2");
				} else if (answer2.endsWith(" cm")) {
					 newAns2 = answer2.replaceAll(" cm", " inches");
				} else if (answer2.endsWith(" m3")) {
					 newAns2 = answer2.replaceAll(" m3", " feet3");
				} else if (answer2.endsWith(" m2")) {
					 newAns2 = answer2.replaceAll(" m2", " feet2");
				} else if (answer2.endsWith(" m")) {
					 newAns2 = answer2.replaceAll(" m", " feet");
				}  

				if (answer3.endsWith(" metres")) {
					 newAns3 = answer3.replaceAll(" metres", " feet");
				} else if (answer3.endsWith(" cm3")) {
					 newAns3 = answer3.replaceAll(" cm3", " inches3");
				} else if (answer3.endsWith(" cm2")) {
					 newAns3 = answer3.replaceAll(" cm2", " inches2");
				} else if (answer3.endsWith(" cm")) {
					 newAns3 = answer3.replaceAll(" cm", " inches");
				} else if (answer3.endsWith(" m3")) {
					 newAns3 = answer3.replaceAll(" m3", " feet3");
				} else if (answer3.endsWith(" m2")) {
					 newAns3 = answer3.replaceAll(" m2", " feet2");
				} else if (answer3.endsWith(" m")) {
					 newAns3 = answer3.replaceAll(" m", " feet");
				}  

				if (answer4.endsWith(" metres")) {
					 newAns4 = answer4.replaceAll(" metres", " feet");
				} else if (answer4.endsWith(" cm3")) {
					 newAns4 = answer4.replaceAll(" cm3", " inches3");
				} else if (answer4.endsWith(" cm2")) {
					 newAns4 = answer4.replaceAll(" cm2", " inches2");
				} else if (answer4.endsWith(" cm")) {
					 newAns4 = answer4.replaceAll(" cm", " inches");
				} else if (answer4.endsWith(" m3")) {
					 newAns4 = answer4.replaceAll(" m3", " feet3");
				} else if (answer4.endsWith(" m2")) {
					 newAns4 = answer4.replaceAll(" m2", " feet2");
				} else if (answer4.endsWith(" m")) {
					 newAns4 = answer4.replaceAll(" m", " feet");
				}  
				 
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
					
		}
		
		
		else if (Locale.getDefault().toString().contains("FR")) {
			if (answer1.startsWith("Rs.") || answer1.startsWith(" Rs.")) {
				 newAns1 = answer1.replaceAll("Rs.", "\\€");
				 newAns2 = answer2.replaceAll("Rs.", "\\€");
				 newAns3 = answer3.replaceAll("Rs.", "\\€");
				 newAns4 = answer4.replaceAll("Rs.", "\\€");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
			else if (answer1.startsWith("Rs") || answer1.startsWith(" Rs")) {
				 newAns1 = answer1.replaceAll("Rs", "\\€");
				 newAns2 = answer2.replaceAll("Rs", "\\€");
				 newAns3 = answer3.replaceAll("Rs", "\\€");
				 newAns4 = answer4.replaceAll("Rs", "\\€");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			} else if (answer1.endsWith("ft")) {
				 newAns1 = answer1.replaceAll("ft", "m");
				 newAns2 = answer2.replaceAll("ft", "m");
				 newAns3 = answer3.replaceAll("ft", "m");
				 newAns4 = answer4.replaceAll("ft", "m");
				optionsNew = new String[] { newAns1, newAns2, newAns3, newAns4 };
			}
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
