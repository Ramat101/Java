public class ArrayFun{

	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		printArray(myArray);
		System.out.println();
		printArrayEven(myArray);
		System.out.println();
		
		int[][] newArray = fillArray(args[0]);
		printArray(newArray);
		System.out.println();
		printArrayEven(newArray);
	}
	
	private static void printArray (int[][] theArray) {
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	
	private static void display (int num){
		System.out.print(num+" ");
	}
	
	private static void printArrayEven(int[][] theArray){
		/* check for every element in the array if the element is even
			print the number if it is even, otherwise print star */
			
		for (int i = 0; i < theArray.length; ++i){
			for (int j = 0; j < theArray[i].length; ++j)
				if (theArray[i][j] % 2 == 0)
					System.out.print(theArray[i][j] + " ");
				else
					System.out.print("* ");
			System.out.println();
		}
	}
	
	public static int[][] fillArray(String myFile){
		/* opens a file and creates the size of array based on first two numbers
			fill the array with the rest of numbers in the file */
			
		TextFileInput in = new TextFileInput(myFile);
		String line = in.readLine();
		int rows = Integer.parseInt(line);
		line = in.readLine();
		int cols = Integer.parseInt(line);
		int[][] myArray = new int[rows][cols];
		
		for (int i = 0; i < rows; ++i){
			for (int j = 0; j < cols; ++j){
				line = in.readLine();
				myArray[i][j] = Integer.parseInt(line);
			}
		}
		return myArray;	//returns the filled array
	}
	
}