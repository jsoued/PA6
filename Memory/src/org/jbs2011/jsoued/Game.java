package org.jbs2011.jsoued;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game {
	
	private ArrayList<String> countries = new ArrayList<String>();
	private ArrayList<String> capitals = new ArrayList<String>();
	private HashMap<String,String> match = new HashMap<String,String>();
	
	public Game(){
		
		this.countries = setCountries();
		this.capitals = setCapitals();
		this.match = setMatches();
	}
	
	public ArrayList<String> setCountries(){
		
		countries.add("Argentina");
		countries.add("Colombia");
		countries.add("Uruguay");
		countries.add("USA");
		countries.add("Australia");
		countries.add("China");
		countries.add("Japan");
		countries.add("Italy");
		countries.add("France");
		countries.add("Rusia");
		countries.add("Spain");
		countries.add("England");
		
		return countries;	
	}
	
	public ArrayList<String> setCapitals(){
		
		capitals.add("Buenos Aires");
		capitals.add("Bogota");
		capitals.add("Montevideo");
		capitals.add("Washingtong");
		capitals.add("Sidney");
		capitals.add("Beijing");
		capitals.add("Tokyo");
		capitals.add("Rome");
		capitals.add("Paris");
		capitals.add("Moscow");
		capitals.add("Madrid");
		capitals.add("London");

		return capitals;	
	}
	
	public HashMap<String,String> setMatches(){
		
		for(int i = 0; i < countries.size(); i++){
			match.put(countries.get(i),capitals.get(i));
		}
		
		return match;
	}
	
	public ArrayList<String> getCountries(){
		return this.countries;
	}

	public ArrayList<String> getCapitals(){
		return this.capitals;
	}

	public HashMap<String,String> getMatches(){
		return this.match;
	}
	
	public static ArrayList<String> shuffle(ArrayList<String> array){
		Collections.shuffle(array);
		return array;
	}
	
}
