/*
 * find the path from start(0,0) to end(N,N) 
 * move only forward and down 
 */

class Maze {
	public static int N = 5;

	static boolean getPath(int M[][], int x, int y, int sol[][]) {

		if (x == N - 1 && y == N - 1 && M[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		if (x >= 0 && x <= N - 1 && y >= 0 && y <= N - 1 && M[x][y] == 1 && sol[x][y]==0) {
			sol[x][y] = 1;

			if (getPath(M, x + 1, y, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------1");
				printMatrix(sol);
				return true;
			}

			if ( getPath(M, x, y - 1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------2");
				printMatrix(sol);
				return true;
			}
			if ( getPath(M, x, y + 1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------3");
				printMatrix(sol);
				return true;
			}

			if (getPath(M, x - 1, y, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------4");
				printMatrix(sol);
				return true;
			}

			if (getPath(M, x + 1, y+1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------5");
				printMatrix(sol);
				return true;
			}
			if (getPath(M, x + 1, y-1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------6");
				printMatrix(sol);
				return true;
			}
			if (getPath(M, x - 1, y+1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------7");
				printMatrix(sol);
				return true;
			}
			if (getPath(M, x - 1, y-1, sol) == true) {
				System.out.println("XXXXXXXXXXX--------------8");
				printMatrix(sol);
				return true;
			}
			sol[x][y] = 0;

			return false;
		}

		return false;
	}

	static void findpath(int M[][]) {
		int sol[][] = new int[N][N];

		if (getPath(M, 0, 0, sol)) {
			System.out.println("path exists");
			printMatrix(sol);
		} else {
			System.out.println("path doesn't exist");
			printMatrix(sol);
		}

	}

	// Utility function to print a matrix
	static void printMatrix(int matrix[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}

	// Driver code
	public static void main(String[] args) {
		try {
			int M[][] ={{ 1, 0, 1, 1, 1 }, 
						{ 0, 1, 0, 1, 1 }, 
						{ 1, 0, 1,0 , 1}, 
						{ 0, 1, 1, 0, 1 },
						{ 0, 0, 0, 0, 1 } };
			// System.out.print("Given matrix is \n");

			findpath(M);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
