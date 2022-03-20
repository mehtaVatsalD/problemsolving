import java.util.*;

public class SolutionMemo {

	static int minInsAndDel(int[] A, int[] B, int N, int M) {
        int[][] memo = new int[N][M];
        
        for(int[] memoRow: memo) {
            Arrays.fill(memoRow, -1);
        }
        
        return minInsAndDel(A, B, 0, 0, memo);
        
        
    }
    
    static int minInsAndDel(int[] A, int[] B, int a, int b, int[][] memo) {
        
        if (a >= A.length && b >= B.length) {
            return 0;
        }
        
        if (a >= A.length && b < B.length) {
            return B.length - b;
        }
        
        if (b >= B.length && a < A.length) {
            return A.length - a;
        }
        
        if (memo[a][b] != -1) {
            return memo[a][b];
        }
        
        int val;
        if (A[a] == B[b]) {
            val = minInsAndDel(A, B, a+1, b+1, memo);
        }
        else {
            int delOp = minInsAndDel(A, B, a+1, b, memo) + 1;
            int addOp = minInsAndDel(A, B, a, b+1, memo) + 1;
            val = Math.min(delOp, addOp);
        }
        

        
        
        memo[a][b] = val;
        
        return memo[a][b];
        
        
    }
    
}
