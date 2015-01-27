import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BinarySearchTree {
	public static void in_Order_Traversal(TreeNode pointer){
			if(pointer != null){
			   in_Order_Traversal(pointer.left);
			   if(pointer.data == 0)
				   System.out.println("dummy");
			   else
			    System.out.println(pointer.data+", ");
			   in_Order_Traversal(pointer.right);
			}
			return;
	}//in_Order_Traversal

	public static TreeNode search(TreeNode root, int data){
		TreeNode spot = root; //step 5.1
		while(true){ //step 5.5
			if (spot != null){ //step 5.2
			   if(spot.data == data){
				  System.out.println("Found "+spot.data);
				  return spot;
			}
			//go to the right
			else if(spot.data < data){ //step 5.3
				if(spot.right == null){ //single parent
					 if(spot.data == 0)
						System.out.print("dummy, ");
					 else
					   System.out.println(spot.data+", NULL. Data Not Found:"+data);
					return spot.right;
				}
				else{ //internal node
					 if(spot.data == 0)
						 System.out.print("dummy, ");
					 else
						 System.out.print(spot.data+", ");
					spot = spot.right;
				}
			}
			//go to the left
			else if(spot.data > data){ //step 5.4
				if(spot.left == null){//single parent
					System.out.println(spot.data+", Null. Data not found:"+data);
					return spot.left;
				}
				else{
					 if(spot.data == 0)
						   System.out.print("dummy, ");
					 else 
						 System.out.print(spot.data+", ");
					spot = spot.left;
				}
			}
			else{
				System.out.println("Null. Data not found:"+data);
				return spot;
			}
		}}//while
	}//search
	
	public static void insert(TreeNode root, int data){
		TreeNode spot = root; //step 4.1
		while(true){//step 4.5
			if(spot.data == data){//step 4.2
				System.out.println("\n"+data +" is already in the tree.");
				return;
			}//if
			//go to the right
			else if(spot.data < data){ //step 4.3
				if(spot.right == null){
					System.out.println("\nInserting:"+ data);
					spot.right = new TreeNode(data);
					return;
				}//if - single parent case
				else
					spot = spot.right; //not a leaf node
			}
			//go to the left
			else //spot.data > data //step 4.4
				if(spot.left == null){
					System.out.println("\nInserting:"+ data);
					spot.left = new TreeNode(data);
					return;
				}//if- single parent case
				else //not a leaf node
					spot = spot.left;
		}//while
	}//insert
	
	public static void main(String[] args) {
		int index, data;
		char method;
		TreeNode root = new TreeNode();//step 1
		try {//step 0
			  Scanner in = new Scanner(System.in);
			  System.out.println("Enter the argument index of where the file is stored: ");
			  index = in.nextInt();
		      Scanner inFile = new Scanner(new FileReader(args[index]));
		      while(inFile.hasNext()){ //step 6
				  method = inFile.next().charAt(0);
				  if(method == '+'){//step 4
					  if(inFile.hasNextInt()){
						  data = inFile.nextInt(); //step 2
						  insert(root, data);
					  }//if 
				  }//if+
				 
				  else if(method == 'p'){ //step 3
					  System.out.println("\nPrinting:");
					  in_Order_Traversal(root);
				  }//if 'p'
				  
				  else //(method == '*') //step 5
					  if(inFile.hasNextInt()){
					     data = inFile.nextInt(); //step 2
					     System.out.println("\nSearching for:"+data);
					     TreeNode found = search(root, data);
					  }
		    }//while
		      inFile.close(); //step 7
		}//try
		
		catch (FileNotFoundException e) {
		      e.printStackTrace();
		}//catch

    }//main
}//Project6
