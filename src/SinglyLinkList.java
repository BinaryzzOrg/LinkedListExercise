import java.util.Scanner;

public class SinglyLinkList {

	// field variables
	Scanner sc;
	private Node head;
	private Node tail;

	// Msg getter and setter
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

	void append() {

		// check for head
		if (!isThisNodeAvailable(head)) {
			createHead();
			return;
		} // end if else

		// check for tail
		if (isThisNodeAvailable(tail)) {
			Node newNode = new Node(GetUserInput(0));
			tail.setNext(newNode);
			tail = newNode;
		} else {
			CreateTail();
		} // end if else

		System.out.println(GetConfirmationMsg(0));
	}// end method

	boolean isThisNodeAvailable(Node node) {
		if (node != null) {
			return true;
		}
		return false;
	}// end method

	void createHead() {
		Node headNode = new Node(GetUserInput(0));
		head = headNode;
		System.out.println(GetConfirmationMsg(0));
	}// end method

	void CreateTail() {
		Node tailNode = new Node(GetUserInput(0));
		head.setNext(tailNode);
		tail = tailNode;
	}// end method

	void display() {

	}// end metho

	void delete() {
		System.out.print(GetPromptMsg(1));
		int position = sc.nextInt();

		if (position < 1) {
			System.out.println("try again");
			delete();
		} else if (position == 1) {
			head = head.getNext();
		} else {
			Node prev = head;
			int count = 1;
			while (count < position - 1) {
				prev = prev.getNext();
				count++;
			}
			Node current = prev.getNext();
			prev.setNext(current.getNext());
		}
	}// end method

	void deleteAll() {
		if (!isThisNodeAvailable(head)) {
			System.out.println("You don't have a list yet!");
		} else {
			int valueToBeDeleted = GetUserInput(2);
			int counterPosition = 0;
			Node currentNode = head;
			boolean isValueFound = false;
			while (currentNode != null) {
				if (currentNode.getData() == valueToBeDeleted) {
					// delete(counterPosition);
					counterPosition--;
					isValueFound = true;
				}
				counterPosition++;
				currentNode = currentNode.getNext();
			} // end while loop

			if (!isValueFound) {
				System.out.println("Value not found!");
			} else {
				System.out.println(GetConfirmationMsg(3));
			}
		} // end if else
	}// end method

	static void printLinkedList(SinglyLinkList nodeHead) {
		Node currentNode = nodeHead.head;

		System.out.print("LinkedList: ");

		while (currentNode != null) {
			System.out.print(currentNode.getData() + ", ");

			// go to next node
			currentNode = currentNode.getNext();
		} // end while
	}// end method
}
