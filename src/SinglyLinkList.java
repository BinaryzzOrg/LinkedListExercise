
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
		System.out.println("Choose the position of element to delete(start from 1)");
		int position = scan.nextInt();
		
		if(position<1) {
			System.out.println("try again");
			Delete();
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
