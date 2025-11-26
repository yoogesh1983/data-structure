package com.yoogesh.data.structure.Stack;

public class StackArray {

	int size = 5;
	int[] data;
	int top = -1;

	StackArray() {
		data = new int[size];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int getSize() {
		return top + 1;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		for (int i = 0; i <= top; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public void push(int value) {
		if (getSize() == data.length) {
			System.out.println("Stack reached to its maximum capacity of " + getSize());
		} else {
			top++;
			data[top] = value;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			int value = data[top];
			top--;
			return value;
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return data[top];
		}
	}
	
	public boolean search(int value) {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return false;
		}
		for(int next: data) {
			if(next == value) {
				return true;
			}
		}
		return false;
	}
}
