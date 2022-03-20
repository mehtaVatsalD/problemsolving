import java.util.*;

class Solution {
	
	public static void main(String...args){
		Solution sol = new Solution();
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
                Integer islandLen = dfs(grid, visited, new int[]{i, j});
                    
                if (islandLen != null && (minIsland == null || minIsland > islandLen)) {
                	minIsland = islandLen;
                }   
            }
        }
        return minIsland;
        
    }
    
    private Integer dfs(char[][] grid, boolean[][] visited, int[] source) {
    	int i = source[0];
        int j = source[1];
    
    	boolean rowCheck = 0 <= i && i < grid.length;
 	    boolean colCheck = 0 <= j && j < grid[0].length;
 	    
 	    if (!rowCheck || !colCheck) return null;
 	    if (grid[i][j] != '1') return null;
        if (visited[i][j])return null;
        
        visited[i][j] = true;
        
        int length = 1;
        
        Integer len1 = dfs(grid, visited, new int[]{i+1, j});
        Integer len2 = dfs(grid, visited, new int[]{i, j+1});
        Integer len3 = dfs(grid, visited, new int[]{i-1, j});
        Integer len4 = dfs(grid, visited, new int[]{i, j-1});
        
        if (len1 != null) length += len1;
        if (len2 != null) length += len2;
        if (len3 != null) length += len3;
        if (len4 != null) length += len4;
        
        return length;
        
    }
    
    /*
    private void exploreNeighbours(char[][] grid, boolean[][] visited, int[] currentNode) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int i = currentNode[0];
        int j = currentNode[1];
        
        if (i+1 < rows && !visited[i+1][j] && grid[i+1][j] == '1') {
            dfs(grid, visited, new int[]{i+1, j});
        }
        
        if (j+1 < cols && !visited[i][j+1] && grid[i][j+1] == '1') {
            dfs(grid, visited, new int[]{i, j+1});
        }
        
        if (i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1') {
            dfs(grid, visited, new int[]{i-1, j});
        }
        
        if (j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1') {
            dfs(grid, visited, new int[]{i, j-1});
        }
                
    }
    */
    
    
    
}
