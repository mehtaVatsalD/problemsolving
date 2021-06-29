public class LinkPalindrome {

	public static void main(String...args) {
		LinkInput ip = new LinkInput();
		Node first = ip.takeInput();
		ip.printLinkList(first);
		
		LinkPalindrome lp = new LinkPalindrome();
		boolean isPalindrome = lp.isLinkListPalindrome(first);
		System.out.println(isPalindrome);
		ip.printLinkList(first);
	}
	
	private boolean isLinkListPalindrome(Node first) {
		MiddleLinkNode mln = new MiddleLinkNode();
		ReverseLinkList rll = new ReverseLinkList();
		
		Node middle  = mln.getMiddleNodeInLinkList(first); //O(n)
		Node last = rll.reverseLinkList(middle); //O(n)
		boolean isPalindrome = checkForPalindrome(first, last); //O(n)
		rll.reverseLinkList(last); //O(n)
		return isPalindrome;
	}
	
	private boolean checkForPalindrome(Node first, Node last) {
		while(last != null) {
			if(first.val != last.val) {
				return false;
			}
			first = first.next;
			last = last.next;
		}
		return true;
	}
		
	
}
