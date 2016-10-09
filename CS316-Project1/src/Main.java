public class Main {
	public static void main(String argv[]){	
		// argv[0]: input file containing source code
		// argv[1]: output file displaying a list of the tokens that make up the source code
		LexicalAnalyzer lexi = new LexicalAnalyzer(argv[0], argv[1]);
		
		// while inputInt is not at the end-of-stream
		while ( lexi.inputInt != -1 ){ 
			lexi.getToken(); // extract the next token
		} 
		
		//close the IO tools
		lexi.closeIO();
	}
}
