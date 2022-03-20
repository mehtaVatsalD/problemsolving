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
                    bfs(grid, visited, new int[]{i, j});
                    islands++;
                }
                
                
            }
        }
        return islands;
        
    }
    
    private void bfs(char[][] grid, boolean[][] visited, int[] source) {
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(source);
        visited[source[0]][source[1]] = true;
        
        while(!q.isEmpty()) {
            int[] currentNode = q.pollFirst();
            addNeighbours(grid, visited, currentNode, q);
        }
        
        
    }
    
    private void addNeighbours(char[][] grid, boolean[][] visited, int[] currentNode, Deque<int[]> q) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int i = currentNode[0];
        int j = currentNode[1];
        
        if (i+1 < rows && !visited[i+1][j] && grid[i+1][j] == '1') {
            visited[i+1][j] = true;
            q.addLast(new int[]{i+1, j});
        }
        
        if (j+1 < cols && !visited[i][j+1] && grid[i][j+1] == '1') {
            visited[i][j+1] = true;
            q.addLast(new int[]{i, j+1});
        }
        
        if (i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1') {
            visited[i-1][j] = true;
            q.addLast(new int[]{i-1, j});
        }
        
        if (j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1') {
            visited[i][j-1] = true;
            q.addLast(new int[]{i, j-1});
        }
                
    }
    
    
}
