import java.util.StringTokenizer;

public class Project1 {

   public static void main(String[] args) {
      String line;
      int size = -1;
      TextFileInput count = new TextFileInput (args[0]);
      TextFileInput read = new TextFileInput(args[0]); //will be used for starting from the beginning of a text file which was already read
		
      //find size of the String array
      line = count.readLine();
      while(line != null){
         size++;
         line = count.readLine();
      }
		
      //create arrays that can hold as many data lines as the file contains
      Temperature[] temp = new Temperature[size];
      float[] windSpeed = new float[size];	
		
      //fill the arrays with the data from the opened file, and convert the string information into floats
      line = read.readLine();
      StringTokenizer tokens = new StringTokenizer(line, ",");
      for(int i=0; i<size; i++){
         (temp[i]).setTemperature(Float.parseFloat(tokens.nextToken()));
         windSpeed[i] = Float.parseFloat(tokens.nextToken());
         line = read.readLine();
         tokens = new StringTokenizer(line, ","); //reset what we're tokening to the next line in the file
      }
		
      //now we have all the arguments we need to represent our info using a TemperatureGui
      TemperatureGui display = new TemperatureGui("Temperature and Wind Chill", 200, 500); //creates a TemperatureGui and instantiates it
      display.printtoJFrame(temp, windSpeed);
			   
   }//main
}//Project1
