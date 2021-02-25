import java.util.*;

public class PreOrderIt{

	public static void main(String[] args){
		TreeInput ti = new TreeInput();
		TreeNode root = ti.takeTreeInputFromUser();
		Solution sol = new Solution();
		sol.preorder(root);
	}

}

class Solution{

	public void preorder(TreeNode root){
		if(root == null){
			return;
		}
		Deque<TreeNode> s = new ArrayDeque<>();
		s.addLast(root);
		while(s.peekLast() != null){
			root = s.pollLast();
			System.out.print(root.data + " ");
			if(root.right != null){
				s.addLast(root.right);
			}
			if(root.left != null){
				s.addLast(root.left);			
			}
		}		
		
	}
	
}
