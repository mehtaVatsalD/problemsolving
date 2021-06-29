public class RearrangeLinkList {

	public static void main(String...args) {
		LinkInput ip = new LinkInput();
		Node first = ip.takeInput();
		ip.printLinkList(first);
		rearrangeLinkListAlt(first);
		ip.printLinkList(first);
		
		first = ip.takeInput();
		ip.printLinkList(first);
		rearrangeLinkListAltRev(first);
		ip.printLinkList(first);		
	}

	private static void rearrangeLinkListAlt(Node first) {
		Node middle = MiddleLinkNode.getMiddleNodeInLinkList(first);
		Node temp = first;
		while(middle.next != null) {
			Node next = middle.next;
			middle.next = next.next;
			next.next = temp.next;
			temp.next = next;
			temp = next.next;
		}
	}
	
	private static void rearrangeLinkListAltRev(Node first) {
		Node middle = MiddleLinkNode.getMiddleNodeInLinkList(first);
        Node last = ReverseLinkList.reverseLinkList(middle.next);
        middle.next = null;
		Node temp = first;
		while(last != null) {
			Node next = first.next;
            first.next = last;
            last = last.next;
            first = first.next;
            first.next = next;
            first = first.next;
		}
        
	}

}
