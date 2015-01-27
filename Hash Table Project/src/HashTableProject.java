//step 0
import java.io.*;
import java.util.Scanner;

public class HashTableProject{
	
	public static listNode findSpot(linkedList list, int dataIn){
		listNode spot = list.listHead;
	    while(spot.next != null){
	    	if(spot.next.data == dataIn){
	    		System.out.println("Data already in the Hash Table.");
	    		return null;
	        }//if
	    	else if (spot.next.data<dataIn)
	    		spot = spot.next;
	    	else
		        return spot;
	    }//while
	    return spot;
	}//findSpot
	
	public static void hashOne(Scanner inFile, HashTable table, int b){
		int data = 0, index = 0; 
		listNode spot;
		while(inFile.hasNext()){
		   data = inFile.nextInt(); //step 5.1
		   index = data % b; //step 5.2
		   System.out.println("Data:"+data+", Index:"+index); //step 5.3
		   spot = findSpot(table.getElement(index), data); //step 5.4
		   if(spot == null){ //step 5.5
			   continue;
		   }
		   else{
		      listNode add = new listNode(data);
		      add.next = spot.next;
		      spot.next = add;
		   }//else
		}//while	
	}//hashOne
	
	public static int sumOfDigits(int x){
		int digit = 0, sum = 0;
		while(x!=0){
			digit = x%10;
			sum = sum + digit;
			x = x/10;
		}
		return sum;
	}//sumOfDigits
	
	public static void hashTwo(Scanner inFile, HashTable table, int b){
		int data = 0, index = 0; 
		listNode spot; 
		while(inFile.hasNext()){
			data = inFile.nextInt();
			index = sumOfDigits(data)%b;
			System.out.println("Data:"+data+", Index:"+index);
			spot = findSpot(table.getElement(index), data);
			if(spot == null){
				continue;
			}
			else{
			    listNode add = new listNode(data);
			    add.next = spot.next;
			    spot.next = add;
			   }//else
			}//while
	}//hashTwo
	
	public static int doIt(String x){
		char[] dataC;
		int val = 0;
		dataC = x.toCharArray();
		for(int i = 0; i<x.length(); i++){
			val = (val*32)+(int)dataC[i];
		}
		return val;
	}//doIt
	
	public static void hashThree(Scanner inFile, HashTable table, int b){
		int index = 0, data = 0;
		listNode spot;
		while(inFile.hasNextInt()){
		   data = inFile.nextInt();
		   index = doIt(Integer.toString(data))%b;
		   System.out.println("Data:"+data+", Index:"+index);
		   spot = findSpot(table.getElement(index), data);
		   System.out.println("Found spot");
		   if(spot == null){
			  continue;
		   }
		   else{
			   listNode add = new listNode(data);
			   add.next = spot.next;
			   spot.next = add;
		   }//else
		}//while
	}//hashThree
	
	public static void main(String[] args) {
		int Bsize = 0, parameter = 0, whichHash = 0; //step 1
		try{
		   Scanner in = new Scanner(System.in);
		   System.out.println("Enter the amount of buckets you will use for the Hash Table:");
		   Bsize = in.nextInt();
		   HashTable table = new HashTable(Bsize); //step 2
		   System.out.println("Enter the argument index where the file is stored:");
		   parameter = in.nextInt();
		   Scanner infile = new Scanner(new FileReader(args[parameter])); //step 3
		   while(true){
		      System.out.println("Which hash function would you like to use:");
		      whichHash = in.nextInt(); //step 4
		      if(whichHash>=1 && whichHash<=3)
		    	  break;
		   }//while
		   //step 5
		   if(whichHash == 1)
			   hashOne(infile, table, Bsize);
		   else if (whichHash == 2)
			   hashTwo(infile, table, Bsize);
		   else if (whichHash == 3)
			   hashThree(infile,table, Bsize);
		  
		  table.printHashTable(); //step 6
		}//try
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main
}//HashTableProject