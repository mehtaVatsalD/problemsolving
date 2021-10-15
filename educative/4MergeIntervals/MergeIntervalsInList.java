import java.util.*;

class Interval {
	int start;
	int end;
	
	Interval (int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return "[" + start + ", " + end +"]";
	}
}

class IntervalComparator implements Comparator<Interval> {

	public int compare(Interval interval1, Interval interval2) {
		return interval1.start - interval2.start;
	}	
}

public class MergeIntervalsInList {

	public static void main(String...args) {
		mergeIntervals(Arrays.asList(
			new Interval(6, 7),
			new Interval(2, 4),
			new Interval(5, 9)
		));
		
		mergeIntervals(Arrays.asList(
			new Interval(1, 4),
			new Interval(2, 6),
			new Interval(3, 5)
		));
		
		mergeIntervals(Arrays.asList(
			new Interval(1, 4),
			new Interval(2, 5),
			new Interval(7, 9)
		));
		
		System.out.println(areOverlapping(Arrays.asList(
			new Interval(1, 4),
			new Interval(2, 5),
			new Interval(7, 9)
		)));
		
		System.out.println(areOverlapping(Arrays.asList(
			new Interval(1, 3),
			new Interval(11, 15),
			new Interval(4, 7)
		)));
		
	}


	private static List<Interval> mergeIntervals(List<Interval> intervals) {
	
		List<Interval> merged = new ArrayList<>();

		
		intervals.sort(new IntervalComparator());
		for(int i=0; i<intervals.size(); i++) {
			
			if(i == intervals.size()-1 || intervals.get(i).end < intervals.get(i+1).start) {
				merged.add(intervals.get(i));
				continue;
			}
			int start = intervals.get(i).start;
			int maxEnd = intervals.get(i).end;
			while(i<intervals.size()-1 && maxEnd >= intervals.get(i+1).start) {
				
				if(intervals.get(i+1).end > maxEnd) {
					maxEnd = intervals.get(i+1).end;
				}
				i++;
			}
			merged.add(new Interval(start, maxEnd));
			
		}
		System.out.println(merged);
		return merged;
	}
	
	private static boolean areOverlapping(List<Interval> intervals) {
		intervals.sort(new IntervalComparator());
		for(int i=0; i<intervals.size()-1; i++) {
			if(intervals.get(i).end < intervals.get(i+1).start) {
				continue;
			}
			return true;
		}
		return false;
	}

}
