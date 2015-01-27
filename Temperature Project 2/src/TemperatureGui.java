import javax.swing.*; //imports JFrame library
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class TemperatureGui extends JFrame {//creates new class called TemperatureGui that inherits everything that the parent class JFrame contains
   String title;
   int height, width;
   float temperature, windspeed, windchill;
   DecimalFormat df = new DecimalFormat("#.#"); //will format the floats
   JMenuBar menuBar;
   JMenuItem item;
   static TextArea temperatureText;
   static TextArea linkListText;
   static Temperature[] temp = new Temperature[100];
   static Temperature[] temp2 = new Temperature[100];
   static TList linkTemp = new TList();
   Container myContentPane = new Container();
   static int lengthFilled = 0;
   
   public TemperatureGui (String title, int height, int width){
      this.equals(title);
      this.height = height;
      this.width = width;
      createMenu();//creates everything you need for a drop down menu
      initialize(); 
   }//constructor
   
   void initialize(){
      this.setTitle(title);
      this.setSize(width, height);
      this.setLocation(100,100);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }//initialize
   
   private void createMenu(){
      menuBar = new JMenuBar(); //creates a menu bar
      JMenu fileMenu = new JMenu("File"); //creates a tab on the menu bar called "File"
      JMenu editMenu = new JMenu ("Edit");//creates a tab for the menu bar called "Edit"
      FileMenuHandler fmh = new FileMenuHandler(this); //creates an Event Handler for this JFrame
      EditMenuHandler emh = new EditMenuHandler(this);
      item = new JMenuItem("Open"); //creates a new item for the "File" menu labeled "Open"
      item.addActionListener(fmh); //registers Event Handler fmh to this item, to listen in case an even occurs to this item
      fileMenu.add(item); //adds item "Open" to the fileMenu (Labeled "File")
      fileMenu.addSeparator(); //creates a dividing line between the first item on the fileMenu and the next item
      item = new JMenuItem("Quit"); //creates a new item labeled "Quit"
      item.addActionListener(fmh); //registers event handler fmh to the item labled "Quit" in case and event occurs to item "Quit"
      fileMenu.add(item); //attaches the item labeled "Quit" to the fileMenu labeled "File"
      item = new JMenuItem("Add");//attaches the item labeled "Add" to the fileMenu labeled "Edit"
      item.addActionListener(emh);//registers event handler emh to the item labled "Add" in case and event occurs to item "Add"
      editMenu.add(item);
      menuBar.add(fileMenu);//attaches the assembled fileMenu to the menuBar
      menuBar.add(editMenu);//attaches the assembled editMenu to the menuBar
      setJMenuBar(menuBar); //adds the assembled menuBar to the JFrame
   }
   
   //this class defines the actionPerformed method from the ActionListener interface
   public class FileMenuHandler implements ActionListener{
      JFrame jframe;
	  
      //constructer for the FileMenuHandler- takes in a JFrame
	  public FileMenuHandler (JFrame jf){
	     jframe = jf;
	  }
	  //method in the FileMenuHandler class which causes it to implement the ActionListener interface
	  public void actionPerformed(ActionEvent event){
	     String menuName = event.getActionCommand(); //menuName is set to label where the event took place
		 if (menuName.equals("Open")) //if the event happened at the label "Open"
		    openFile();
		 else if (menuName.equals("Quit"))//if the event occured at the label "Quit"
		    System.exit(0);
      }//actionPerformed
   
      //opens a file
      private void openFile(){
	     int status;
	     JFileChooser chooser = new JFileChooser(); //object which can be used to select a file
	     status = chooser.showOpenDialog(null);
	     readSource(chooser.getSelectedFile()); //read the selected file
      }//openFile	 
   
      //reads the file
      private void readSource(File chosenFile){
	     String chosenFileName = chosenFile.getName();	      
	     TextFileInput inFile = new TextFileInput(chosenFileName); //make a TextFileInput out of the selected FileName
	     String line = inFile.readLine();
		 while(line != null){
		 //see if any exception comes up because of this statement
		    try{
	           temp[lengthFilled] = new Temperature(Float.parseFloat(line)); //fill array
	           temp2[lengthFilled] = new Temperature(Float.parseFloat(line)); //fill array
		       linkTemp.ascendingInsert((temp[lengthFilled])); //add to linkTemp in ascending order
		       lengthFilled++;
		    }              
		    	     
	        //was a number read from the file?
		    catch(NumberFormatException nfe){
	           System.out.println("Not valid for temperature: "+line);
		    }
		     
		    //was a valid temperature saved into the temperature array?
		    catch (IllegalArgumentTemperatureException ite){
		       System.out.println((ite.getMessage())+" "+line);
		    }
		     
	        //is there still space in the temp array?	   
		    catch (IndexOutOfBoundsException ioob){
		       System.out.println(ioob.getMessage()+"  "+line);
		    }
		     
		    //did any other problems occur?
		    catch(Exception e){
		       System.out.println("Not valid for temperature: "+line);
		     }
		     
		    //once we know that the temp array is filled properly, continue with the program
	        finally{
		       line = inFile.readLine();
	        }    
	     }//while
		  
		 Selection.selectionSort(temp2, lengthFilled);
		 
		//make temperature gui out of the new file.
		 printtoGui(temp2, linkTemp);
		 
      }
   }//readSource   
        
   //representing data in the JFrame
   public void printtoGui(Temperature[] tempList, TList linkTempList){
      int size = tempList.length;
   
      //preparing the components of the JFrame
      this.setLayout(new GridLayout(1,2)); //causes a JFrame with 1 row and 2 columns
	  Container myContentPane = this.getContentPane(); //attaches the container to the TemperatureGui
      
	  //text areas for the data variable we will represent
	  TextArea temperatureText = new TextArea(); 
      TextArea linkListText = new TextArea();
   
      //each text area gets its own column in the JFrame
      myContentPane.add(temperatureText);
      myContentPane.add(linkListText);
      
      //fill up the text areas
      for(int i=0; i<size; i++)
         if(tempList[i] != null) 
            temperatureText.append(tempList[i] + "C \n");
      linkListText.append(linkTempList.toString());               	   
      
      //make sure everyone can see the TemperatureGui
      this.setVisible(true);     
      
   }//printSSNtoJFrame method
   
   public class EditMenuHandler implements ActionListener{
   	  JFrame jframe;
   	   
   	  //constructor of EditMenuHandler class
   	  public EditMenuHandler (JFrame jf){
   	     jframe = jf;
   	  }
   	  
   	  //response to events that happen to items being listened to by this event handler
   	  public void actionPerformed (ActionEvent event){
   	     String menuName = event.getActionCommand(); //locate the label where the event occured
   		 String inputWord;
   		 Temperature tempN = null;
   		 
   		 //if the event took place at the item labeled "Add"
   		 if(menuName.equals("Add")){ 
   		    inputWord = JOptionPane.showInputDialog(null,  "What type of internship?"); //then open up a pop-up screen that intakes the value of a new temperature

   		 //make sure that the user input is valid for a Temperature
   		 try{
   		    tempN = new Temperature(inputWord);
   		 }
   		    
   		 //was it a valid Temperature format?
   		 catch (IllegalArgumentTemperatureException ite){
   		    System.out.println((ite.getMessage())+ inputWord);
   		    JOptionPane.showMessageDialog(null, "Not valid for Temperature: "); 
   		 }//ite 
   		 
   		 //now that the inputted Temperature value is safe to use, insert it into the TList temp[] in its sorted place, and print again
   		 linkTemp.ascendingInsert(tempN);
   		 temp2[lengthFilled++] = new Temperature(inputWord);
   		 Selection.selectionSort(temp2, lengthFilled);
   		    		    
   		 System.out.println("Sorted Edited Temperature Array: ");
   		 for(int i=0; i<lengthFilled; i++)
   		    System.out.println(temp2[i]);
   		 System.out.println("Sorted Edited TList: ");
   		 linkTemp.printList();
   		    
   		// updateText(temp2, linkTemp); //- method that would help re-print the new info onto the gui screen
   		    
   		   
   	     }//if
   	  }//action Performed 
    }//EditMenuHandler
   
   //print the new info back onto the GUI in a sorted way with the added temperatures
   public void updateText(Temperature[] tempList, TList list){
	    linkListText.setText(""); //erase the old content on linkList TextArea
	    linkListText.append(linkTemp.toString()); //attach the new info to the cleared TextArea
	    temperatureText.setText("");
	    int i=0;
	    while(tempList[i] != null) {
	       temperatureText.append(tempList[i] + "C \n");
	       i++;
	    }//while
	    myContentPane.add(linkListText);
	    myContentPane.add(temperatureText);
   }//updateText
   
   //when given the current wind speed and temperature, this method returns the resulting wind chill value 
   public float windChill(float temperature, float windSpeed){
      //double wspeedD = (double)windspeed;
      float	wchill = 35.74f + (0.6215f * temperature) - ((float)(35.75f * (Math.pow(windSpeed, 0.16f)))) + (0.4275f * temperature * ((float)(Math.pow(windSpeed, 0.16))));
      return Float.parseFloat(df.format(wchill));   
   }//windChill   
   
   //converts from Celsius to Fahrenheit 
   public float getFahrenheitTemperature(float temp){
      float fahrenheit = (temp * (9f/5)) + 32f;
	  return Float.parseFloat(df.format(fahrenheit));
   }//getFahrenheitTemperature
   
   //Determines whether or not the array is still useable and valid
   public static boolean isValidTempList(Temperature[] list, int lengthFilled){
      //is the list null?
      if (list == null){
	     System.out.println("Array is null.");
	     return false;
	  }  
	  //is the array full?			   
      if (lengthFilled == list.length){
         System.out.println("Can't store any more SSNs");
         return false;
      }
      return (true);
   }//isValidTempList
   
}//TemperatureGui