public class TreeTriplets{

	public static void main(String[] args){
		Solution solution = new Solution();
		TreeInput ti = new TreeInput();
		TreeNode root = ti.takeTreeInputFromUser();
		System.out.println(solution.countTriplets(root, 100, 0));
	}

}

class Solution{

	public int countTriplets(TreeNode root, int x, int cnt){
		if(root == null){
			return cnt;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if(left != null){
		
			TreeNode grandLeft = left.left;
			TreeNode grandRight = left.right;
			
			if(grandLeft != null && root.data+left.data+grandLeft.data>x){
				cnt++;
			}
			
			if(grandRight != null && root.data+left.data+grandRight.data>x){
				cnt++;
			}
			cnt = countTriplets(left, x, cnt);
			
		}
		
		if(right != null){
		
			TreeNode grandLeft = right.left;
			TreeNode grandRight = right.right;
			
			if(grandLeft != null && root.data+right.data+grandLeft.data>x){
				cnt++;
			}
			
			if(grandRight != null && root.data+right.data+grandRight.data>x){
				cnt++;
			}
			cnt = countTriplets(right, x, cnt);
		}
		
		return cnt;
		
	}	
	
}
