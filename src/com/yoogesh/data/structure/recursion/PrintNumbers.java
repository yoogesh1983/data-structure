package com.yoogesh.data.structure.recursion;

public class PrintNumbers {

	public static void main(String[] args) {
		printNumbers(5);
	}

	public static void printNumbers(int n) {  //BHI Approach

		// base condition
		if (n == 0) {
			return;
		}

		// hypothesis
		printNumbers(n - 1);

		// induction
		System.out.println(n);
	}

}
