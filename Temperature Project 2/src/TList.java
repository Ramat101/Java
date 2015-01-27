/**
 * Represents a list of nodes that hold a Temperature as its data type.
 * You can add a new TNode to the beginning or end of the list, or you can insert a 
 * new TNode into the list in ascending order. User's can also print the whole TList
 * as a String.
 * @author Tamar
 *
 */

public class TList {
   /** empty node that pointer first and last point to **/	
   private TNode dummy = new TNode(null);	
   private TNode first = dummy;
   private TNode last = dummy;
   /** length keeps track of how long the (TList) LinkedList is **/
   private static int length = 0; 
   
   /**
    *Gets the number of data values stored in TList 
    * @return the number of TNodes in the list
    */
   public int getLength(){
      return length;
   }
   
   /**
    * Gets the first TNode of the list
    * @return the first TNode of the TList
    */
    public TNode getFirst(){
       return first;   	
    }
    
    /**
     * Gets the last TNode of the list
     * @return the last TNode of the TList
     */
     public TNode getLast(){
        return first;   	
     }
    
    /**
     *  Gets the data of the first TNode in the TList
     * @return the Temperature data of the first TNode in the TList
     */
    public String getFirstData(){
       return (this.getFirst().strData);
    }
    
    /**
     *  Gets the data of the last TNode in the TList
     * @return the Temperature data of the last TNode in the TList
     */
    public String getLasttData(){
       return (this.getFirst().strData);
    }
    
   /**
    * add a new TNode to the beginning of the TList
    * the @param Temperature called data will be the data
    * contained in the TNode.
    */
   //adds to the beginning of TList
   public void prepend(Temperature data){
	  String d = Float.toString(data.getTemperature());
      TNode n = new TNode (d);
	  if(length == 0){
         first.next = n;
	     last = n;
      }//Case 1: Empty list
	  else{
         n.next = first.next;
         first.next = n;
	   }
	   length++;
   }//prepend
   
   /**
    * add a new TNode to the end of the TList
    * the @param Temperature called data will be the data
    * contained in the TNode.
    */
   //add to the end of TList
   public void append (Temperature data) {
	  String d = Float.toString(data.getTemperature());
      TNode n = new TNode(d);
	  last.next = n;
	  last = n;
	  length++;
   }//append
   
   
   /**
    * @return prints out all the data contained
    * in the TNodes of the Tlist
    */
   //print everything in the TList  
   public void printList() {
      TNode p = first.next;
	  while (p != null) {
	     System.out.println(p.strData);
	     p = p.next;
	  }
   }//printList
   
   /**
    * prints out everything in the TList as one long
    * @return String
    */
   //prints everything in the TList onto one string
   public String toString() {
      TNode p = first.next;
	  String returnString = "";
	  while (p != null) {
	     returnString += p.strData + "C \n";
		 p = p.next;
	  }
	  return returnString;
   }//toString
   
   /**
    * takes in a @param Temperature called temp and
    * inserts it into the LinkedList in ascending order. So all TNodes
    * that contain a data value that is less than the data value of the new TNode
    * link behind the new TNode, and TNodes that contain a data type greater than the 
    * new TNode's data type, link in front of the new TNode. 
    */
   public void ascendingInsert (Temperature temp){
      //create a TNode for this Temperature data
	  String d = Float.toString(temp.getTemperature());
      TNode tn = new TNode(d);
       
	  //if the LinkedList is empty and the new node is the first in the list, then just append the new TNode into the list
      if (length == 0){
         append(temp);
	  }//if the LinkedList has no nodes in it yet, then append the new node   	  
      
      /* if the TList has a length greater than one, then
       * going to have to manually iterate through the TList.
       * Will need two pointers to keep track of where to insert the new TNode */
      else{
         TNode front = first.next; //pointer that points to the first node in list that has data in it- will be used to keep track of what our insert TNnode should point to
    	 TNode back = first; //pointer that points to first- will be used to keep track of what should point to the insert TNode     	   
         //travel through the list to where we need to insert
         while ((temp.getTemperature())>(Float.valueOf(front.strData))) { //since the list is ascending, once we find a data number greater than the data number we are adding, we prepend to that
	        front = front.next;
	        back = back.next;      
	     }//while	
	        
         tn.next = front; //tn's pointer is equal to a the pointer which refers to what should be in front of tn
	     back.next = tn; //the pointer which should point to tn, points to tn
      }//else
      
      length++; 
   }//ascendingInsert	  

}//TList
