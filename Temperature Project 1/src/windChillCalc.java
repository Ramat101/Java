import javax.swing.*;
import java.text.DecimalFormat;

public class windChillCalc{
   
   public static void main (String[] args){
      
      String temp, wspeed;
      Float tempF, wspeedF, wchill;
      
      //Make sure that your floats will be rounded to an appropriate amount
      DecimalFormat df = new DecimalFormat("#.0");
      
      //This line asks the user for input by popping out a single window with a text input space
      temp = JOptionPane.showInputDialog(null, "What is your temperature?");
      wspeed = JOptionPane.showInputDialog(null, "What is your wind speed?");

     //convert the users input of temperature and wind speed from Strings into Floats 
      tempF = Float.parseFloat(temp);
      wspeedF = Float.parseFloat(wspeed);

     //calculate wind speed- make sure that all numbers are of float data type; the outcome of the Math power function must be converted from a double to a float	
      wchill = 35.74f + (0.6215f * tempF) - (35.75f * (float)(Math.pow(wspeedF, 0.16))) + (0.4275f * tempF * (float)(Math.pow(wspeedF, 0.16)));
      	        
     // Output using a JOptionPane window
      JOptionPane.showMessageDialog(null, "Your wind chill is " + df.format(wchill) + " degrees.");
      
   }
}   