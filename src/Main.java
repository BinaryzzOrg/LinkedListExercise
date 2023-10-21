import java.util.Scanner;

public class Main {

	// field object
	static SinglyLinkList linkList = new SinglyLinkList();

	public static void main(String[] args) {
		DisplayMenu(linkList);
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

		switch (linkList.GetUserInput()) {
		case 0: {

			// call append method
			linkList.append();
			break;
		}
		case 1: {

			// call display method that shows index 1 of confirmationMsg array
			linkList.display(1);
			break;
		}
		case 2: {

			// check if head is available
			if (!linkList.isThisNodeAvailable(linkList.getHead())) {

				// call errorMsg array of index 3
				System.out.println(linkList.GetErrorMsg(3));
			} else {

				// if head is available, call promtMsg array of index 1
				System.out.print(linkList.GetPromptMsg(1));
				sc = new Scanner(System.in);
				// get the position to delete
				int position = sc.nextInt();
				// call delete method and pass in the position
				linkList.delete(position);
			} // end if
			break;
		}
		case 3: {

			// call deleteAll method and display method
			linkList.deleteAll();
			linkList.display(2);
			break;
		}
		case 4: {

			// close program
			System.exit(0);
			break;
		}
		default:
			// errorMsg if input checker fails
			System.out.println("Only enter [0], [1], [2], [3], [4]");
		}// end switch

		// call the menu again passing the same linkList object
		DisplayMenu(linkList);
	}// end method

}// end class
