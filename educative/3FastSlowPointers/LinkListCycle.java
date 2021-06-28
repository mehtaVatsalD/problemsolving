import java.util.*;

public class LinkListCycle {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Node first = sol.takeInput();
		Scanner scan = new Scanner(System.in);
		int toCycle = scan.nextInt();
		if(toCycle > 0) {
			int cyclePoint = scan.nextInt();
			sol.makeCycle(first, cyclePoint);
		}
		Node meetPoint = sol.isLinkListCyclic(first);
		if(meetPoint != null) {
			System.out.println("Loop detected!");
			System.out.println("Length of loop: " + sol.lenghtOfLoop(first));
			Node startPos = sol.startOfCycle(first);
			System.out.println("Loop start is " + startPos.val + " away from start of link list and value where is starts is " + startPos.next.val);
		}
		else {
			System.out.println("No loop detected!");
		}
		
	}
	
}

class Solution {

	public Node takeInput() {
		LinkInput input = new LinkInput();
		return input.takeInput();
	}
	
	public Node makeCycle(Node first, int n) {
		LinkInput input = new LinkInput();
		return input.makeCycle(first, n);
	}
	
	public int lenghtOfLoop(Node first) {
		Node loopMeet = isLinkListCyclic(first);
		if(loopMeet == null) {
			return 0;
		}
		Node ptr = loopMeet;
		int cnt = 0;
		do {
			cnt++;
			ptr = ptr.next;
		}
		while(ptr != loopMeet);
		return cnt;
	}
	
	
	public Node startOfCycle(Node first) {
		Node loopMeet = isLinkListCyclic(first);
		if(loopMeet == null) {
			return null;
		}
		Node ptr = first;
		int cnt = 0;
		while(ptr != loopMeet) {
			cnt++;
			ptr = ptr.next;
			loopMeet = loopMeet.next;
		}
		Node pos = new Node(cnt);
		pos.next = ptr;
		return pos;
	}

	public Node isLinkListCyclic(Node first) {
		Node slow = first;
		Node fast = first;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
			if(fast == slow) {
				break;
			}
		}
		return fast;
	}
	
}
