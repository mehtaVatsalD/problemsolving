import java.util.*;

public class PostOrderIt{

	public static void main(String[] args){
		TreeInput ti = new TreeInput();
		TreeNode root = ti.takeTreeInputFromUser();
		Solution sol = new Solution();
		sol.postorder(root);
	}

}

class Solution{

	public void postorder(TreeNode root){
		Deque<TreeNode> s = new ArrayDeque<>();
			
		TreeNode temp = root;
		
		do{
		
			while(temp!=null){
				if(temp.right != null){
					s.addLast(temp.right);
				}
				s.addLast(temp);
				temp = temp.left;
			}
			
			while(s.peekLast() != null){
				temp = s.pollLast();
				if(temp.right != null && temp.right == s.peekLast()){
					s.pollLast();
					s.addLast(temp);
					temp = temp.right;
					break;
				}
				else{
					System.out.print(temp.data + " ");
				}
			}
			
			
			
		}
		while(s.peekLast() != null);
		
	}
	
}
