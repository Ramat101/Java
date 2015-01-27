import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HeapSort {
	public static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}//swap	
	
	public static void BubbleDown(int[] array){
		int fatherIndex = 1; //step 10.1
		int last = array[0];
		int smallKid = 0;
		int leftKid, rightKid;
		while (true){
			//step 10.2
			leftKid = fatherIndex * 2;
			rightKid = (fatherIndex *2)+1;
			//step 10.3 - find smallKid
			//case 1 - father has both left and right kids
			if (rightKid <= last){ //won't go out of bounds
				if (array[leftKid] < array[rightKid])
					smallKid = leftKid;
				else
					smallKid = rightKid;
			} //if
			//case 2 - father has only leftKid
			else if ((leftKid <= last) && (rightKid>last)){
				smallKid = leftKid;
			}//else if
			if ((leftKid>last && rightKid > last) || (array[fatherIndex] <= array[smallKid]))
				return;
			//step 10.4 - array[fatherIndex]
			if((smallKid <= last) && (array[smallKid] < array[fatherIndex])){
				swap(array, smallKid, fatherIndex);
				fatherIndex = smallKid;
			}//if
		}//while	
	} //BubbleDown
    
	public static void BubbleUp(int[] array){
		int	kidIndex = array[0]; //step 5.1
		int	fatherIndex;
			while(true){
				fatherIndex = kidIndex/2; //step 5.2
				if((kidIndex == 1) || (array[fatherIndex] <= array[kidIndex]))
					return;
				if(array[kidIndex] < array[fatherIndex]){ //step 5.3
					swap(array, kidIndex, fatherIndex);
					kidIndex = fatherIndex;
				}//if
			}//while
		} //BubbleUp
	
	public static void main(String[] args) {
		//step 0
		int index;
		int count = 0, last = 0, data = 0, first = 1;
		try {
			  Scanner in = new Scanner(System.in);
			  System.out.println("Enter the argument index of where the file is stored: ");
			  index = in.nextInt();
		      Scanner inFile = new Scanner(new FileReader(args[index]));
			  //get count of how many integers are in the file 		
			  while(inFile.hasNextInt()){
			     inFile.nextInt();
				 count++;
			  }//while
			  
			  inFile.close();
			  int[] array = new int[count+1]; //step 4
			  inFile = new Scanner(new FileReader(args[index])); //step 5
			  
			  //Build the Heap
			  while(inFile.hasNextInt()){ //step 6
				  data = inFile.nextInt(); //step 2
				  last++; //step 3
				  array[0] = last;
				  array[last] = data;
				  BubbleUp(array); //step 5
			  }//while
			  inFile.close(); //step 7
			  
			  System.out.println("Unsorted: ");
			  for(int i = 0; i<count+1; i++)
				  System.out.print("array["+i+"]="+array[i]+", ");
			  System.out.println(" ");
			  int index2 = 1;		 
			  System.out.println("\nSorted: ");
			  while(last != 0){
			     //Delete the Heap
			     System.out.print("array["+index2+"]="+array[first] + ", "); //step 8
			     array[first] = array[last]; //step 9
			     last--;
			     BubbleDown(array);
			     index2++;
			  }
	   }//try

	   catch (FileNotFoundException e) {
	      e.printStackTrace();
	   }//catch
      
   }//main
}//HeapSort