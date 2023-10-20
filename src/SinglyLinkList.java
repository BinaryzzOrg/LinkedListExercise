import java.util.Scanner;

public class SinglyLinkList {

	// field variables
	Scanner sc;

	private Node head;

	Node getHead() {
		return this.head;
	}// end method

	private Node tail;
	int numElements = 0;

	// Msg getter and setter
	//@formatter:off
	String[] promptMsg = {"\nEnter a number: ",
						"\nEnter the position of the element to be deleted: ",
						"\nEnter the value to be removed: "};
	
	String[] confirmasionMsg = {"The new element has been added successfully!",
						"\nThe current elements are: ",
						"The remaining elements are: ",
						"Successfully deleted all the occurences of the given value!"};
	
	String[] errorMsg = {"\n {Invalid Input!!}",
						"\n {Linkedlist is empty!!}",
						"\n {Invalid Position!!}",
						"\n {You don't have a list yet!!}",
						"\n {Value not found!!}"};
	//@formatter:on

	String GetPromptMsg(int index) {
		return promptMsg[index];
	}// end method

	String GetConfirmationMsg(int index) {
		return confirmasionMsg[index];
	}// end method

	String GetErrorMsg(int index) {
		return errorMsg[index];
	}// end method

	int GetUserInput(int promptMsg) {

		sc = new Scanner(System.in);
		System.out.print(GetPromptMsg(promptMsg));

		// checks for other kind of input
		if (!sc.hasNextInt()) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if
		int userInput = sc.nextInt();

		return userInput;
	}// end method

	// overload
	int GetUserInput() {

		sc = new Scanner(System.in);

		// checks for other kind of input
		if (!sc.hasNextInt()) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if

		// check if input is on menu
		int userInput = sc.nextInt();
		if (!validateInput(userInput)) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if

		return userInput;
	}// end method

	boolean validateInput(int input) {

		// check if input is on menu 0-4
		if (input < 0 || input > 4) {
			// if if its outside the menu choices
			System.out.println(GetErrorMsg(0));
			return false;
		} // end method

		return true;
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
			numElements++;
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
		numElements++;
	}// end method

	void CreateTail() {
		Node tailNode = new Node(GetUserInput(0));
		head.setNext(tailNode);
		tail = tailNode;
		numElements++;
	}// end method

	void display() {
		// check if the head has value
		if (head == null) {
			System.out.println(GetErrorMsg(1));
			return;
		}
		Node currentNode = head;
		System.out.print(GetConfirmationMsg(1));

		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}

		System.out.println();
	}// end method

	void delete(int position) {

		System.out.println(position);
		if (position < 1 || position > numElements) {
			System.out.println(GetErrorMsg(2));
			Main.DisplayMenu(Main.linkList);
			delete(sc.nextInt());

		} else if (position == 1) {
			head = head.getNext();

		} else {
			Node prev = head;
			int count = 1;
			while (count < position - 1) {
				prev = prev.getNext();
				count++;
			} // end while

			Node current = prev.getNext();
			prev.setNext(current.getNext());
			if (position == numElements) {
				tail = prev;
			} // end if
			numElements--;

		} // end method
	}// end method

	void deleteAll() {

		if (!isThisNodeAvailable(head)) {
			System.out.println(GetErrorMsg(3));
		} else {

			int valueToBeDeleted = GetUserInput(2);
			int counterPosition = 1;

			Node currentNode = head;
			boolean isValueFound = false;
			while (currentNode != null) {

				if (currentNode.getData() == valueToBeDeleted) {
					delete(counterPosition);
					counterPosition--;
					isValueFound = true;
				} // end if
				counterPosition++;
				currentNode = currentNode.getNext();

			} // end while loop

			if (!isValueFound) {
				System.out.println(GetErrorMsg(4));
			} else {
				System.out.println(GetConfirmationMsg(3));

			} // end if else
		} // end if else

	}// end method

}// end class
