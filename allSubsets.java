
public class allSubsets {

	static void printAll(String s_,int start,int end,int l) {
		if(start >= 0 && end <l && start<l && end>=0) 
		{
		for(int i =start;i<=end;i++) {
			System.out.print(s_.charAt(i));
		}
		System.out.println("");
		}
	}

	static boolean subsets(String s, int st, int e) {
		final int len = s.length();
		if (st > len - 1 || e > len - 1) {
			return false;
		}
		

		printAll(s, st, e,len);
		if (subsets(s, st, e + 1)) {

			return true;
		}
		e=st+1;
		if (subsets(s, st + 1, e)) {

			return true;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s = "abcd";

			if (subsets(s, 0, 0)) {
				System.out.println("subset values are printed");
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
