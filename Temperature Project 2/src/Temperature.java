import java.text.DecimalFormat; //will allow us to format our floats
import java.util.regex.*; //allows regex 

/**
 * Represents temperature in celsius in format ###.##
 * Can perform basic methods such as converting to Fahrenheit,
 * and calculating wind chill.
 * @author Tamar
 *
 */

public class Temperature {
	
	/** float representing temperature in celsius  */ 
   private float celTemp;  
     
   /** default constructor */
   public Temperature(){
      celTemp = 0.0f;	   
   }
   
   /**
    * instantiating constructor
    * @param degreesF the float that will represent the 
    * celsius degrees of Temperature
    * @throws IllegalTemperatureException if the constructor can't create a valid Temperature object
    */
   public Temperature(float degreesF){
      //Only properly formatted temperatures can be created- ###.##
	  String degreesS = String.valueOf(degreesF);
	  if(isValidTemp(degreesS))
	     celTemp = degreesF;
	  else
		  throw new IllegalArgumentTemperatureException("Not valid for temperature: ");
   }
   
   /**
    * instantiating constructor
    * @param String called degrees that will represent the 
    * celsius degrees of Temperature if the String represents a number of valid temperature format
    * @throws IllegalArgumentTemperatureException if the constructor can't create a valid Temperature object
    */
   public Temperature(String degrees){
      if(isValidTemp(degrees)) 
         celTemp = Float.parseFloat(degrees);	
      else
    	  throw new IllegalArgumentTemperatureException("Not valid for temperature: ");    
   }
   
   /**
    * set the celsius temperature
    * @param degrees the float that will be set as the new 
    * celsius temperature of Temperature 
    * @throws IllegalTemperatureException if the constructor can't create a valid Temperature object
    */
   public void setTemperature(Float degreesF){
	  //Only propely formatted temperatures can be set 
	  String degreesS = String.valueOf(degreesF);
      if(isValidTemp(degreesS))
	     celTemp = degreesF;
	  else
		  throw new IllegalArgumentTemperatureException("Not valid for temperature: ");	   
   }
   
   /** 
    * @return a float to the public that holds the value of
    *  the celsius temperature of Temperature
    */
   public float getTemperature(){
	   return celTemp;
   }
   
   /**
    * converts the celsius temperature of the object to it's
    *  fahrenheit temperature and 
    * @return float fahrenheit value Temperature's celsius temperature
    */
   public float getFahrenheitTemperature(){
	   float fahrenheit = (celTemp * (9f/5)) + 32f;
	   return fahrenheit;
   }
   
   /**
    * when given the current wind speed from 
    * @param wspeedF, this method 
    * @return the wind chill value that the wind speed and current temperature cause
    * */
   public float windChill(float wspeedF){
	  double wspeedD = (double)wspeedF;
      float	wchill = 35.74f + (0.6215f * this.celTemp) - (float)(35.75f * (Math.pow(wspeedD, 0.16))) + (0.4275f * this.celTemp * (float)(Math.pow(wspeedD, 0.16)));
      return wchill;   
   }
   
   /**
    * determines whether or not the current object and its 
    * @param object are equal. 
    * @return true if the parameter object is not empty, it's of the same class 
    * as the current object, and their temps are equal
    */
   public boolean equals(Object other){
      if ((other != null) && (getClass() == other.getClass()) && (celTemp == ((Temperature)other).getTemperature()))
         return (true);	  
      return (false);         
   }
   
   /**
    * @return a numerical result that evaluates whether the object is equal to, greater than, or less than the celTemp of its 
    * @param other. 0 is equal to, larger than 0 is greater than, and less than 0 is less than
    *  */
   public int compareTo(Temperature other){
      if(celTemp == other.getTemperature())
    	 return 0;
      else if (celTemp > other.getTemperature())
         return 1;
      else 
    	 return -1;
	}
   
   /**
    *  formats celTemp and converts it into a String
    * @return a string representing
    */
   public String toString(){
	   DecimalFormat df = new DecimalFormat("##0.00"); //Ensures that the floats will be rounded off to an appropriate amount
	   String format = ""+(df.format(this.celTemp));
	   return format;
   }
   
   /**
    * determines whether the info in
    * @param the string degrees can is in the proper format 
    * to be converted into a temperature
    * @return boolean value yes it can be converted into  temp properly or no
    * it won't be able to be converted into a temperature properly
    */
   public static boolean isValidTemp(String degrees){
      Pattern pa; 
	  Matcher ma;
	  String TEMP_PATTERNA ="^[+-]?\\d{0,3}\\.?\\d{0,2}$"; //###.##
	  pa = Pattern.compile(TEMP_PATTERNA); //establish the pattern we want
	  ma = pa.matcher(degrees); //determines whether parameter degrees matches the pattern we want
	  if (ma.matches())//if the pattern is a match then return true
	     return true;
	  return false;
   }
	 
  /* public static boolean isValidTemp(Float degrees) {
      String trial = String.valueOf(degrees);
	  int count, count2;
		  
	  if(!(trial.contains(".")) && trial.length() <4) //###
	     return true;
	  
	  count = trial.indexOf("."); //what number character is '.'
	  if(count > 3){ //if count > ###
	     System.out.println("Incorrect Temperature format: " +trial);
		 return false;
	  }
		  
	  count2 = trial.codePointCount(count, trial.length()); //how many character are between '.' and the end of the string?
	  if( count2 > 3){ //if count2 > .## 
	     System.out.println("Incorrect Temperature format: "+trial);
		 return false;
	  }	  
	      
	  return true;
   
   }//isValidTemp
   */
   
}//Temperature Class