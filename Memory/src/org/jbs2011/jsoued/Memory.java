package org.jbs2011.jsoued;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Memory extends Activity implements OnClickListener{
	
	Game initial = new Game(); 
	ArrayList<String> countries = initial.getCountries(); 
	ArrayList<String> capitals = initial.getCapitals(); 
	HashMap<String, String> matches = initial.getMatches(); 
	
	String present_country = "";
	String past_country = "";
	String present_capital = "";
	
	int country_index = 100;
	int capital_index = 100;
	
	boolean country_button = false;
	boolean capital_button = false;
	
	int fails = 0;
	int to_guess = 12;
	
	ArrayList<String> country_array = Game.shuffle(countries);
    ArrayList<String> capital_array = Game.shuffle(capitals);
	
	private final View [] country_list = new View[12]; //creates list of question buttons
	private final View [] capital_list = new View[12]; // creates list of answer buttons
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        country_list [0] = findViewById(R.id.ctry1);
        country_list [1] = findViewById(R.id.ctry2);
        country_list [2] = findViewById(R.id.ctry3);
        country_list [3] = findViewById(R.id.ctry4);
        country_list [4] = findViewById(R.id.ctry5);
        country_list [5] = findViewById(R.id.ctry6);
        country_list [6] = findViewById(R.id.ctry7);
        country_list [7] = findViewById(R.id.ctry8);
        country_list [8] = findViewById(R.id.ctry9);
        country_list [9] = findViewById(R.id.ctry10);
        country_list [10] = findViewById(R.id.ctry11);
        country_list [11] = findViewById(R.id.ctry12);
        
        capital_list [0] = findViewById(R.id.cap1);
        capital_list [1] = findViewById(R.id.cap2);
        capital_list [2] = findViewById(R.id.cap3);
        capital_list [3] = findViewById(R.id.cap4);
        capital_list [4] = findViewById(R.id.cap5);
        capital_list [5] = findViewById(R.id.cap6);
        capital_list [6] = findViewById(R.id.cap7);
        capital_list [7] = findViewById(R.id.cap8);
        capital_list [8] = findViewById(R.id.cap9);
        capital_list [9] = findViewById(R.id.cap10);
        capital_list [10] = findViewById(R.id.cap11);
        capital_list [11] = findViewById(R.id.cap12);
        
        for(int i = 0; i < 12; i++){	
        	makeCountryView(i);
        }
        
        for(int j = 0; j < 12; j++){	
        	makeCapitalView(j);
        }
        
        for(int k = 0; k < 12; k++){
			((Button) country_list[k]).setText("");
			((Button) capital_list[k]).setText("");
		}
        
        for(int l = 0; l < 12; l++){
			
        	if (country_array.get(l).equals("empty")){
        		country_list[l].setVisibility(View.INVISIBLE);
			}
        	
			if (capital_array.get(l).equals("empty")){
				capital_list[l].setVisibility(View.INVISIBLE);
			}
		}
    }

    
	public void onClick(View v) {
		switch(v.getId()) {	
		//Countries:
		case R.id.ctry1:
			countryButtonCase(0);
			break;
		case R.id.ctry2:
			countryButtonCase(1);
			break;
		case R.id.ctry3:
			countryButtonCase(2);
			break;
		case R.id.ctry4:
			countryButtonCase(3);
			break;
		case R.id.ctry5:
			countryButtonCase(4);
			break;
		case R.id.ctry6:
			countryButtonCase(5);
			break;
		case R.id.ctry7:
			countryButtonCase(6);
			break;
		case R.id.ctry8:
			countryButtonCase(7);
			break;
		case R.id.ctry9:
			countryButtonCase(8);
			break;
		case R.id.ctry10:
			countryButtonCase(9);
			break;
		case R.id.ctry11:
			countryButtonCase(10);
			break;
		case R.id.ctry12:
			countryButtonCase(11);
			break;
		
		//Capitals:	
		case R.id.cap1:
			capitalButtonCase(0);
			break;
		case R.id.cap2:
			capitalButtonCase(1);
			break;
		case R.id.cap3:
			capitalButtonCase(2);
			break;
		case R.id.cap4:
			capitalButtonCase(3);
			break;
		case R.id.cap5:
			capitalButtonCase(4);
			break;
		case R.id.cap6:
			capitalButtonCase(5);
			break;
		case R.id.cap7:
			capitalButtonCase(6);
			break;
		case R.id.cap8:
			capitalButtonCase(7);
			break;
		case R.id.cap9:
			capitalButtonCase(8);
			break;
		case R.id.cap10:
			capitalButtonCase(9);
			break;
		case R.id.cap11:
			capitalButtonCase(10);
			break;
		case R.id.cap12:
			capitalButtonCase(11);
			break;
		}
		
		fails++;

		if(!past_country.equals(present_country) && matches.get(present_country).equals(present_capital)){
			
			country_array.remove(country_index);
			country_array.add(country_index,"empty");
			
			capital_array.remove(capital_index);
			capital_array.add(capital_index,"empty");
			
			Toast.makeText(getBaseContext(), "GOOD JOB!", Toast.LENGTH_SHORT).show();
			
			past_country = present_country;
			to_guess--;
			
			country_button = false;
			capital_button = false;
			
			SoundEffects.play(this, R.raw.ring);
			
			fails = 0;
		}
		
		for(int i = 0; i < 12; i++){
			if (country_array.get(i).equals("empty")){
				country_list[i].setVisibility(View.INVISIBLE);
			}
			if (capital_array.get(i).equals("empty")){
				capital_list[i].setVisibility(View.INVISIBLE);
			}
		}
		
		for(int i = 0; i < 12; i++){
			((Button) country_list[i]).setText("");
			((Button) capital_list[i]).setText("");
		}
		
		
		if(country_button){
			((Button) country_list[country_index]).setText(country_array.get(country_index));
		}
		
		if(capital_button){
			((Button) capital_list[capital_index]).setText(capital_array.get(capital_index));
		}

		if(to_guess == 0){
			Toast.makeText(getBaseContext(), "YOU WON!!!", Toast.LENGTH_LONG).show();
			finish();
		}

		if(fails == 2){
			fails = 0;
			SoundEffects.play(this, R.raw.laser);
		}
		
	}
	
	private void countryButtonCase(int x){
		if(!country_button){
			country_button = true;
			capital_button = false;
			present_country = country_array.get(x);
			country_index = x;
			((Button) country_list[x]).setText(country_array.get(x));
		}
	}
	
	private void capitalButtonCase(int x){
		if(!capital_button){
			capital_button = true;
			country_button = false;
			present_capital = capital_array.get(x);
			capital_index = x;
		}
	}
	
	private void makeCountryView(int x){
	    country_list [x].setOnClickListener(this);
	}
	
	private void makeCapitalView(int x){
	    capital_list [x].setOnClickListener(this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
	    BackgroundSound.play(this, R.raw.song);
	}


	@Override
	public void onPause() {
		super.onPause();
	    BackgroundSound.stop(this);
	    SoundEffects.stop(this);
	}
}