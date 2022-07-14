import java.util.*;
class IntersectingIntervals {
	
	public static void main(String...args) {
		IntersectingIntervals solution = new IntersectingIntervals();
		
		int[][] ans = solution.intervalIntersection(
				new int[][]{{0,2},{5,10},{13,23},{24,25}},
				new int[][]{{1,5},{8,12},{15,24},{25,26}}
			);
			
		Arrays.stream(ans).forEach(interval -> System.out.print(Arrays.toString(interval)));
		System.out.println();
		
		
	}

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIntervalIndex = 0;
        int secondIntervalIndex = 0;
        
        int firstListLen = firstList.length;
        int secondListLen = secondList.length;
        
        List<int[]> intersectingIntervals = new ArrayList<>();
        
        while(firstIntervalIndex < firstListLen && secondIntervalIndex < secondListLen) {
            
            if (firstList[firstIntervalIndex][1] < secondList[secondIntervalIndex][0]) {
                firstIntervalIndex++;
                continue;
            }
            if (secondList[secondIntervalIndex][1] < firstList[firstIntervalIndex][0]) {
                secondIntervalIndex++;
                continue;
            }
            
            int start =Math.max(firstList[firstIntervalIndex][0], secondList[secondIntervalIndex][0]);
            int end = Math.min(firstList[firstIntervalIndex][1], secondList[secondIntervalIndex][1]);
            
            
            intersectingIntervals.add(new int[]{start, end});
            
            if (firstList[firstIntervalIndex][1] < secondList[secondIntervalIndex][1]) {
               firstIntervalIndex++;
            } else {
                secondIntervalIndex++;
            }
                
        }
        int[][] finalIntervals = new int[intersectingIntervals.size()][2];
        for(int i=0; i<finalIntervals.length; i++) {
            finalIntervals[i] = intersectingIntervals.get(i);
        }
        return finalIntervals;
    }
}
