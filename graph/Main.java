import java.util.*;
class Main {
  
  	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
      	int n = scan.nextInt();
      	int i=0;
      	int[][] points = new int[n][2];
      	while(i<n) {
          points[i][0] = scan.nextInt();
          points[i][1] = scan.nextInt();
          i++; 
        }
      	System.out.println(new Main().minCostConnectPoints(points));
    }
    
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] v = new boolean[n];
        int eu = 0;
        
        int[] minwt = new int[n];
        Arrays.fill(minwt, Integer.MAX_VALUE);
        
        minwt[0] = 0;
        int sum = 0;
        while(eu<n) {
            int min = Integer.MAX_VALUE;
            int node = 0;
            for (int i=0; i<n; i++) {
                if (!v[i] && min > minwt[i]) {
                    min = minwt[i];
                    node = i;
                }
            }
            
            sum += min;
            v[node] = true;
            eu++;
            
            for (int i=0; i<n; i++) {
                if (i == node) continue;
                int md = getMD(points[node], points[i]);
                if (minwt[i] > md) {
                    minwt[i] = md;
                }
            }   
        }
        return sum;
        
    }
    
    private int getMD(int[] p1, int[] p2) {
        return Math.min(Math.abs(p1[0] - p2[0]),  Math.abs(p1[1] - p2[1]));
    }
    
}
