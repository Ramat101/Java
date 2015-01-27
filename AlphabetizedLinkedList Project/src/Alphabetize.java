//Reads in words from a file and alphabetizes them
//step 0
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Alphabetize {

	public static void main(String[] args) {
		String data;
		LinkedList list = new LinkedList(); //step 1
		listNode walker;
		int arg = 0;
	    System.out.println("Enter the args index of the file you'd like to use: ");
	    System.out.println("Enter how often you'd like to print - every ___ amount of words read in");
	    int mod = 80;
	    
		try {
			  //step 2
			  Scanner in = new Scanner(System.in);
			  arg = in.nextInt();
			  mod = in.nextInt();
		      Scanner inFile = new Scanner(new FileReader(args[arg])); //step 1
			  
		      while(inFile.hasNext()){ //step 9
			      data = inFile.next(); //step 3
			      walker = list.listHead; //step 4
			     
			      //step 5 & 6
			      while((walker.next != null) && ((walker.next.word).compareTo(data) < 0))
			    		    walker = walker.next;
			      
			      //step 7
			      if((walker.next != null) && ((walker.next.word).equals(data))){
			    	  walker.next.wordCount++;
			    	  list.dataCount++;
			      }
			      
			      else{
			    	 list.insert(data, walker);
			     }
			     
			     //step 8 
			     if((list.dataCount)% mod == 0){
			    	 list.printList();
			     }
			  }//while
			  
		      System.out.println(" ");
			  System.out.println('\n'+"Final List: ");
			  list.printFinalList();
			  
			  inFile.close(); //step 10
		}//try
		
		catch (FileNotFoundException e) {
		       e.printStackTrace();
		}//catch
	}//main
}//Project 5
