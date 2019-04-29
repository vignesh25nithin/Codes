import java.util.ArrayList;
import java.util.List;

public class permutations {
	public  List<String> st = new ArrayList();

	static String swap(char s[], int m, int n, int len) {

		char temp;
		if (m <= len && n <= len) {
			temp = s[m];
			s[m] = s[n];
			s[n] = temp;

		}
		
		return String.valueOf(s);

	}

	static void pred(String perm, int m, int len) {
		if(len == m) {
			System.out.println(perm);
			}
		
		for(int i=m;i<=len;i++) {
			perm = swap(perm.toCharArray(),m,i,len);
			pred(perm, m + 1,len);
			perm = swap(perm.toCharArray(),m,i,len);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String perm = "abc";
		pred(perm, 0, perm.length()-1);

	}

}
