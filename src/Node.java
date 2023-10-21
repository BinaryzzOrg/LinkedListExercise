
public class Node {

	// field variables
	private int data; //store the value
	private Node next;//store the next node address

	// constructor
	Node(int data) {
		this.data = data;
		this.next = null;
	}// end constructor

	// getter and setters
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

	//method that displays the data
	void displayData() {
		System.out.print("[" + data + "|next]->");
	}

}// end class
