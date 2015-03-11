package com.aptitudeguru.dashboard;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;
import android.widget.Toast;
import androidhive.dashboard.R;

public class TestPage extends Activity implements OnClickListener

{
	TextView t1, t2;
	RadioButton[] options_radiobutton = new RadioButton[4];
	int count = 1;
	int start = 1;
	int quesvisible = 0;
	static int min = 0, sec = 0;;
	int index1 = 0, index = 0, index3 = 0;
	int chacked_answers[] = new int[40];
	int ans[] = new int[40];
	int ansindex = 0;
	// NewsFeedActivity n=new NewsFeedActivity();
	String cat = "";
	int test_category;
	int click = 0;
	int question_ids[] = new int[40];
	int initial[] = new int[40];
	int initans[] = new int[40];
	int givenans[] = new int[40];
	int gotoclick[] = new int[20];
	Random r = new Random();
	int STATIC_INTEGER_VALUE = 1;
	String PUBLIC_STATIC_STRING_IDENTIFIER;
	final Context context = this;
	String time;

	Button btn_next;
	Button btn_prev;

	DatabaseHandler db = new DatabaseHandler(this);

	// String category="7777";
	private CountDownTimer countDownTimer;

	private boolean timerHasStarted = false;
	public TextView text;
	private long startTime = 60 * 20 * 1000;
	private final long interval = 1 * 1000;
	private long starttime1 = 60 * 20 * 1000;
	private long milifin = 0;

	int k1 = 0;

	// private final long startTime1 =
	// private final long interval1 = 60*20 * 1000;

	// create button instances

	@Override
	protected void onPause() {
		// Always call the superclass method first
		super.onPause();
		countDownTimer.cancel();
		// Activity being restarted from stopped state
	}

