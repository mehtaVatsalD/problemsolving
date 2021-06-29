public class ReverseLinkList {

	public static void main(String...args) {
		LinkInput ip = new LinkInput();
		Node first = ip.takeInput();
		ReverseLinkList rl = new ReverseLinkList();
		first =	rl.reverseLinkList(first);
		ip.printLinkList(first);
	}
	
	public Node reverseLinkList(Node first) {
		Node prev = null;
		Node cur = null;
		Node next = first;
		while(next != null) {
			prev = cur;
			cur = next;
			next = next.next;
			cur.next = prev;
		}
		return cur;
	}

}
