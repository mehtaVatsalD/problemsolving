import java.util.*;

public class MaxAreaHistogram{

    public static void main(String[] args){
        MaxAreaHistogramSolution solution = new MaxAreaHistogramSolution();
        int[] a = {2, 1, 3, 4, 0, 1, 2, 3};
        System.out.println(solution.largestRectangleArea(a));
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