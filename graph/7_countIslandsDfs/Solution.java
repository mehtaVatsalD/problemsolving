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
	}


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        int islands = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                
                
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, new int[]{i, j});
                    islands++;
                }
                
                
            }
        }
        return islands;
        
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int[] source) {
    	int i = source[0];
        int j = source[1];
    
    	boolean rowCheck = 0 <= i && i < grid.length;
 	    boolean colCheck = 0 <= j && j < grid[0].length;
 	    
 	    if (!rowCheck || !colCheck) return;
 	    if (grid[i][j] != '1') return;
        if (visited[i][j])return;
        
        visited[i][j] = true;
        
        dfs(grid, visited, new int[]{i+1, j});
        dfs(grid, visited, new int[]{i, j+1});
        dfs(grid, visited, new int[]{i-1, j});
        dfs(grid, visited, new int[]{i, j-1});
        
        
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
