package com.yoogesh.data.structure.Queue.DeQueue;

public class Main {

	public static void main(String[] args) {
		
		LinkedListDeQueue dq = new LinkedListDeQueue();
		dq.insertAtRear(111);
		dq.insertAtRear(222);
		dq.insertAtRear(333);
		dq.display();
		dq.insertAtFront(777);
		dq.insertAtFront(888);
		dq.display();
		dq.deleteFromFront();
		dq.display();
		dq.deleteFromRear();
		dq.display();
	}

}
