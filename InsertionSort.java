//step 0: prepare everything for processing
import java.io.*;
import java.util.Scanner;

public class InsertionSort {
	public static void printArray(int[] numbers, int data, int spot, int last){
	     System.out.println("last = "+last+" data = "+data+" spot = "+spot);
	     for(int i = 0; i<=last; i++){
	    	 System.out.print("ary["+i+"] ");
	     }
	     System.out.print("\n");
	     for(int i = 0; i<=last; i++)
	    	 System.out.print(numbers[i]+"     ");
	     System.out.print("\n\n");	
	}//printArray

	
	public static void main(String[] args) {
		int count = 0, index, last, data, spot;		
		try {
		      Scanner inFile = new Scanner(new FileReader(args[0])); //step 1
			  //get count of how many integers are in the file 		
			  while(inFile.hasNextInt()){
			     inFile.nextInt();
				 count++; //step 2
			  }//while
			  inFile.close(); //step 3
			  
			  int[] array = new int[count]; //step 4
			  inFile = new Scanner(new FileReader(args[0])); //step 5
			
			  last = 0; //step 6  
			  data = inFile.nextInt(); //step 7
			  array[last] = data; //step 8
			  while(inFile.hasNextInt()){ //step 16
				 spot = 0;
			     data = inFile.nextInt(); //step 9
			     while(((array[spot])<data)){ //step 10
				     spot++;
				     if(spot>last)
				    	 break;
			     }    
			     //step 11
			     last++;
			     index = last;
			     while(index>spot){//step 13
			        //step 12
			        array[index] = array[index-1];
			        index--;
			     }//while
			     array[spot] = data; //step 14
			     
			     printArray(array, data, spot, last); //step 15

		    }//while
			  
			inFile.close(); //step 16
		  
	    }//try
			    
		catch (FileNotFoundException e) {
	       e.printStackTrace();
		}//catch

    }//main
}//InsertionSort
