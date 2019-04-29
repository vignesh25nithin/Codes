
public class nQueenProb {
	static final int N = 8;
	
	void print(int board[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	boolean isSafe(int board[][],int row,int col) {
		int i,j;
		
		for(i=0;i<col;i++) {
			if(board[row][i]==1)
				return false;
		}
		for(i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		for(i=row,j=col;i<N && j>=0;i++,j--) {
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	
	
	boolean solveUtil(int board[][],int col) {
		if(col==N) {
			print(board);
			System.out.println("       ");
			return true;
		}
			
		
		boolean result = false;
		
		for(int i=0;i<N;i++) {
			
			if(isSafe(board,i,col)) {
				board[i][col] =1;
				
				result = solveUtil(board,col+1) || result;
			
				board[i][col]=0;
			}
			
			
		}
		
		return result;
	}
	
	void solveMaze() {
	
		int board[][] = {  {0, 0, 0, 0,0, 0, 0, 0}, 
	            {0, 0, 0, 0,0, 0, 0, 0}, 
	            {0, 0, 0, 0,0, 0, 0, 0}, 
	            {0, 0, 0, 0,0, 0, 0, 0},
	            {0, 0, 0, 0,0, 0, 0, 0},
	            {0, 0, 0, 0,0, 0, 0, 0},
	            {0, 0, 0, 0,0, 0, 0, 0},
	            {0, 0, 0, 0,0, 0, 0, 0},}; 
		
		if(solveUtil(board,0) ==false){
			System.out.println("no sol");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nQueenProb n = new nQueenProb();
		n.solveMaze();
		
	}

}