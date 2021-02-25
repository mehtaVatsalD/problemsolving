import java.util.*;

public class LevelBst{

	static int diff = 0;
	
	static Deque<TreeNode> q1 = new ArrayDeque<>();
	static Deque<Extra> q2 = new ArrayDeque<>();

	public static void main(String[] args){
		//int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		int[] arr = {1, 2, 3, 4};
		if(arr.length == 0){
			return;
		}
		TreeNode root = new TreeNode(arr[0]);
		q1.addLast(root);
		q2.addLast(new Extra(0, Integer.MIN_VALUE, Integer.MAX_VALUE));
		genBSTFromLevelOrder(arr);
		inorder(root);
	}
	
	private static void genBSTFromLevelOrder(int[] arr){
		int n = arr.length;
		while(q1.peekFirst()!=null){
			TreeNode root = q1.pollFirst();
			Extra extra = q2.pollFirst();
			int i = extra.i;
			int min = extra.min;
			int max = extra.max;
			System.out.println(i + " " + diff);
			if(2*i + 1 - diff >= n){
				continue;
			}
			
			if(arr[2*i+1-diff] < root.data && arr[2*i+1-diff] >= min){
				TreeNode leftNode = new TreeNode(arr[2*i+1-diff]);
				root.left = leftNode;
				q1.addLast(leftNode);
				q2.addLast(new Extra(2*i+1-diff, min, root.data));		
			}
			else{
				diff++;
			}
			
			if(2*i + 2 - diff >= n){
				continue;
			}
			
			if(arr[2*i+2-diff] >= root.data && arr[2*i+2-diff] < max){
				TreeNode rightNode = new TreeNode(arr[2*i+2-diff]);
				root.right = rightNode;
				q1.addLast(rightNode);
				q2.addLast(new Extra(2*i+2-diff, root.data, max));
			}
			else{
				diff++;
			}
		}	
		
	}
	
	private static void inorder(TreeNode root){
		if(root == null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}

class Extra{

	int i;
	int min;
	int max;

	Extra(int i, int min, int max){
		this.i = i;
		this.min = min;
		this.max = max;
	}
	
}
