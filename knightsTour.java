
public class knightsTour {
	static int N = 8;
	 int num =0;
	 int grid[][] = new int[N][N];
	
	void print(int grid[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("");
	
	}
	
	int nextX(int x,int move) {
		if(move==0 || move==3 )
			x= x+1;
		else if(move==1 || move==2 )
			x=x+2;
		else if (move==4 || move==7)
			x= x-1;
		else if ( move==5 || move==6)
			x= x-2;
		
		
		if(x<0 ||x>7)
			x =-1;
		return x;
	}
	int nextY(int y,int move) {
		if(move==0  || move==7 )
			y= y-2;
		else if(move==1 || move==6 )
			y=y-1;
		else if (move==4 || move==3)
			y=y+2;
		else if ( move==5 || move==2 )
			y=y+1;
		
		if(y<0 || y>7)
			y =-1;
		return y;
	}
	
	
	boolean solve(int x,int y, int num) {
		int move=0;
		if(num==64) {
			return true;
		}
		if(grid[x][y]==0) {
		while(move<N) {
			if(nextX(x, move)!=-1 && nextY(y, move)!=-1)
				{grid[x][y]=num;
				if(solve(nextX(x, move),nextY(y, move),num+1))
					return true;
				
				grid[x][y]=0;
				
				}
				move++;
				
		}
		}
		
		return false;
	}
	
	public void solveCall(){		
		print(grid);
		solve(0,0,0);
		print(grid);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knightsTour cal = new knightsTour();
		cal.solveCall();
	}

}
