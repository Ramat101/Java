//this class can be used for easy input/output handling
import java.io.*;

public abstract class IO{
	public static BufferedReader inStream;
	public static PrintWriter outStream;

	public static int inputInt; // the current input character on "inStream"
	public static char c; // used to hold the integer version of the input stream as a char whenever necessary

	public IO(String inFile, String outFile){
		setIO(inFile, outFile);
	}
	
	// Returns the next character on the input stream.
	public static int getNextChar(){
		try{
			return inStream.read();
		}
		catch(IOException e){
			e.printStackTrace();
			return -1;
		}
	}

	// Returns the next non-whitespace character on the input stream.
	// Returns -1 if the end of the input stream is reached.
	public static int getChar(){
		int i = getNextChar();
		while ( Character.isWhitespace((char) i) )
			i = getNextChar();
		return i;
	}

	//prints String s to an external file
	public static void print(String s){
		outStream.print(s);
	}

	//prints String s to an external file and then goes to the next line
	public static void println(String s){
		outStream.println(s);
	}


	//used to configure the Buffered Reader: read in from inFile, print out to outFile, and read in one character at a time
	public static void setIO(String inFile, String outFile){
		try{
			inStream = new BufferedReader( new FileReader(inFile) );
			outStream = new PrintWriter( new FileOutputStream(outFile) );
			inputInt = inStream.read();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	//closes the input and output readers
	public static void closeIO(){
		try{
			inStream.close();
			outStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}