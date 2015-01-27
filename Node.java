public class Node {
   String strData;
   Node next;
   
   public Node(){
	   strData = "";
	   next = null;
   }//constructor zero arguments
   
   public Node(String s){
	   strData = s;
	   next = null;
   }//constructor one argument
   
   public Node(String s, Node ln) {
      strData = s;
	  next = ln;
   } //constructor two arguments

} // class Node

