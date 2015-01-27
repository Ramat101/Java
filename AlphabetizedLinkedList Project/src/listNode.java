
public class listNode {
	   String word;
	   listNode next;
	   int wordCount; 
	   
	   public listNode(){
		   word = "";
		   next = null;
		   wordCount = 0;
	   }//constructor zero arguments
	   
	   public listNode(String s){
		   word = s;
		   next = null;
		   wordCount = 1;
	   }//constructor one argument
	   
	   public listNode(listNode ln){
		   word = "";
		   next = ln;
		   wordCount = 0;
	   }
	   public listNode(int count){
		   word = "";
		   next = null;
		   wordCount = count;
	   }
	   
	   public listNode(String s, listNode ln) {
	      word = s;
		  next = ln;
		  wordCount = 1;
	   } //constructor two arguments

}
