import java.util.ArrayList;
import java.util.List;

public class printAllUniquePaths {
	public static final int M= 3;
	public static final int N =3;
	public static List<String> st = new ArrayList();
	
	
	static void path(int mat[][],int m,int n, String sb) {
		
		if(m>M-1 || n>N-1 || mat[m][n]==0 ) {
			
			return ;
		}
		if(m==M-1 && n ==N-1) {
			sb = sb+Integer.toString(mat[m][n]);
			if(!st.contains(sb)) {
				st.add(sb);
				System.out.println(sb);
			}
			
			return ;
		}
		sb = sb+Integer.toString(mat[m][n])+" ";
		
		path(mat,m+1,n,sb);
		path(mat,m,n+1,sb);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int mat[][] = { { 1, 1, 3 }, { 1, 5, 6 } ,{0,2,3}}; 
         path(mat,0,0,"");
        
	}

}
