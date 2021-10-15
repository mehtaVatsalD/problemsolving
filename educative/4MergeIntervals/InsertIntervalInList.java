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

public class InsertIntervalInList {

	public static void main(String...args) {
		insertInterval(Arrays.asList(
			new Interval(1, 3),
			new Interval(5, 7),
			new Interval(8, 12)
		),
		new Interval(4, 6));
		
		insertInterval(Arrays.asList(
			new Interval(1, 3),
			new Interval(5, 7),
			new Interval(8, 12)
		),
		new Interval(4, 10));
		
		insertInterval(Arrays.asList(
			new Interval(2, 3),
			new Interval(5, 7)
		),
		new Interval(1, 4));
		
	}


	private static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
	
		List<Interval> newIntervals = new ArrayList<>();
		//intervals.sort(new IntervalComparator()); -- assuming list will already be sorted based on start of interval
		
		//find postion for new interval
		int i=0;
		while(i<intervals.size() && newInterval.start > intervals.get(i).end) {
			newIntervals.add(intervals.get(i++));
			
		}
		//i will have position to add 
		if(i == intervals.size()) {
			newIntervals.add(newInterval);
			System.out.println(newIntervals);
			return newIntervals;
		}
		
		//check for all possible merge
		int start = Math.min(newInterval.start, intervals.get(i).start);
		int maxEnd = Math.max(newInterval.end, intervals.get(i).end);
		i++;
		while(i<intervals.size() && maxEnd >= intervals.get(i).start) {
			if(maxEnd < intervals.get(i).end) {
				maxEnd = intervals.get(i).end;
			}
			i++;
		}
		newIntervals.add(new Interval(start, maxEnd));
		
		//add remaining ones
		while(i<intervals.size()) {
			newIntervals.add(intervals.get(i++));
		}
		System.out.println(newIntervals);
		return newIntervals;
	}

}
