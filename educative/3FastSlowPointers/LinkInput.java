import java.util.*;
import java.lang.RuntimeException;

public class LinkInput {

	public Node takeInput() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		Node ptr = null;
		Node first = null;
		while(n-- > 0) {
			int val = scan.nextInt();
			if(first == null) {
				first = ptr = new Node(val);
				continue;
			}
			ptr.next = new Node(val);
			ptr = ptr.next;
		}
		return first;
	}	
	
	public Node makeCycle(Node first, int n) {
		if(first == null) {
			throw new RuntimeException("Not possible to create cycle in empty link list!");
		}
		int cnt = 1;
		Node temp = first;
		Node prev = null;
		Node thisOne = null;
		do {
			if(cnt == n) {
				thisOne = temp;
			}
			cnt++;
			prev = temp;
			temp = temp.next;
		}
		while(temp != null);
		if(cnt < n) {
			throw new RuntimeException("Invalid place to create cycle in link list");
		}
		prev.next = thisOne;
		return thisOne;		
		
	}
	
}
