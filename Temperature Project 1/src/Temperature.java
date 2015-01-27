import java.text.DecimalFormat; //will allow us to format our floats

/**
 * Represents temperature in celsius.
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
    * @param degrees the float that will represent the 
    * celsius degrees of Temperature
    */
   public Temperature(float degrees){
      celTemp = degrees;
   } 
   
   /**
    * set the celsius temperature
    * @param degrees the float that will be set as the new 
    * celsius temperature of Temperature 
    */
   public void setTemperature(Float degrees){
      celTemp = degrees;	   
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
    *  fahrenheit temperatureand 
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
	   DecimalFormat df = new DecimalFormat("#.0"); //Ensures that the floats will be rounded off to an appropriate amount
	   String format = ""+(df.format(this.celTemp));
	   return format;
   }
  
}//Temperature Class

