/*
 * This will print the sum of the max sum sub array
 * 
 */
public class maxSumSubArray {
	
	static int max(int a,int b) {
		return a > b ? a:b;
	}
	
	static int maxSum(int a[], int l){
		int max_curr = a[0];
		int max_global = a[0];
		
		for (int i=1;i<l;i++) {
			max_curr =  max(a[i], max_curr + a[i]);
			max_global = max_curr>max_global ? max_curr: max_global;
			
		}
		
		return max_global;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2,0,1,2,3,-5,6};
		System.out.println(maxSum(a,a.length));
	}

}
