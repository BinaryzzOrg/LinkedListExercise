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

	void Append() {

		// check for head
		if (!IsThisNodeAvailable(head)) {
			CreateHead();
			return;
		} // end if else

		// check for tail
		if (IsThisNodeAvailable(tail)) {
			Node newNode = new Node(GetUserInput(0));
			tail.setNext(newNode);
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
		head.setNext(tailNode);
		tail = tailNode;
	}// end method

	void Display() {

	}// end method

	void Delete() {
		System.out.println("Choose the position of element to delete(start from 1)");
		int position = scan.nextInt();
		
		if(position<1) {
			System.out.println("try again");
			delete();
		}
		else if(position==1) {
			head = head.next;
		}else {
			Node prev = head;
			int count = 1;
			while(count<position - 1) {
				prev = prev.next;
				count++;
			}
			Node current = prev.next;
			prev.next = current.next;
		}
	}// end method

	void DeleteAll() {

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
