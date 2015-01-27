
public class Node {
		   int dataCount;
		   Node next;
		   
		   public Node(){
			   dataCount= 0;
			   next = null;
		   }//constructor zero arguments
		   
		   public Node(int count){
			   dataCount = count;
			   next = null;
		   }//constructor one argument
		   
		   public Node(int count, Node ln) {
		      dataCount = count;
			  next = ln;
		   } //constructor two arguments
		   
		   public Node(Node ln){
			   next = ln;
			   dataCount = 1;
		   }

		   public void dataCountIncrement(){
			   dataCount++;
		   }
		   public void dataCountDecrement(){
			   dataCount--;
		   }
} // class Node


