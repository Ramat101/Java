//step 0: prepare everything for processing
import java.io.*;
import java.util.Scanner;

public class SelectionSort {
	public static void printArray(int[] numbers){
		for(int i = 0; i< numbers.length; i++)
		   System.out.print( i + "    ");
		System.out.print("\n");
		for(int j=0; j< numbers.length; j++)
		   System.out.print(numbers[j]+ "  ");
		System.out.print("\n\n");	
	}//printArray
	
	public static int[] sort(int[] numbers, int size){
		//step 1: initialize
		int position = 0, walker = position, smallest = position, temp = 0, iteration = 1, count = size;
		int[] array = numbers;
			
		 //now sort the array extracted from the file
		 while(position<count-1){//step 6
		    while(walker<count-1){//step 3
			   //step 2
			   walker++;
			   if(array[walker]<array[smallest])
			      smallest = walker;			
			}//while2
			//step 4
			System.out.println("Iteraration #" + iteration + ": Position Index = " + position + ", Min Index = " + smallest +". ");
			//swap
			temp = array[position];
			array[position] = array[smallest];
			array[smallest] = temp;
			position++;
			iteration++;
			System.out.println("Swapped Array: ");
			printArray(array);
			//step 5
			walker = position;
			smallest = position; 
		}//while1
           
		//step 8
		System.out.println("Sorted Array: ");
		for(int j= 0; j<count; j++){
		   System.out.println("Array["+j+"]: "+ +array[j]);
		}//for
		
		return array;
}//sort
		   

public static void main(String[] args) {  
   int count = 0, index = 0;
   try {
      Scanner inFile = new Scanner(new FileReader(args[0]));
	  //get count of how many integers are in the file 		
	  while(inFile.hasNextInt()){
	     inFile.nextInt();
		 count++;
	  }//while
	  inFile.close();
			   
	  //create an array the size of how many integers were in the file
	  Scanner inFile2 = new Scanner(new FileReader(args[0]));
	  int[] array = new int[count];
	  while(inFile2.hasNextInt()){
	     array[index] = inFile2.nextInt();
		 index++;
	  }
			   
	  System.out.println("Unsorted Array from File: ");
	  printArray(array);
	  
	  //sort the array
	  array = sort(array, count);
			   			   
   }//try

   catch (FileNotFoundException e) {
      e.printStackTrace();
   }//catch

}//Main
}//Selection Sort
