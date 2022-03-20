import java.util.*;

public class Test{

	public static void main(String...args) {
		Set<int[]> set = new HashSet<>();
		set.add(new int[]{1, 2});

		System.out.println(set.contains(new int[]{1, 2}));
	}
	
}
