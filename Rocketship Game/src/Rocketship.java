import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rocketship {
	private String name;
	private ArrayList<String> location;
	
	//default constructor 
	public Rocketship(){
		name = null; 
		location = null; 
	}
	
	//name constructor
	public Rocketship(String title){
		name = title; 
		location = null;
	}
	
	//location constructor
	public Rocketship( ArrayList<String> placement){
		name = null;
		location = placement;
	}
	
	//name and location constructor
	public Rocketship(String title, ArrayList<String> placement){
		name = title;
		setCoordinates(placement);
	}
	
	//set name
	public void setName(String title){
		name = title;
	}
	
	//get name
	public String getName(){
		return name;
	}
	
	public ArrayList<String> getLocation(){
		return location;
	}
	
	 public static boolean isValidCoordinate(String input){
		 String check = input.toUpperCase();
		 String INPUT_PATTERN = "[A-Z]{1}[0-9]{1}";
	     Pattern p = Pattern.compile(INPUT_PATTERN); //define the regular expression using Pattern
		 Matcher m = p.matcher(check); // Creates a Matcher object that searches the String for anything that matches the REGEX
		 if( m.find() ){
		 	// System.out.println( m.group().trim());
		 	return true;
		 }
		 return false;
	}//isValidCoordinate
	 
	//set location
	public void setCoordinates(ArrayList<String> placement){
			//make sure the ArrayList contains 3 coordinate points
			int size = placement.size(); //find out how any elements are in the ArrayList
			if (size != 3){ //make sure there is exactly 3 elements
				System.out.println("A rocketship takes up 3 coordinates. Try again.");
				return;
			}
			//make sure the coordinate points are distinct
			for(int i = 0; i<size; i++){
				for(int j= (i + 1); j<size; j++){
					String check = placement.get(i);
					String check2 = placement.get(j);
					if(isValidCoordinate(check) && isValidCoordinate(check2)){
						if(check.equals(check2)){
							System.out.println("Can't use the same coordinate twice. Try again.");
							return;
						}//if
					}//if
				}//for
			}//for
			location = placement;
		}//setCoordinates
	
		
    //set up random coordinates
	public void setRandomCoordinates(){
	   ArrayList<String> coordinates = new ArrayList<String>();
	   ArrayList<char[]> randomChar = new ArrayList<char[]>();
	   int[] randomNum = new int[3];
	   int[] numericCharValue = new int[3];
	   
	   boolean baseCoordinateGood = false;	
	   int direction;
	 
	   while(!baseCoordinateGood){
	      baseCoordinateGood = true;
		  randomNum[0] = (int)(Math.random() * 7); //get a random number and place in randomNum[] array
		  numericCharValue[0] = ((int)(Math.random() * 7)+65); //get the numericValue of your random char
		  randomChar.add(Character.toChars(numericCharValue[0])); //convert numericCharValue into a char and add it to your randomChar<> ArrayList
		  //if this coordinate doesn't work as a starting location coordinate then get a new coordinate
		  if(randomNum[0]>4 && numericCharValue[0]>69){
		     baseCoordinateGood  = false;
		     continue;
		  }//if
		  coordinates.add(String.valueOf(randomChar.get(0)) + Integer.toString(randomNum[0])); //add the combined random char and random number into one String coordinate
		  //System.out.println("Base coordinate: " + coordinates.get(0));
				   
		  //if the base case is good then add the rest of the rocketship's coordinates either down or to the right of base location
		  for(int i=1; i<3; i++){			   
			  //if down is not an option then you can only place coordinates right of baseCoordinate location
			  if(randomNum[0]>4){
				  randomChar.add(Character.toChars(numericCharValue[0]+i)); //add the rest of the rocketships coordinates horizontally
				  coordinates.add(String.valueOf(randomChar.get(i)) + Integer.toString(randomNum[0])); //only the columns of the rocketship coordinates change, not the row
			  }//if
					  
			  //if right is not an option then you can only place coordinates down of base location
			  else if (numericCharValue[0]> 69){
				  randomNum[i] = randomNum[0]+i; //add the rest of the rocketship coordinates vertically
				  coordinates.add(String.valueOf(randomChar.get(0)) + (Integer.toString(randomNum[i]))); //only the rows of the rocketship coordinates change, not the columns
			  }//else if
					   
			  //else you can place the rest of the rocketship either in the horizontal or vertical direction
			  else{
				  direction = (int)(Math.random() * 2);
						  
				  //if 0 then add rest of rocketship horizontally
				  if(direction == 0){
					  for(int j = 1; j<3; j++){
						  randomChar.add(Character.toChars(numericCharValue[0]+j)); //add the rest of the rocketships coordinates horizontally
						  coordinates.add(String.valueOf((randomChar.get(j))) + (Integer.toString(randomNum[0]))); //only the columns of the rocketship coordinates change, not the row
					  }//for
					  break;
				  }//if
						   
			 //if it's 1 then add rocketship vertically
			 else{
			    for(int j = 1; j<3; j++){
				   randomNum[j] = randomNum[0]+j; //add the rest of the rocketship coordinates vertically
				   coordinates.add(String.valueOf(randomChar.get(0)) + Integer.toString(randomNum[j])); //only the rows of the rocketship coordinates change, not the columns
				}//for
			    break;	   
			}//else
		   }//else
	     }//for
      }//while
	  location = coordinates;
    }//setRandomCoordinates
	
	 //set up Rocketship completely
	 public void setUpRocketship(String title){
		  name = title;
		  setRandomCoordinates();
	 }//setUpRocketship	
		
}//rocketship
