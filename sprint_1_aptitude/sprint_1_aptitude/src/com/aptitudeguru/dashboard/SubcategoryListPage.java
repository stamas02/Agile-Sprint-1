package com.aptitudeguru.dashboard;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidhive.dashboard.R;

public class SubcategoryListPage extends Activity {


	int start = 1;
	 final Context context = this;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
	        // Activity was brought to front and not created, 
	        // Thus finishing this will get us to the last viewed activity 
	        finish(); 
	        return; 
	    } 
		setContentView(R.layout.news_feed_layout);

		
		Button btn_home = (Button) findViewById(R.id.btn_home);

	
		Button btn_fav = (Button) findViewById(R.id.btn_fav);

		
		Button btn_score = (Button) findViewById(R.id.btn_score);

		
		Button btn_tutorial = (Button) findViewById(R.id.btn_soundon);

		
		Button btn_about = (Button) findViewById(R.id.btn_about);
	Button btn_help = (Button) findViewById(R.id.btn_help);
		
		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
					Help.class);

				startActivity(i);
			}
		});
		

		
		btn_home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
						AndroidDashboardDesignActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
		});

		
		btn_fav.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), FavPage.class);

				startActivity(i);
			}
		});

		
		btn_score.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), scoremenu.class);
				startActivity(i);
			}
		});

	
		btn_tutorial.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
						Tutorialpage.class);
				startActivity(i);
			}
		});

		
		btn_about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), AboutUs.class);
				startActivity(i);
			}
		});
		
		Bundle bundle = getIntent().getExtras();
		final int test_category = bundle.getInt("test_category");
		
		LinearLayout button_container = (LinearLayout)this.findViewById(R.id.button_container);
		//View button_container = LayoutInflater.from(context).inflate(R.layout.button_container)
		ArrayList<Button> button_subcategorys = new ArrayList<Button>();

	
		String sub_category = "";
		String[] category_names =null;
		if (TABLE_NAMES.QUANTITIVE_TABLE.ordinal() == test_category)
		{	
			sub_category = "q";
			category_names = getResources().getStringArray(R.array.quantitive_test_category_names);
		}
		else if (TABLE_NAMES.TABLE_VL.ordinal() == test_category)
		{	
			sub_category = "v";
			category_names = getResources().getStringArray(R.array.v_test_category_names);
			
		}		
		for (int i = 0; i < category_names.length; i++)
			button_subcategorys.add(createOneButton(category_names[i],sub_category+(i+1)));
		
		
		
		
		
		for(int i = 0; i < button_subcategorys.size(); i++)
		{
			button_container.addView(button_subcategorys.get(i));
						
			button_subcategorys.get(i).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					
							Intent i = new Intent(getApplicationContext(), TestPage.class);
							i.putExtra("sub_categry", (String)view.getTag());
							i.putExtra("test_category", test_category);
							startActivity(i);
							

				}
			});
		}

	}

	
	
	private Button createOneButton(String text, String categoryId)
	{
		Button tmp = new Button(context);
		tmp.setText(text);
		tmp.setTag(categoryId);
		//tmp.setGravity(gravity);
		return tmp;
	
	}
}
