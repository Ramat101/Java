import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//places temperature and windspeed onto a gui and calculates the resulting windchill 
public class TemperatureCalc {
	public static void main(String[] args){
	  String line; 
	  Temperature[] temp = new Temperature[8];
	  float[] windSpeed = new float[8];
	  TemperatureGui gui = new TemperatureGui("TemperatureGui", 500, 300);
	  int i = 0;
	  try {
		Scanner inFile = new Scanner(new FileReader(args[0]));
		while(inFile.hasNext()){
		   line = inFile.next();
		   StringTokenizer tokens = new StringTokenizer(line, ",");
		   temp[i] = new Temperature( Float.parseFloat(tokens.nextToken()));
		   windSpeed[i++] = Float.parseFloat(tokens.nextToken());
		}
		gui.printtoJFrame(temp, windSpeed);
	  }//try 
	  catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	}
	
}
