package com.yoogesh.data.structure.recursion;

public class Run {

	public static void main(String[] args) {
		
		// 0   1   2   3    4   5   6   7    8
		// 0   1   1   2    3   5   8   13   21
		System.out.println((findFibonacciBasedOnAPosition(9)));
	}

	public static int findFibonacciBasedOnAPosition(int n) {
	    
		// base case
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		//hypothesis
		int result = findFibonacciBasedOnAPosition(n-1) + findFibonacciBasedOnAPosition(n-2);
		
		//induction
		return result;
	}
	
 		
}
	

