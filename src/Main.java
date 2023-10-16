public class Main {

	public static void main(String[] args) {

		Node headNode = new Node(10);
		SinglyLinkList linkList = new SinglyLinkList(headNode);

		linkList.Append();
		SinglyLinkList.printLinkedList(linkList);
	}// end main

	public void DisplayMenu() {

	}// end method

}// end class
