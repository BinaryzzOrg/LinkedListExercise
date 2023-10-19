
public class Node {
	// field variable
	private int data;
	private Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}// end constructor

	int getData() {
		return this.data;
	}// end method

	void setData(int data) {
		this.data = data;
	}// end method

	Node getNext() {
		return this.next;
	}// end method

	Node setNext(Node next) {
		return this.next = next;
	}// end method

}// end class
