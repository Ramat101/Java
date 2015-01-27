import javax.swing.*; //imports JFrame library
import java.text.DecimalFormat;
import java.awt.*;


public class TemperatureGui extends JFrame {//creates new class called TemperatureGui that inherits everything that the parent class JFrame contains
   String title;
   int height, width;
   float temperature, windspeed, windchill;
   DecimalFormat df = new DecimalFormat("#.#"); //will format the floats
	
   public TemperatureGui (String title, int height, int width){
      this.equals(title);
      this.height = height;
      this.width = width;
      this.setTitle(title);
      this.setSize(width, height);
      this.setLocation(100,100);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }//Constructor

   //representing data in the JFrame
   public void printtoJFrame(Temperature[] tempList, float[] windSpeedList){
       int size = tempList.length;
	   Float[] windChillList = new Float[size];
	  
      //preparing the components of the JFrame
      this.setLayout(new GridLayout(1,3)); //causes a JFrame with 1 row and 3 columns
	  Container myContentPane = this.getContentPane(); //attaches the container to the TemperatureGui
      //text area for all three data variable we will represent
	  TextArea temperatureText = new TextArea(); 
      TextArea windSpeedText = new TextArea();
      TextArea windChillText = new TextArea();
      //each text area gets its own column in the JFrame
      myContentPane.add(temperatureText);
      myContentPane.add(windSpeedText);
      myContentPane.add(windChillText);
   
      //fill up windChillList
      for(int i=0; i<size; i++){ 
         windChillList[i] = (tempList[i]).windChill(windSpeedList[i]);//windChill(getFahrenheitTemperature(tempList[i]), getFahrenheitTemperature(windSpeedList[i])); //fill up windChillList with the calculated wind chill using its parallel temperature and wind speed values
      }
      
      //fill up the text areas
      for(int i=0; i<size; i++){
         temperatureText.append(tempList[i] + "C (" + (tempList[i]).getFahrenheitTemperature() +"F) \n");
         windSpeedText.append(df.format(windSpeedList[i])+" MPH \n");
         if(((tempList[i]).getFahrenheitTemperature())>= 50.0f)
            windChillText.append("Temperature is too hot for wind chill \n");
         else if ((windSpeedList[i])<3.0f)
        	 windChillText.append("Wind speed is too low for wind chill \n");
         else
        	 windChillText.append((windChillList[i]) + " F\n");
            
      }//for
      
      //make sure everyone can see the TemperatureGui
      this.setVisible(true);
   }//printSSNtoJFrame method

}//TemperatureGui