	@Override
	protected void onResume() {
		// Always call the superclass method first
		super.onResume();
		countDownTimer.cancel();

		if (k1 == 1) {
			timerHasStarted = false;

			if (!timerHasStarted) {
				// countDownTimer.start();
				countDownTimer = new MyCountDownTimer(starttime1, interval);
				timerHasStarted = true;

				countDownTimer.start();

				// startB.setText("STOP");
			} else {
				countDownTimer.cancel();
				timerHasStarted = false;
				// startB.setText("RESTART");
			}

			// Activity being restarted from stopped state
		}
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(getApplicationContext(), "You Cannot Exit",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		String extraData = data.getStringExtra("ComingFrom");
		int j1 = Integer.parseInt(extraData);

		int j2 = question_ids[j1];
		click = j1;

		if (click == 0) {
			btn_prev.setEnabled(false);

			btn_prev.setVisibility(View.INVISIBLE);
		} else {
			btn_next.setEnabled(true);
			btn_prev.setEnabled(true);
			btn_next.setVisibility(View.VISIBLE);
			btn_prev.setVisibility(View.VISIBLE);
		}
		if (click == 19) {
			btn_next.setEnabled(false);
			btn_next.setVisibility(View.INVISIBLE);

		}

		else {
			btn_prev.setEnabled(true);
			btn_next.setEnabled(true);
			btn_next.setVisibility(View.VISIBLE);
			btn_prev.setVisibility(View.VISIBLE);
		}
		
		for (RadioButton rb : options_radiobutton)
			rb.setChecked(false);

		RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
		radiogroup.clearCheck();
		int check = chacked_answers[click];
		
		options_radiobutton[check].setChecked(true);

		QuestionRecord q = db.getQuestion(TABLE_NAMES.values()[test_category], j2, cat);
		// i=i+1;
		String j = q.getQuestion();
		t1.setText(j);
		t2.setText("   " + (j1 + 1) + "/20");
		
		String[] options = q.getOptions();

		
		for (RadioButton rb : options_radiobutton)
			rb.setChecked(false);
		
		for (int i = 0; i < options.length; i++)
			options_radiobutton[i].setText(options[i]);
	}

	
	private void setUpQuestion(QuestionRecord q)
	{
		String[] options = q.getOptions();
		
		for (RadioButton rb : options_radiobutton)
			rb.setChecked(false);
		
		for (int i = 0; i < options.length; i++)
			options_radiobutton[i].setText(options[i]);
	}
	
	
	private void clearRadiobuttons (RadioButton[] radiobuttons)
	{
		for (RadioButton rb : radiobuttons)
			rb.setChecked(false);
	}
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		Bundle bundle = getIntent().getExtras();
		cat = bundle.getString("sub_categry");
		test_category =  bundle.getInt("test_category");
		start = bundle.getInt("start");

		for (int i = 0; i < chacked_answers.length; i++)
		{
			chacked_answers[i] = -1;
		}
		
		options_radiobutton[0] = (RadioButton) findViewById(R.id.option1);
		options_radiobutton[1] = (RadioButton) findViewById(R.id.option2);
		options_radiobutton[2] = (RadioButton) findViewById(R.id.option3);
		options_radiobutton[3] = (RadioButton) findViewById(R.id.option4);
		
		text = (TextView) this.findViewById(R.id.timer);
		countDownTimer = new MyCountDownTimer(startTime, interval);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		TextView title = new TextView(context);
		title.setText("Aptitude App");
		title.setBackgroundColor(Color.DKGRAY);
		title.setPadding(10, 10, 10, 10);
		title.setGravity(Gravity.CENTER);
		title.setTextColor(Color.WHITE);
		title.setTextSize(20);
		alertDialogBuilder.setCustomTitle(title);

		// set title
		// alertDialogBuilder.setTitle("Apptitude App");

		// set dialog message
		alertDialogBuilder
				.setMessage("Start Test?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity

								if (!timerHasStarted) {
									countDownTimer.start();
									k1 = 1;
									timerHasStarted = true;
									// startB.setText("STOP");
								} else {
									countDownTimer.cancel();
									timerHasStarted = false;
									// startB.setText("RESTART");
								}

								// next
								dialog.cancel();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing

						TestPage.this.finish();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

		// timer code

		// startB = (Button) this.findViewById(R.id.button);
		// startB.setOnClickListener( this);

		// text.setText(text.getText() + String.valueOf(startTime / 1000));

		/**
		 * Creating all buttons instances
		 * */
		// Dashboard News feed button
		Button btn_home = (Button) findViewById(R.id.btn_home);

		// Dashboard Friends button
		Button btn_fav = (Button) findViewById(R.id.btn_fav);

		// Dashboard Messages button
		Button btn_hint = (Button) findViewById(R.id.btn_hint);

		// Dashboard Places button
		Button btn_goto = (Button) findViewById(R.id.btn_goto);

		// Dashboard Events button
		Button btn_help = (Button) findViewById(R.id.btn_help);

		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), help1.class);

