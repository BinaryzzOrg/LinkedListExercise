import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		SinglyLinkList linkList = new SinglyLinkList();

		DisplayMenu(linkList);

		SinglyLinkList.printLinkedList(linkList);
	}// end main

	static void DisplayMenu(SinglyLinkList linkList) {

		Scanner sc = new Scanner(System.in);
		//@formatter:off
		System.out.print("\n {Midterm Lab Act} \n" + 
						"[0] Append \n"+ 
						"[1] Display \n"+ 
						"[2] Delete \n"+ 
						"[3] Delete ALL \n"+ 
						"[4] Exit \n" +
						": ");
		//@formatter:on

		switch (sc.nextInt()) {
		case 0: {
			linkList.append();
			break;
		}
		case 1: {
			// linkList.display();
			SinglyLinkList.printLinkedList(linkList);
			break;
		}
		case 2: {
			linkList.delete();
			break;
		}
		case 3: {
			linkList.deleteAll();
			break;
		}
		case 4: {
			System.exit(0);
			break;
		}
		default:
			throw new IllegalArgumentException("Only enter [0], [1], [2], [3], [4]");
		}// end switch
		DisplayMenu(linkList);
	}// end method

}// end class
