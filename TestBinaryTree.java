
public class TestBinaryTree{
	public class Node{
		int data;
		Node left;
		Node right;
	}
	
	public void PreOrder(Node root){
		if( root == null){
			return;
		}
		System.out.print(root.data);
		PreOrder(root.left);
		PreOrder(root.right);		
	}
	
	public void InOrder(Node root){
		if(root == null){
			return;
		}
		InOrder(root.left);
		System.out.print(root.data);
		InOrder(root.right);
		
	}
	
	public void PostOrder(Node root){
		if(root == null){
			return;
		}
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data);
		
	}
	
	public void LevelOrder(Node root){
		
		
	}
	
	
}