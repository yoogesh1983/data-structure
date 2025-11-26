package com.yoogesh.data.structure.Queue.DeQueue;

public class ArrayDeQueue {

	int DQ[];
	int front;
	int rear;
	int size;

	public ArrayDeQueue() {
		front = -1;
		rear = -1;
		size = 5;
		DQ = new int[size];
	}

	public void insertAtFront(int value) {
		if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
			System.out.println("De-Queue is full");
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			front = size - 1;
		} else {
			front = front - 1;
		}
		DQ[front] = value;
	}

	public void insertAtRear(int value) {
		if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
			System.out.println("De-Queue is full");
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			rear = 0;
		} else {
			rear = rear + 1;
		}
		DQ[rear] = value;
	}

	public void deleteFromFront() {
		if (front == -1) {
			System.out.println("DeQue is empty");
			return;
		}
		System.out.println("Deleted item is: " + DQ[front]);
		if (front == rear) {
			front = rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}

	}

	public void deleteFromRear() {
		if(front == -1) {
			System.out.println("DeQue is empty");
			return;
		}
		System.out.println("Deleted item is: " + DQ[front]);
		if(front == rear) {
			front = rear = -1;
		} else {
			if(rear == 0) {
				rear = size-1;
			} else {
				rear = rear-1;
			}
		}
	}

	public void display() {
		if(front == -1) {
			System.out.println("DeQue is empty");
			return;
		}
		int left = front;
		int right = rear;
		
		if(left <= right) {
			while(left <= right) {
				System.out.print(DQ[left] + " ");
				left++;
			}
		} else {
			while(left <= size-1) {
				System.out.print(DQ[left] + " ");
				left++;
			}
			left=0;
			while(left <= right) {
				System.out.print(DQ[left] + " ");
				left++;
			}
		}
		System.out.println();
	}

}
