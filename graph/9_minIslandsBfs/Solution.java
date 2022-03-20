import java.util.*;

class Solution {
	
	public static void main(String...args){
		Solution sol = new Solution();
		System.out.println(sol.numIslands(
						new char[][]{
							{'1','1','0','0','0'},
							{'1','1','0','0','0'},
							{'0','0','1','0','0'},
							{'0','0','0','1','1'}
						}
					
					));
		System.out.println(sol.numIslands(
						new char[][]{
							{'1','1','0','0','0'},
							{'1','1','0','0','0'},
							{'0','0','0','0','0'},
							{'0','0','0','1','1'}
						}
					
					));
					
		System.out.println(sol.numIslands(
						new char[][]{
							{'0','0','0','0','0'}
						}
					
					));
					
		System.out.println(sol.numIslands(
						new char[][]{
							{'0','0','0','0','0'},
							{'0','1','0','0','0'},
							{'0','0','0','0','0'},
							{'0','0','0','0','0'}
						}
					));
	}


    public Integer numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        Integer minIsland = null;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                Integer islandLen = bfs(grid, visited, new int[]{i, j});
                    
                if (islandLen != null && (minIsland == null || minIsland > islandLen)) {
                	minIsland = islandLen;
                }   
            }
        }
        return minIsland;
        
    }
    
    private Integer bfs(char[][] grid, boolean[][] visited, int[] source) {
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(source);
        
        Integer length = null;
        
        while(!q.isEmpty()) {
            int[] currentNode = q.pollFirst();
            
            int i = currentNode[0];
		    int j = currentNode[1];
		    
		    boolean rowCheck = 0 <= i && i < grid.length;
	 	    boolean colCheck = 0 <= j && j < grid[0].length;
		    
		    if (!rowCheck || !colCheck) continue;
	 	    if (grid[i][j] != '1') continue;
	 	    if (visited[i][j]) continue;
	 	    visited[i][j] = true;
	 	    length = length == null ? 1 : length+1;
		 	addNeighbours(grid, currentNode, q);
        }
        
        return length;
        
        
    }
    
    private void addNeighbours(char[][] grid, int[] currentNode, Deque<int[]> q) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int i = currentNode[0];
        int j = currentNode[1];
        
        q.addLast(new int[]{i+1, j});
        q.addLast(new int[]{i, j+1});
        q.addLast(new int[]{i-1, j});
        q.addLast(new int[]{i, j-1});
                
    }
    
    
}
