import java.util.*;
import java.util.regex.*;
import java.lang.Character;
import java.io.*;
import java.nio.charset.Charset;

public class Game {
	public static int guessNumb = 0; //global number that keeps track of how many guesses throughout the game
	// 1) creates three rocketships, 2) sets up their coordinates, 3) gives over the instructions
	public static ArrayList<Rocketship> setUpGame(){
		//create an ArrayList of Rocketships and sets up their coordinates
		ArrayList<Rocketship> ships = new ArrayList<Rocketship>();
		
		//need to ensure that no overlapping coordinates are randomly generated
		ArrayList<String> check1, check2;
		String check3, check4;
		boolean beginAgain = false; //true if we have to re-set the coordinates and start the check over due to overlapping coordinates
		
		for(int i=0; i<3; i++){
		   ships.add(new Rocketship()); //add a new rocketship to the list collection of rocketships
		   ships.get(i).setRandomCoordinates(); //try to add coordinates to the new ship
			   for(int j = 0; j<i; j++){
				   beginAgain = false; 
				   check1 = ships.get(i).getLocation(); //get all the locations of the newly added ship
				   check2 = ships.get(j).getLocation(); //itterate through all the locations of all other ships in the ship list
				   for(int k = 0; k<3; k++){
					   check3 = check1.get(k); //run through all the coordinates in the location of the new ship
					   for(int l = 0; l<3; l++){
						   check4 = check2.get(l); //compare to all the coordinates in all other ships
						   if((check3.equals(check4))){ //overlapping coordinates
							   ships.get(i).setRandomCoordinates(); //re-set the coordinates
							   j = 0; k = 0; l = 0; //need to double check all the coordinates again
							   beginAgain = true;
							   break;
						   }//if
					   }//for(l)
					   if(beginAgain)
						   break; //go back to the beginning 
				   }//for (k)
				   if(beginAgain)
					   break;
			   }//for(j)
		}//for(i)
		
		//print coordinate info - ***just during development
	    for(int i = 0; i<3; i++){
		   System.out.println("Location of ship " +i+ " is: " + ships.get(i).getLocation());
	    }//for
	    System.out.println(" ");
	    
	    //print instructions
	    System.out.println("Welcome Cadet. This is mission control checking in. We've got some bad news.");
	    System.out.println("The enemy rocketships are afoot. We need you to locate them, and shoot them down.");
	    System.out.println("Choose a spot on the coordinate system to aim your rockets. A-G and 0-6. Good luck! We're counting on you.");
		
	    return ships;
	}
	
	//method for getting user input
	public static String getUserInput(String prompt){
		char c1;
		int c2;
		boolean again = true;
		String coordinate = "";
		System.out.println(prompt + " ");
		while(again){
			try{
				Scanner in = new Scanner(System.in);
				c1 = (char) System.in.read();
				c2 = in.nextInt();
				coordinate = c1+(Integer.toString(c2));
			}//try
			catch (Exception e){
				System.out.println("Out of bounds coordinate. Try again.");
				continue;
				//e.printStackTrace();
			}//catch
			if(isValidInput(coordinate.toUpperCase()))
				return coordinate.toUpperCase();
			else
				System.out.println("Out of bounds coordinate. Try again.");
		}//while
		return null;
	}//getUserInput

	 public static boolean isValidInput(String input){
		 String INPUT_PATTERN = "[A-G]{1}[0-6]{1}";
	     Pattern p = Pattern.compile(INPUT_PATTERN); //define the regular expression using Pattern
		 Matcher m = p.matcher(input); // Creates a Matcher object that searches the String for anything that matches the REGEX
		 if( m.find() ){
		 	  // System.out.println( m.group().trim());
		 	   return true;
		 }
		 return false;
	}//isValid
		
	//check user input
	public static void checkUserInput(String attack, ArrayList<Rocketship> ships){
		if(isValidInput(attack)){
			//examine each rocketship in the ArrayList of rocketships
			guessNumb++;
			for(Rocketship test : ships){
				ArrayList<String> location = test.getLocation();
				//examine each location coordinate in the individual rocketship
				for(String coordinate : location){
					if(coordinate.equals(attack)){
						System.out.println("Hit!");
						location.remove((location.indexOf(coordinate)));
						if(location.isEmpty()){
						   System.out.println("Congratulations you made a kill!");							}//if
					    return;	
					 }//if
				}//for
			}//for
			System.out.println("Miss!");
			return;
		}//if
	}//checkUserInput
		
	//play the game
	public static void playGame(ArrayList<Rocketship> ships){
		boolean play = true;
		while(play){ //as long as there are still parts of a rocketship not destroyed yet, continue the game
			for(Rocketship ship : ships){
				if(!(ship.getLocation().isEmpty())){
				   play = true;
				   break; //if even one location spot is found existing, go on to play
				}	
			    else{
				   play = false;
			    }
			}//for
			if(!play) break; //if no spots left, break out of the while loop
			String attack = getUserInput("\nWhere would you like to attack? ");
			checkUserInput(attack, ships);
		}//while

		System.out.println("\nCogratulations! You've destroyed all enemy rocketship in "+ guessNumb + " attacks.");
		System.out.println("Mission Control looks forward to your return.");
		
		return; 
	}//playGame			
}//Game

