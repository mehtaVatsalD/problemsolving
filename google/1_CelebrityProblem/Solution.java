public class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	int i=0;
    	int j=n-1;
    	
    	while(i<j) {
    	    if (M[i][j] == 1) {
    	        i++;
    	    }
    	    else {
    	        j--;
    	    }
    	}
    	
    	int potentialCeleb = i;
    	
    	return isCelebrity(potentialCeleb, M, n) ? potentialCeleb : -1;
    	
    }
    
    private boolean isCelebrity(int index, int[][] M, int n) {
        for (int i=0; i<n; i++) {
            if (i == index) {
                continue;
            }
            
            if (M[i][index] == 0 || M[index][i] == 1) {
                return false;
            }
            
        }
        return true;
    }
}
