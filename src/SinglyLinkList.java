import java.util.Scanner;

public class SinglyLinkList {

	// field variables
	Scanner sc;
	private Node head; // serve as the firstNode
	private Node tail; // serve as the lastNode, used later to achieve appending
	int numElements = 0; //counter to track total size of elements(nodes) inside the list

	// head getter
	Node getHead() {
		return this.head;
	}// end method

	// Msg getter and setter
	//@formatter:off

	/*
	 * arrays primary used to prompt diff msg based on what specific input needed
	 * promptMsg = Prompts that asked inputs
	 * confirmationMsg = Prompts that provides an update on specific operation performed
	 * errorMsg = Prompts that provides error msg for invalid input or process user performed
	 */
	String[] promptMsg = {"\nEnter a number: ",
						"\nEnter the position of the element to be deleted: ",
						"\nEnter the value to be removed: "};

	String[] confirmationMsg = {"The new element has been added successfully!",
						"\nThe current elements are: ",
						"The remaining elements are: ",
						"Successfully deleted all the occurences of the given value!"};

	String[] errorMsg = {"\n {Invalid Input!!}",
						"\n {Linkedlist is empty!!}",
						"\n {Invalid Position!!}",
						"\n {You don't have a list yet!!}",
						"\n {Value not found!!}"};
	//@formatter:on
	//method to return a prompt message based on given index
	String GetPromptMsg(int index) {
		return promptMsg[index];
	}// end method
	//method to return a confirmation message based on given index
	String GetConfirmationMsg(int index) {
		return confirmationMsg[index];
	}// end method
	//method to return a error message based on given index
	String GetErrorMsg(int index) {
		return errorMsg[index];
	}// end method

	/*
	 * Method that checks if user inputted an int integer
	 * takes a scanner obj argument
	 */
	void catchOtherDataType(Scanner validate) {
		//validates if user inputted a data type corresponds to what the interface shown
				if (!validate.hasNextInt()) {
					System.out.println(GetErrorMsg(0));
					Main.DisplayMenu(Main.linkList);
				} // end if
	}

	int GetUserInput(int promptMsg) {
		//create a scanner obj
		sc = new Scanner(System.in);

		// call promptMsg array of specified index
		System.out.print(GetPromptMsg(promptMsg));
		//call to check other data type
		catchOtherDataType(sc);

		//if classified as an integer input store it to a int var
		int userInput = sc.nextInt();
		//return the input
		return userInput;
	}// end method

	// overload
	int GetUserInput() {

		sc = new Scanner(System.in);
		//call to check other data type
		catchOtherDataType(sc);

		// check if input is on menu
		int userInput = sc.nextInt();
		if (!validateInput(userInput)) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if

		return userInput;
	}// end method

	/*
	 * Method that validates whether an index passed the given ranges of accepted numbers
	 * takes an int argument
	 */
	boolean validateInput(int input) {

		// check if input is on menu 0-4
		if (input < 0 || input > 4) {
			// if if its outside the menu choices
			System.out.println(GetErrorMsg(0));
			return false;
		} // end method

		return true;
	}// end method

	/*
	 * Method that adds an element at the last (append)
	 * has a #head (firstLink) #tail (lastLink) obj that tracks the firstnode and the last
	 */
	void append() {

		// check for head
		if (!isThisNodeAvailable(head)) {
			//create the first node
			createHead();
			return;
		} // end if else

		// check for tail
		if (isThisNodeAvailable(tail)) {
			//create a new link
			Node newNode = new Node(GetUserInput(0));
			//set the next address to the new link
			tail.setNext(newNode);
			//make the newly connected node to be the tail
			tail = newNode;
			//on which updates the number of elements
			numElements++;
		} else {
			//create the first tail node
			CreateTail();
		} // end if else

		System.out.println(GetConfirmationMsg(0));
	}// end method

	/*
	 * Method that validates if a node obj had a value or not
	 * takes an argument of an obj
	 */
	boolean isThisNodeAvailable(Node node) {
		return (node != null);
	}// end method

