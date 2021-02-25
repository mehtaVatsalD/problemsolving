public class GreaterSumTree{

	public static void main(String[] args){
		TreeInput ti = new TreeInput();
		TreeNode root = ti.takeTreeInputFromUser();
		Solution solution = new Solution();
		solution.inorder(root);
		solution.generateGreaterSumTree(root, 0);
		solution.inorder(root);
		
	}
	
}



class Solution{

	public void inorder(TreeNode root){
		if(root == null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public int generateGreaterSumTree(TreeNode root, int sum){
		if(root.right != null){
			sum = generateGreaterSumTree(root.right, sum);
		}
		sum += root.data;
		root.data = sum - root.data;
		if(root.left != null){
			sum = generateGreaterSumTree(root.left, sum);
		}
		return sum;
		
	}

}
