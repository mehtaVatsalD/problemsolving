import java.io.*;
import java.util.*;

public class TreeInput{
	
	public TreeNode takeTreeInputFromUser(){
	
		List<String> valList = new ArrayList<>();
	
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n>0){
			n--;
			valList.add(scan.next());
		}
		
		if(valList.size() == 0 || (valList.size() ==1 && "N".equals(valList.get(1)))){
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(valList.get(0)));
		formTreeForRoot(root, valList, 0);
		return root;
		
	}
	
	private void formTreeForRoot(TreeNode root, List<String> valList, int i){
		String leftNodeString = (2*i+1 < valList.size()) ? valList.get(2*i+1) : "N";
		String rightNodeString = (2*i+2 < valList.size()) ? valList.get(2*i+2) : "N";
		
		TreeNode leftNode = null;
		TreeNode rightNode = null;
		
		if(!"N".equals(leftNodeString)){
			leftNode = new TreeNode(Integer.valueOf(leftNodeString));
			root.left = leftNode;
			formTreeForRoot(leftNode, valList, 2*i+1);
		}
		
		if(!"N".equals(rightNodeString)){
			rightNode = new TreeNode(Integer.valueOf(rightNodeString));
			root.right = rightNode;
			formTreeForRoot(rightNode, valList, 2*i+2);
		}
		
		return;	
		
	}
	
}