	/*
	 * method that creates the firstnode
	 * counter that increases if a head node is created
	 */
	void createHead() {
		//create a node that holds a value
		Node headNode = new Node(GetUserInput(0));
		//store the new node to the head
		head = headNode;
		//promts append message
		System.out.println(GetConfirmationMsg(0));
		//increments (indicates a newly added node)
		numElements++;
	}// end method

	/*
	 * method that creates the lastnode
	 * counter that increases whenever a new element created (append)
	 */

	void CreateTail() {
		//create a node that holds a value
		Node tailNode = new Node(GetUserInput(0));
		//set the next address of head to the lastNode
		head.setNext(tailNode);
		//make the newly connected node to be the tail
		tail = tailNode;
		//create the first tail node which is in the current position of the head
		numElements++;
	}// end method

	//simple method that returns the end of list indicator (NULL)
	String returnAbsenseofData() {
		return null;
	}
	/*
	 * Method that displays the nodes
	 * currentNode serves as the the current link
	 * displayData is a method from the Node class that display data
	 * returnAbsenseofData is a string return type method which prints the end of list indicator
	 */

	void display(int confirmationMsgIndex) {
		// check if the head has value
		if (head == null) {
			System.out.println(GetErrorMsg(1));
			return;
		}
		//create a node which traverse through the link
		Node currentNode = head;
		//promtpt msg
		System.out.print(GetConfirmationMsg(confirmationMsgIndex));

		//traverse until it gets to the end of list
		while (currentNode != null) {
			//call the displaydata method
			currentNode.displayData();
			//updates the currentNode to the another node in order to perform the traversing
			currentNode = currentNode.getNext();
		}
		//prints the end of list indicator
		System.out.print(returnAbsenseofData());
		//newline
		System.out.println();
	}// end method


	/*
	 * Method that deletes a certain node by finding the corresponding index
	 * current = serve as the node to be deleted
	 * prev = node that is before the current
	 */

	void delete(int position) {

		if (position < 1 || position > numElements) {
			System.out.println(GetErrorMsg(2));
			Main.DisplayMenu(Main.linkList);
			delete(sc.nextInt());
		//the firstNode is the one that is being deleted
		} else if (position == 1) {
			//make the after node the firstnode
			head = head.getNext();
		} else {
			//deletion at arbitrary position
			Node prev = head;
			int count = 1;
			//traverse until it pass to the index
			while (count < position - 1) {
				//traverse the prev link
				prev = prev.getNext();
				//increment the index counter
				count++;
			} // end while
			//create a node the one that's going to be removed
			Node current = prev.getNext();
			//connects the previous to the after node of the current
			prev.setNext(current.getNext());
			//if the lastnode is the one that is being deleted
			if (position == numElements) {
				tail = prev;
			} // end if
			//updates the total number of elements
			numElements--;

		} // end if

	}// end method

	/*
	 * Deletes all nodes with a specified value (occurences) in the list
	 * calls the delete method
	 * has a boolean flag of valueFound
	 */

	void deleteAll() {
		//validates if the list is empty
		if (!isThisNodeAvailable(head)) {
			System.out.println(GetErrorMsg(3));//prints an error msg
		} else {
			//prompts the user and get the value to be deleted
			int valueToBeDeleted = GetUserInput(2);
			int counterPosition = 1;

			Node currentNode = head;
			boolean isValueFound = false; //boolean flag that indicates whether a value is found
			while (currentNode != null) {

				//travers the linked list and delete nodes with specified value
				if (currentNode.getData() == valueToBeDeleted) {
					delete(counterPosition); //call the delete method to perform deletion
					counterPosition--;
					isValueFound = true;
				}
				//if not continue traversing
				counterPosition++;
				currentNode = currentNode.getNext();

			} // end while loop

			//Prompts appopriate messages based on deletion results
			if (!isValueFound) {
				System.out.println(GetErrorMsg(4)); //prints an error if value was not found
			} else {
				System.out.println(GetConfirmationMsg(3)); //print an confirmation message after deletion

			} // end if else
		} // end if else

	}// end method

}// end class
