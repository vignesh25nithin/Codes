/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
			P   A   H   N
			A P L S I I G
			Y   I   R
 *And then read line by line: "PAHNAPLSIIGYIR"
 */
public class zigZagConv {
	static String convert(String s, int numRows) {
		if(s.length()<=numRows || numRows==1) {
			return s;
		}
		else {
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) 
			sb[i] = new StringBuffer();
		
		int count = 0;
		int inc = 1;
		for (int i = 0; i < s.length(); i++) {
			sb[count].append(s.charAt(i));
			if (count ==0) {
				inc = 1;
			} else if (count == numRows-1) {
				inc = -1;
			}
			count+=inc;
		}
		
		for (int i=1;i<sb.length;i++) {
			sb[0].append(sb[i]);
		}
		
		return sb[0].toString();

		}
		}

	public static void main(String[] args) {

		System.out.println(convert("PAYPALISHIRING", 4));

	}

}
