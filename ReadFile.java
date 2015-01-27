//Reads off any integers from files loaded into args[0]
import java.io.*; //step 0
import java.util.Scanner; //step 0
public class ReadFile{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new FileReader(args[0])); //step 0
		int dataIn, count = 0; 
		int[] array = new int[100];
		
		while(inFile.hasNext()){ //step 5
			dataIn = inFile.nextInt(); //step 3
			array[count++] = dataIn;
		}//while
		
		for(int j = 0; j<count; j++)
			System.out.println("array: "+ array[j]);	
		
		inFile.close();
	}//main
}//ReadFile
