public class TreeNode {
	TreeNode left;
	TreeNode right; 
	int data;
	
	public TreeNode(){
		TreeNode dummy = new TreeNode(99999);
		dummy.left = null; 
		dummy.right = null; 
		data = 0;
	}
	
	public TreeNode(int content){
		left = null;
		right = null;
		data = content;
	}	
}//TreeNode
