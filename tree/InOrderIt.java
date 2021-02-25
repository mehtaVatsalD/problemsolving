import java.util.*;

public class InOrderIt{

	public static void main(String[] args){
		TreeInput ti = new TreeInput();
		TreeNode root = ti.takeTreeInputFromUser();
		Solution sol = new Solution();
		sol.inorder(root);
	}

}

class Solution{

	public void inorder(TreeNode root){
		if(root == null){
			return;
		}
		Deque<TreeNode> s = new ArrayDeque<>();
		s.addLast(root);
		do{
			root = s.pollLast();
			while(root != null){
				if(root.right!=null){
					s.addLast(root.right);
				}
				s.addLast(root);
				root = root.left;
			}
			
			
			while(s.peekLast() != null){
				root = s.pollLast();
				System.out.print(root.data + " ");
				if(root.right!=null && root.right == s.peekLast()){
					break;
				}
			}		
		}
		while(s.peekLast() != null);


		
	}
	
}
