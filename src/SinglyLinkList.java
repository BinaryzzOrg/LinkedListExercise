import java.util.Scanner;

public class SinglyLinkList {

	Node head;
	Node tail;

	Scanner sc;

	//@formatter:off
	String[] promptMsg = {"Enter a number: ",
						"Enter the position of the element to be deleted: ",
						"Enter the value to be removed: "};
	
	String[] confirmasionMsg = {"The new element has been added successfully!",
						"The current elements are ",
						"The remaining elements are ",
						"Successfully deleted all the occurences of the given value!"};
	//@formatter:on

	String GetPromptMsg(int index) {
		return promptMsg[index];
	}// end method

	String GetConfirmationMsg(int index) {
		return confirmasionMsg[index];
	}// end method

	int GetUserInput(int promptMsg) {
		sc = new Scanner(System.in);
		System.out.print(GetPromptMsg(promptMsg));
		int userInput = sc.nextInt();

		return userInput;
	}// end method

	void Append() {

		// check for head
		if (!IsThisNodeAvailable(head)) {
			CreateHead();
			return;
		} // end if else

		// check for tail
		if (IsThisNodeAvailable(tail)) {
			Node newNode = new Node(GetUserInput(0));
			tail.next = newNode;
			tail = newNode;
		} else {
			CreateTail();
		} // end if else

		System.out.println(GetConfirmationMsg(0));
	}// end method

	boolean IsThisNodeAvailable(Node node) {
		if (node != null) {
			return true;
		}
		return false;
	}// end method

	void CreateHead() {
		Node headNode = new Node(GetUserInput(0));
		head = headNode;
		System.out.println(GetConfirmationMsg(0));
	}// end method

	void CreateTail() {
		Node tailNode = new Node(GetUserInput(0));
		head.next = tailNode;
		tail = tailNode;
	}// end method

	void Display() {

	}// end method

	void Delete() {

	}// end method

	void DeleteAll() {

	}// end method

	static void printLinkedList(SinglyLinkList nodeHead) {
		Node currentNode = nodeHead.head;

		System.out.print("LinkedList: ");

		while (currentNode != null) {
			System.out.print(currentNode.data + ", ");

			// go to next node
			currentNode = currentNode.next;
		} // end while
	}// end method
}