				startActivity(i);
			}
		});

		Button btn_finish = (Button) findViewById(R.id.btn_finish);

		// PAUSE TEST CODE
		Button btn_pause = (Button) findViewById(R.id.btn_pause);
		btn_pause.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), TestPause.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

		/**
		 * Handling all button click events
		 * */
		RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
		radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// RadioButton r1=(RadioButton)findViewById(R.id.option1);
				
				for (int i = 0; i < options_radiobutton.length; i++)
				{
					if (options_radiobutton[i].isChecked())
					{
						chacked_answers[click] = i+1;
						ans[click] = i+1;
						gotoclick[click] = 1;
					}
				}
			}

		});

		btn_finish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				TextView title = new TextView(context);
				title.setText("Aptitude App");
				title.setBackgroundColor(Color.DKGRAY);
				title.setPadding(10, 10, 10, 10);
				title.setGravity(Gravity.CENTER);
				title.setTextColor(Color.WHITE);
				title.setTextSize(20);
				alertDialogBuilder.setCustomTitle(title);

				// set title
				// alertDialogBuilder.setTitle();

				// set dialog message
				alertDialogBuilder
						.setMessage("Click yes to exit!")
						.setCancelable(false)
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// if this button is clicked, close
										// current activity
										Intent i = new Intent(
												getApplicationContext(),
												ShowScore.class);
										time = text.getText() + "";

										sec = sec + 40;
										String timetaken = min + "." + sec + "";

										double timetak = Float
												.parseFloat(timetaken);

										double tt = 20.00 - timetak;

										DecimalFormat df = new DecimalFormat(
												"00.00");
										String j = df.format(tt);

										i.putExtra("score", ans);
										i.putExtra("givenans", givenans);
										i.putExtra("allid", question_ids);
										i.putExtra("tt", j);
										i.putExtra("sub_categry", cat);
										i.putExtra("test_category", test_category);

										startActivity(i);
										TestPage.this.finish();
									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// if this button is clicked, just close
										// the dialog box and do nothing
										dialog.cancel();

									}
								});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it

				alertDialog.show();

			}
		});

		// Listening Friends button click
		btn_fav.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				// Intent i = new Intent(getApplicationContext(),
				// FriendsActivity.class);
				// startActivity(i);

				int val = question_ids[click];
				QuestionRecord q = db.getQuestion(TABLE_NAMES.values()[test_category], val, cat);
				String ques = q.getQuestion();
				String[] options = q.getOptions();
				String sol = q.getSolution();
				//db.addQuestion(new Favourite(ques, options, sol));

				Toast.makeText(getApplicationContext(), "Added To Favourite",
						Toast.LENGTH_SHORT).show();

				// show it

			}
		});

		

		// Listening Messages button click
		btn_hint.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Hint.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

		// Listening to Places button click
		btn_goto.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Calender.class);
				i.putExtra("gotoclick", gotoclick);
				i.putExtra("click", click);
				startActivityForResult(i, STATIC_INTEGER_VALUE);
			}
		});

		// Listening to Events button click

		int g = 0;
		
		List<QuestionRecord> quants = db.getQuestions(TABLE_NAMES.values()[test_category], cat);
		for (QuestionRecord cn : quants) {

			if (g == 38)
				break;
			else {
				g++;

				count = cn.getID();
				String sol1 = cn.getSolution();
				int sol = 0;
				if (sol1.equalsIgnoreCase("a"))
					sol = 1;
				else if (sol1.equalsIgnoreCase("b"))
					sol = 2;
				else if (sol1.equalsIgnoreCase("c"))
					sol = 3;
				else
					sol = 4;
				// int j=r.nextInt(2);
				// int k=(count+j+1);
				// count=k;
				initial[index3] = count;
				initans[index3] = sol;
				index3 = index3 + 1;
			}
		}

		count = r.nextInt(3);
		count = count + 1;

		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.questrack);

		btn_next = (Button) findViewById(R.id.btn_next);
		btn_prev = (Button) findViewById(R.id.btn_prev);

		QuestionRecord q = db.getQuestion(TABLE_NAMES.values()[test_category],initial[count], cat);

		question_ids[index++] = initial[count];
		givenans[0] = initans[count];
		t2.setText("   " + "1/20");
		String j = q.getQuestion();

		t1.setText(j);
		setUpQuestion(q);
		btn_next.setVisibility(View.VISIBLE);
		btn_prev.setVisibility(View.INVISIBLE);
		for (int x = 1; x < 20; x++) {
			int k = (count + 1);
			count = k;
			question_ids[index] = initial[k];
			givenans[index] = initans[k];
			index = index + 1;
		}

		btn_next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if (click == (19)) {
					btn_next.setEnabled(false);
					btn_next.setVisibility(View.INVISIBLE);

				} else {

					btn_next.setEnabled(true);
					btn_prev.setEnabled(true);
					btn_next.setVisibility(View.VISIBLE);
					btn_prev.setVisibility(View.VISIBLE);
					
					clearRadiobuttons(options_radiobutton);
					
					RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
					radiogroup.clearCheck();

					// radiogroup.setosetOnCheckedChangeListener(this);

					click = click + 1;

					int val = question_ids[click];
					int check = chacked_answers[click];
					
					
					

					t2.setText("   " + (click + 1) + "/20");

					QuestionRecord q = db.getQuestion(TABLE_NAMES.values()[test_category],val, cat);
					// i=i+1;
					String j = q.getQuestion();
					t1.setText(j);

					
					setUpQuestion(q);
					
					
					if (check != -1)
						options_radiobutton[check-1].setChecked(true);

				}

			}
		});
		// prev
		btn_prev.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if (click == 0) {
					btn_prev.setEnabled(false);
					btn_prev.setVisibility(View.INVISIBLE);

				} else {

					btn_prev.setEnabled(true);

					btn_next.setEnabled(true);
					btn_next.setVisibility(View.VISIBLE);
					btn_prev.setVisibility(View.VISIBLE);
					clearRadiobuttons(options_radiobutton);
					RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
					radiogroup.clearCheck();

					click = click - 1;
					int val = question_ids[click];
					int check = chacked_answers[click];	
					
					

					QuestionRecord q = db.getQuestion(TABLE_NAMES.values()[test_category],val, cat);
					// i=i+1;
					String j = q.getQuestion();
					t1.setText(j);
					t2.setText("   " + (click + 1) + "/20");
					t1.setText(j);
					setUpQuestion(q);
					
					if (check != -1)
						options_radiobutton[check-1].setChecked(true);

				}
			}
		});

	}

	// timer
	public void onClick(View v) {
		if (!timerHasStarted) {
			countDownTimer.start();
			timerHasStarted = true;
			// startB.setText("STOP");
		} else {
			countDownTimer.cancel();
			timerHasStarted = false;
			// startB.setText("RESTART");
		}
	}

	public class MyCountDownTimer extends CountDownTimer {
		long starttime3 = 0;

		public MyCountDownTimer(long startTime2, long interval) {
			super(startTime2, interval);
			starttime3 = startTime2;
		}

		@Override
		public void onFinish() {
			text.setText("Time's up!");
			AlertDialog alertDialog = new AlertDialog.Builder(TestPage.this)
					.create();

			TextView title = new TextView(context);
			title.setText("Aptitude App");
			title.setBackgroundColor(Color.DKGRAY);
			title.setPadding(10, 10, 10, 10);
			title.setGravity(Gravity.CENTER);
			title.setTextColor(Color.WHITE);
			title.setTextSize(20);
			alertDialog.setCustomTitle(title);

			// Setting Dialog Title
			// alertDialog.setTitle("Apptitude App");

			// Setting Dialog Message
			alertDialog.setMessage("TIME'S UP");

			// Setting Icon to Dialog
			alertDialog.setIcon(R.drawable.about);

			// Setting OK Button
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// Write your code here to execute after dialog closed
					Intent i = new Intent(getApplicationContext(),
							ShowScore.class);
					time = text.getText() + "";

					sec = sec + 40;
					String timetaken = min + "." + sec + "";

					double timetak = Float.parseFloat(timetaken);

					double tt = 20.00 - timetak;

					DecimalFormat df = new DecimalFormat("00.00");
					String j = df.format(tt);
					i.putExtra("tt", j);

					i.putExtra("score", ans);
					i.putExtra("givenans", givenans);
					i.putExtra("allid", question_ids);
					i.putExtra("sub_categry", cat);
					i.putExtra("test_category", test_category);
					startActivity(i);
					TestPage.this.finish();

				}
			});

			// Showing Alert Message
			alertDialog.show();

		}

		@Override
		public void onTick(long millisUntilFinished) {
			int seconds = (int) (millisUntilFinished / 1000) % 60;
			int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
			milifin = millisUntilFinished;
			starttime1 = milifin;

			min = minutes;
			sec = seconds;
			// tvTimerLabel.setVisibility(View.VISIBLE);
			text.setText((minutes) + ":" + (seconds) + "");
			// text.setText("" + millisUntilFinished / 1000);

		}

	}

}
