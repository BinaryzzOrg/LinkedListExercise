
public class SinglyLinkList {

	Node head;

	public SinglyLinkList(Node head) {
		this.head = head;
	}// end constructor

	void Append() {

	}// end method

	void Display() {

	}// end method

	void Delete() {

	}// end method

	void DeleteAll() {

	}// end method

	public static void printLinkedList(SinglyLinkList nodeHead) {
		Node currentNode = nodeHead.head;

		System.out.print("LinkedList: ");

		while (currentNode != null) {
			System.out.print(currentNode.data + ", ");

			// go to next node
			currentNode = currentNode.next;
		} // end while
	}// end method
}
