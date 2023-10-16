import java.util.Scanner;

public class SinglyLinkList {

	Node head;
	Node tail;

	Scanner sc;

	public SinglyLinkList(Node head) {
		this.head = head;
	}// end constructor

	void Append() {
		sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int userInput = sc.nextInt();

		Node newNode = new Node(userInput);

		Node tempNode = head;
		if (tempNode.next != null) {
			tail.next = newNode;
		} else {
			tempNode.next = newNode;
		}

		System.out.println("The new element has been added successfully!");
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
