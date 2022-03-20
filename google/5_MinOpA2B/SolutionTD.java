public class SolutionTD {
	static int minInsAndDel(int[] A, int[] B, int N, int M) {
        int[][] memo = new int[N][M];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int a = N-i-1;
                int b = M-j-1;
                if (A[a] == B[b]) {
                    memo[i][j] = getVal(i-1, j-1, memo);
                }
                else {
                    memo[i][j] = Math.min(
                        getVal(i-1, j, memo),
                        getVal(i, j-1, memo)
                    ) + 1;
                }
            }
        }
        
        return memo[N-1][M-1];
        
        
    }
    
    static int getVal(int a, int b, int[][] memo) {
        if (a < 0 && b < 0) {
            return 0;
        }
        
        if (a < 0 && b >= 0) {
            return b+1;
        }
        
        if (a >= 0 && b < 0) {
            return a+1;
        }
        
        return memo[a][b];
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
