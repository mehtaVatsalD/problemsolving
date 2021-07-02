import java.util.*;

public class CircularArray {
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();
		}
		boolean cycleCheAma = isThereAnyCycle(arr);
		System.out.println(cycleCheAma);
	}
	
	private static boolean isThereAnyCycle(int[] arr) {
		int n = arr.length;
		if(n == 0 || n == 1) {
			return false;
		}
		Map<Integer, Node> nodeMap = new HashMap<>();
		for(int i = 0 ; i < n ; i++) {
			if(nodeMap.containsKey(i)) {
				continue;
			}
			explore(arr, nodeMap, i);			
		}
		Solution sol = new Solution();
		for(Map.Entry<Integer, Node> entry: nodeMap.entrySet()) {
			int cLength = sol.lenghtOfLoop(entry.getValue());
			if(cLength > 1) {
				return true;
			}			
		}
		return false;
	}
	
	private static void explore(int[] arr, Map<Integer, Node> nodeMap, int i) {
		boolean orgDir = arr[i] > 0;
		boolean dir = orgDir;
		Node prev = null;
		while(dir == orgDir) {
			if(nodeMap.containsKey(i)) {
				prev.next = nodeMap.get(i);
				break;
			}
			Node node = new Node(i);
			if(prev != null) {
				prev.next = node;
			}
			prev = node;
			nodeMap.put(i, node);
			i = next(arr, i);
			dir = arr[i] > 0;
		}
	}
	
	private static int next(int[] arr, int i) {
		int n = arr.length;
		i = (i + arr[i])%n;
		if(i < 0) {
			i+=n;
		}
		return i;
	}
	
	
	
}
