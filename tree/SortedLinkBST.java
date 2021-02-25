import java.io.*;
import java.util.*;

public class SortedLinkBST{

	public static void main(String[] args){
		LinkListInput li = new LinkListInput();
		LinkNode head = li.getInputFromUser();
		Solution solution = new Solution(head);
		TreeNode root = solution.generateBSTFromLinkList(solution.getLinkLength(head));
		solution.preorder(root);
	}
	
}

class Solution{
	
	private LinkNode node;
	
	public Solution(LinkNode head){
		this.node = head;
	}
	
	public TreeNode generateBSTFromLinkList(int n){
		System.out.println(n);
		if(n == 1){
			TreeNode newNode = new TreeNode(node.data);
			this.node = node.next;
			return newNode;
		}
		int mid = n/2 + 1;
		
		TreeNode leftRoot = null;
		if(mid-1 > 0)
			leftRoot = generateBSTFromLinkList(mid - 1);
		TreeNode newNode = new TreeNode(node.data);
		newNode.left = leftRoot;
		this.node = node.next;
		
		TreeNode rightRoot = null;
		if(n-mid > 0)
			rightRoot = generateBSTFromLinkList(n - mid);
		newNode.right = rightRoot;
		return newNode;
	}
	
	public void preorder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");		
		preorder(root.left);
		preorder(root.right);
	}
	
	public int getLinkLength(LinkNode head){
		int n = 0;
		while(head != null){
			n++;
			head = head.next;
		}
		System.out.println();
		System.out.println(n);
		return n;
	}
	
}

class LinkNode{
	int data;
	LinkNode next;
	
	public LinkNode(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkListInput{
	
	public LinkNode getInputFromUser(){
		LinkNode head = null;
		LinkNode last = null;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n>0){
			n--;
			if(head == null){
				head = last = new LinkNode(scan.nextInt());
			}
			else{
				last.next = new LinkNode(scan.nextInt());
				last = last.next;
			}
		}
		return head;
		
	}

}
