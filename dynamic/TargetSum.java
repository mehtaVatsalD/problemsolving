import java.util.*;

public class TargetSum {

	public static void main(String[] args) {
		System.out.println(bestSum(new int[]{5, 3, 4, 7}, 7));
		System.out.println(bestSum(new int[]{5, 3}, 7));
		System.out.println(bestSum(new int[]{2,3, 5}, 8)); 
		System.out.println(bestSum(new int[]{2,1}, 5)); 
		System.out.println(bestSum(new int[]{7, 14}, 300));
		System.out.println(bestSum(new int[]{7, 11}, 300));
	}
	
	private static List<Integer> bestSum(int arr[], int target) {
		return bestSum(arr, target, new HashMap<>());
	}
	
	private static List<Integer> bestSum(int arr[], int target, Map<Integer, List<Integer>> memo) {
		if (target == 0) {
			return new ArrayList<>();
		}
		if (target < 0) {
			return null;
		}
		if(memo.containsKey(target)) {
			return memo.get(target);
		}
		List<Integer> minPossibility = null;
		for(int i=0;  i<arr.length; i++) {
			List<Integer> possibility = bestSum(arr, target-arr[i], memo);

			if(possibility != null) {
				possibility = new ArrayList<>(possibility); 
				possibility.add(arr[i]);
				if (minPossibility == null || possibility.size() < minPossibility.size()) {
					minPossibility = possibility;
				}
			}
		}
		memo.put(target, minPossibility);
		return minPossibility;
	}
	
	private static List<Integer> howSum(int arr[], int target) {
		return howSum(arr, target, new HashMap<>());
	}
	
	private static List<Integer> howSum(int arr[], int target, Map<Integer, List<Integer>> memo) {
		if (target == 0) {
			return new ArrayList<>();
		}
		if (target < 0) {
			return null;
		}
		if(memo.containsKey(target)) {
			return memo.get(target);
		}
		for(int i=0;  i<arr.length; i++) {
			List<Integer> possibility = howSum(arr, target-arr[i], memo);
			if(possibility != null) {
				possibility.add(arr[i]);
				memo.put(target, possibility);
				return possibility;
			}
		}
		memo.put(target, null);
		return null;
	}
	
	
	//BruteForce
	/*
	private static List<Integer> howSum(int arr[], int target) {
		if (target == 0) {
			return new ArrayList<>();
		}
		if (target < 0) {
			return null;
		}
		for(int i=0;  i<arr.length; i++) {
			List<Integer> possibility = howSum(arr, target-arr[i]);
			if(possibility != null) {
				possibility.add(arr[i]);
				return possibility;
			}
		}
		return null;
	}
	*/
	
	//memoized
	private static boolean canSum(int arr[], int target) {
		return canSum(arr, target, new HashMap<>());
	}
	
	private static boolean canSum(int arr[], int target, Map<Integer, Boolean> memo) {
		if (target == 0) {
			return true;
		}
		if (target < 0) {
			return false;
		}
		if(memo.containsKey(target)) {
			return memo.get(target);
		}
		for(int i=0;  i<arr.length; i++) {
			boolean isPossible = canSum(arr, target-arr[i], memo);
			if(isPossible) {
				memo.put(target, true);
				return true;
			}
		}
		memo.put(target, false);
		return false;
	}

	//bruteForce
	/*
	private static boolean canSum(int arr[], int target) {
		if (target == 0) {
			return true;
		}
		if (target < 0) {
			return false;
		}
		for(int i=0;  i<arr.length; i++) {
			boolean isPossible = canSum(arr, target-arr[i]);
			if(isPossible) {
				return true;
			}
		}
		return false;
	}
	*/
	
}
