import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class MergeSort {
	public static PrintWriter sort(Scanner dataA, Scanner dataB, String path) throws FileNotFoundException{	
		File file = new File(path);
		PrintWriter outFile = new PrintWriter(file);
		int tempA = 0, tempB = 0;
		//step 2
		tempA = dataA.nextInt();
		tempB = dataB.nextInt();
		while(dataA.hasNextInt() && dataB.hasNextInt()){//step 3
			if(tempA < tempB){
			   System.out.println(tempA);
			   outFile.println(tempA);
			   tempA = dataA.nextInt();
			}//if
			else if (tempA > tempB ){
				System.out.println(tempB);
				outFile.println(tempB);
				tempB = dataB.nextInt();
			}//else if
			else if (tempA == tempB){
				System.out.println(tempA);
				outFile.println(tempA);
				tempA = dataA.nextInt();
				tempB = dataB.nextInt();
			}//else if
		}//while
		//step 4
		while(dataA.hasNextInt()){
			tempA = dataA.nextInt();
			System.out.println(tempA);
			outFile.println(tempA);
		}
		while(dataB.hasNextInt()){
			tempB = dataB.nextInt();
			System.out.println(tempB);
			outFile.println(tempB);
		}
		outFile.close();
		return outFile;
	}//sort
	
	public static void main(String[] args) {
		//step 0
		int index1 = 0, index2 = 0, tempA = 0, tempB=0, tempC = 0; 
		String path = " ";
		try{
		 //get arguments
		  Scanner in = new Scanner(System.in);
		  System.out.println("Enter the argument index of where the first file is loaded: ");
		  index1 = in.nextInt();
		  System.out.println("Enter the argument index of where the second file is loaded: ");
		  index2 = in.nextInt();
		  System.out.println("Enter a path and new file name for your completed merged file (i.e. C:/Users/Tamar/Documents/cs313/outFile.txt)");
		  path = in.next();
	      Scanner inFile1 = new Scanner(new FileReader(args[index1]));
	      Scanner inFile2 = new Scanner(new FileReader(args[index2]));
	      PrintWriter outFile = new PrintWriter(path);
	      //step1
	      //check if file1 is in order
	      while( inFile1.hasNextInt()){
	  			tempA = inFile1.nextInt();
	  			if(inFile1.hasNextInt())
	  			  tempB = inFile1.nextInt();
	  			else{
	  				tempC = tempA;
	  				tempA = tempB;
	  				tempB = tempC;
	  			}
	  			if(tempA > tempB){
	  			    System.out.println("Only sorted files can be merged.");
	  				return;
	  			  }//if
	  			 System.out.print(tempA+", "+tempB+", ");       
	  	  }//while
	      System.out.println("File1 is in ordered sequence.");
	      //check if file2 is in order
	      while( inFile2.hasNextInt()){
	  			tempA = inFile2.nextInt();
	  			if(inFile2.hasNextInt())
	  			  tempB = inFile2.nextInt();
	  			else{
	  				tempC = tempA;
	  				tempA = tempB;
	  				tempB = tempC;
	  			}
	  			  if(tempA > tempB){
	  			    System.out.println("Only sorted files can be merged.");
	  				return;
	  			}//if
	    	    System.out.print(tempA + ", "+ tempB+", ");
	  	  }//while
	      System.out.println("File2 is in ordered sequence.");
	      inFile1.close();
	      inFile2.close();
	      //sort
	      inFile1 = new Scanner(new FileReader(args[index1]));
	      inFile2 = new Scanner(new FileReader(args[index2])); 
	      System.out.println("\nNew Merged File:");
	      outFile = sort(inFile1, inFile2, path);
		}//try
		
		catch (FileNotFoundException e) {
		      e.printStackTrace();
		}//catch
	}//main
}//MergeSort
