package com.yoogesh.data.structure.Stack;

import java.util.Stack;

public class StackPreDefined {

	public static int getPrecedence(char ch) {
		if (ch == '*' || ch == '/') {
			return 2;
		}
		if (ch == '+' || ch == '-') {
			return 1;
		}
		return -1;
	}

	public static String infixToPostFix(String val) {
		String output = "";
		Stack<Character> ss = new Stack<>();
		for (int i = 0; i < val.length(); i++) {
			char ch = val.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				output += ch;
			} else if (ch == '(') {
				ss.push(ch);
			} else if (ch == ')') {
				while (!ss.isEmpty() && ss.peek() != '(') {
					output += ss.pop();

				}
				ss.pop();
			} else {
				while (!ss.isEmpty() && getPrecedence(ch) <= getPrecedence(ss.peek())) {
					output += ss.pop();
				}
				ss.push(ch);
			}
		}

		while (!ss.empty()) {
			output += ss.pop();
		}
		return output;
	}

	public static int evalPostFix(String val) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < val.length(); i++) {
			char ch = val.charAt(i);
			if (Character.isDigit(ch)) {
				stack.push(ch - '0'); // ASCII value of '0' is 48 which means if '2' = 50 - 48 = 2
			} else {
				int v1 = stack.pop();
				int v2 = stack.pop();
				switch (ch) {
				case '+': {
					stack.push(v2 + v1);
					break;
				}
				case '-': {
					stack.push(v2 - v1);
					break;
				}
				case '*': {
					stack.push(v2 * v1);
					break;
				}
				case '/': {
					stack.push(v2 / v1);
					break;
				}
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(evalPostFix(infixToPostFix("2+3"))); // 5
	}
}
