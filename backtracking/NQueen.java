import java.util.*;

public class NQueen{

	class Pos{
		public int x;
		public int y;

		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	private boolean isUnderAttack(Pos positions[], Pos positionToCheck, int maxRow){
		for(int i=0;i<maxRow;i++){
			//check row
			if(positions[i].x == positionToCheck.x){
				return true;
			}
			//check column
			else if(positions[i].y == positionToCheck.y){
				return true;
			}
			else if((positions[i].x + positions[i].y) == (positionToCheck.x + positionToCheck.y)){
				return true;
			}
			else if((positions[i].x - positions[i].y) == (positionToCheck.x - positionToCheck.y)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		NQueen nQueen = new NQueen();
		nQueen.solve();
	}

	private void solve(){
		Scanner scan = new Scanner(System.in);
		int n = Integer.valueOf(scan.nextLine());
		Pos[] positions = new Pos[n];
		int solution = doNQueenArrangement(positions, 0, n);
		if (solution == 0) {
			System.out.println("Cannot solve!");
		}
		else{
			System.out.println("Total Solutions: " + solution);
		}
	}


	private int doNQueenArrangement(Pos positions[], int currRow, int n){
		Pos newPosition;
		int solutions = 0;
		int solutionPossible = 0;
		if(currRow == n){
			printBoard(n, positions);
			return 1;
		}
		for(int i=0;i<n;i++){
			newPosition = new Pos(currRow, i);
			if (!isUnderAttack(positions, newPosition, currRow)) {
				positions[currRow] = newPosition;
			}
			else{
				continue;
			}
			solutions = doNQueenArrangement(positions, currRow + 1, n);

			if (solutions == 0) {
				positions[currRow] = null;
			}
			else{
				solutionPossible += solutions;
			}
		}
		return solutionPossible;
	}

	private void printBoard(int n, Pos positions[]){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(j == positions[i].y){
					System.out.print("1");
				}
				else{
					System.out.print("0");	
				}
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
	}

}