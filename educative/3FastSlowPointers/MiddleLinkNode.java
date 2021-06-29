import java.util.*;

public class MiddleLinkNode {

	public static void main(String[] args) {
		Solution sol = new Solution();
		Node first = sol.takeInput();
		Node middleNode = getMiddleNodeInLinkList(first);
		System.out.println(middleNode.val);
	}
	
	public static Node getMiddleNodeInLinkList(Node first) {
		Node fast = first;
		Node slow = first;
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
			if(fast.next != null) {
				fast = fast.next;
			}
		}
		return slow;
	}

}
