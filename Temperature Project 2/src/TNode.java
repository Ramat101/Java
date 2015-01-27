//Node that contains a Temperature as its data type
public class TNode {
   String strData;
   TNode next;
   
   public TNode(){
	   strData = null;
	   next = null;
   }//constructor zero arguments
   
   public TNode(String s){
	   strData = s;
	   next = null;
   }//constructor one argument
   
   public TNode(String s, TNode ln) {
      strData = s;
	  next = ln;
   } //constructor two arguments

} // class Node

