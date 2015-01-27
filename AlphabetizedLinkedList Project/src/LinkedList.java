
public class LinkedList{
		   // empty node that pointer first and last point to	
		   //listNode dummy = new listNode();	
		   listNode listHead;
		   listNode last;
		   int length = 0; //length keeps track of how long the linkedList is
		   int dataCount = 0; //how many words have been calculated into the linkedListNode
		   
		   public LinkedList(){
			   listNode dummy = new listNode();
			   listHead = dummy;
			   last = dummy;
			   length = 0;
			   dataCount = 0;
		   }
		   
		   public void append(String s){
			   listNode n = new listNode(s);
			   last.next = n;
			   last = n;
			   length++;
			   n.wordCount++;
		   }
		   
		   public void insert(String s, listNode walker) {
			      listNode n = new listNode(s);
			      n.next = walker.next;
			      walker.next = n;
				  length++;
				  n.wordCount++;	
				  this.dataCount++;
			}//append
		   
		   public void printList(){
			   System.out.println('\n');
			   int i = 0; 
			   listNode p = this.listHead.next;
			   System.out.print("listHead->('dummy', 0 , "+ listHead.next.word+")->");
			   
			   while(((p.next) != null) && (i<18)){
				   System.out.print("("+ (p.word) +" , "+ (p.wordCount)+ ", "+ (p.next.word) +")->");
				   i++;
				   p = p.next;
			   }
			   if(i >= 18){
				   System.out.print(". . .");
				   return;
			   }   
			   else{ // ((p.next == null))
			      System.out.print("("+p.word+", "+ p.wordCount + ",null)->null\n");
		          return;
		       } 
		   }
		   
		  
		   public void printFinalList(){
			   listNode p = this.listHead.next;
			   System.out.print("listHead->('dummy', 0 , "+ listHead.next.word+")->");
			   
			   while(((p.next) != null)){
				   System.out.print("("+ (p.word) +" , "+ (p.wordCount)+ ", "+ (p.next.word) +")->");
				   p = p.next;
			   }
			   System.out.println("("+p.word+", "+ p.wordCount + ",null)->null");
		       return; 
		  }
	
		   public int getLength(){
			   return length;
		   }
		   
		   public int getDataCount(){
			   return dataCount;
		   }
} //LinkedList
