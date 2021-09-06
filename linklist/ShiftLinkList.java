import java.util.Scanner;

public class ShiftLinkList {

	public static void main(String...args) {
		LinkInput ip = new LinkInput();
		Node first = ip.takeInput();
		ip.printLinkList(first);
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		first = shiftByK(first, k);
		ip.printLinkList(first);
	}
	
	private static Node shiftByK(Node first, int k) {
		int n = linkListLength(first);
		k = getNewK(k, n);
		if(k == 0) {
			return first;
		}
		Node node = getNodeAtK(first, k);
		Node last = getLastNode(node);
		Node newFirst = node.next;
		last.next = first;
		node.next = null;
		return newFirst;
	}
	
	private static Node getNodeAtK(Node first, int k) {
		while(--k>0 && first!=null) {
			first = first.next;
		}
		return first;
	}
	
	private static Node getLastNode(Node node) {
		while(node.next!=null) {
			node = node.next;
		}
		return node;
	}

	
	private static int getNewK(int k, int n) {
		k = k%n;
		if(k < 0) {
			k+=n;
		}
		return (n-k)%n;
	}

	private static int linkListLength(Node first) {
		int n=0;
		while(first!=null) {
			first = first.next;
			n++;
		}
		return n;
	}

}
