import java.util.Scanner;

/* Problem statement
		 * On a positive integer, you can perform any one of the following 3 steps. 
		 * 1.) Subtract 1 from it. ( n = n - 1 )  , 
		 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
		 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). 
		 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
		 * eg: 
		 * 1.)For n = 1 , output: 0       
		 * 2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    
		 * 3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
		 *
		 */
public class minStepsToReachOne {
	
	static int min(int val1,int val2) {
		int val = val1>val2? val2 : val1;
		return val;
	}

	static int minSteps(int num) {
		
		int[] solved = new int[num+1]; 
		solved[1]=0;
		
		for(int i=2;i<=num;i++) {
			solved[i] = 1 + solved[i-1];
			
			if(i%2==0)
				solved[i] = min(solved[i],1+solved[i/2]);
			if(i%3==0)
				solved[i] = min(solved[i],1+solved[i/3]);
		}
		
		
		
		
		return solved[num];
		
	}
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int num = obj.nextInt();
		System.out.println("min no. of steps to reach one");
		System.out.println(minSteps(num));
		
	}

}
