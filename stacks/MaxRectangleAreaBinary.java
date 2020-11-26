import java.util.*;

public class MaxRectangleAreaBinary{

    public static void main(String[] args){
        int[][] M = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        MaxBinaryRectangleSolution solution = new MaxBinaryRectangleSolution();
        System.out.println(solution.maxArea(M, M.length, M[0].length));
    }


}

class MaxBinaryRectangleSolution {
    public int maxArea(int M[][], int m, int n) {
        int[] ea = new int[M[0].length];
        int area, maxArea = 0;
        MaxAreaHistogramSolution sol = new MaxAreaHistogramSolution();
        for(int i=0;i<M.length;i++){
            getNextUpdatedRow(M, i, ea);
            area = sol.largestRectangleArea(ea);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;

    }

    private void getNextUpdatedRow(int M[][], int row, int a[]){
        for(int i=0;i<M[row].length;i++){
            if(M[row][i] == 0){
                a[i] = 0;
            }
            else{
                a[i] += 1;
            }
        }
    }
}

class MaxAreaHistogramSolution {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        Integer e;
        int i;
        int lastWall = 0; //this is to prevent if any 0 height row comes in between
        for(i=0;i<heights.length;i++){
            e = stack.peekLast();
            //if height of current bar is zero then pop all and calculate area
            if (heights[i] == 0){
                maxArea = popUnitlSatified(stack, maxArea, i, heights, true, lastWall);
                lastWall = i + 1;
            }
            //stack is empty or height at top of stack is lower
            else if(e == null || heights[e] <= heights[i]){
                stack.addLast(i);
            }
            //height at top of stack is higher
            else if(heights[e] > heights[i]){
                maxArea = popUnitlSatified(stack, maxArea, i, heights, false, lastWall);
                i--;
            }
        }
        maxArea = popUnitlSatified(stack, maxArea, i, heights, true, lastWall);
        return maxArea;
    }

    private int popUnitlSatified(Deque<Integer> stack, int maxArea, int i, int[] heights, boolean allClean, int lastWall){
        Integer e;
        Integer eStillTop;
        int area;
        do{
            e = stack.peekLast();
            if(e != null && (allClean || heights[e] > heights[i])){
                e = stack.removeLast();
                eStillTop = stack.peekLast();
                if(eStillTop == null){
                    area = heights[e] * (i - lastWall);
                }
                else{
                    area =  heights[e] * (i - eStillTop - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }while(e != null && (allClean || heights[e] > heights[i]));
        return maxArea;
    }

}