import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Game {
	
	public static void main(String args[]){
		
		//Declare
		ArrayList<String> countries = new ArrayList<String>();
		ArrayList<String> capitals = new ArrayList<String>();
		HashMap<String,String> match = new HashMap<String,String>();
		
		//Fill countries
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
		
		//Fill capitals
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
		
		//Mapping
		for(int i = 0; i < countries.size(); i++){
			match.put(countries.get(i),capitals.get(i));
		}
		
		Collections.shuffle(countries);
		Collections.shuffle(capitals);
		
		int score = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("There are 4 rows of 3 cards. Cards are enumerated from 0 - 11 (from left to right through the rows).");
		
		while(score < 12){
			
			System.out.println("Would you like to see the current status of the board?");
			
			String answer = input.next();
			
			if (answer.equals("yes")){
				
				printBoard(countries, capitals);
			}
			
			System.out.println("Please enter the number of card you want to open from the countries deck.");
			
			int a = input.nextInt();
			
			System.out.println(countries.get(a));
			
			System.out.println("Please enter the number of card you want to open from the capitals deck.");
			
			int b = input.nextInt();
			
			System.out.println(capitals.get(b));
			
			String test = match.get(countries.get(a));
			
			if (test.equals(capitals.get(b))){
				
				System.out.println("Good Job!");
				
				countries.set(a, "empty");
				capitals.set(b, "empty");
				
				score++;

			} else {
				
				System.out.println("Wrong! Try again!");
				
			}
			
			System.out.println("Guessed: " + score + ", " + "To go:" + (12 - score));	
			
		}
		
		System.out.println("You Won! End of Game.");	
	}
	
	//I know I could've done this method shorter with for loops but honestly it is easier this way and, therefore, it takes less time.
	public static void printBoard(ArrayList<String> x, ArrayList<String> y){
		
		System.out.println("Countries:");
		System.out.println("--- " + printCurrent(0, x) + " -- " + printCurrent(1, x) + " -- " + printCurrent(2, x) + " ---");
		System.out.println("--- " + printCurrent(3, x) + " -- " + printCurrent(4, x) + " -- " + printCurrent(5, x) + " ---");
		System.out.println("--- " + printCurrent(6, x) + " -- " + printCurrent(7, x) + " -- " + printCurrent(8, x) + " ---");
		System.out.println("--- " + printCurrent(9, x) + " -- " + printCurrent(10, x) + " -- " + printCurrent(11, x) + " ---");
		
		System.out.println("Capitals:");
		System.out.println("--- " + printCurrent(0, y) + " -- " + printCurrent(1, y) + " -- " + printCurrent(2, y) + " ---");
		System.out.println("--- " + printCurrent(3, y) + " -- " + printCurrent(4, y) + " -- " + printCurrent(5, y) + " ---");
		System.out.println("--- " + printCurrent(6, y) + " -- " + printCurrent(7, y) + " -- " + printCurrent(8, y) + " ---");
		System.out.println("--- " + printCurrent(9, y) + " -- " + printCurrent(10, y) + " -- " + printCurrent(11, y) + " ---");
		
		
	}
	
	public static String printCurrent(int a, ArrayList<String> b){
		
		if (b.get(a).equals("empty")){
			
			return "Empty";
			
		} else {
			
			return "Card";
		}
	}	
}
