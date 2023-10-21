import java.util.Scanner;
//class named Main
public class Main {

	// field object
	static SinglyLinkList linkList = new SinglyLinkList();
	//entry point
	public static void main(String[] args) {
		DisplayMenu(linkList);
	}// end main

	/*
	 * add border to the menu interface
	 * had an argument of an char and the number of times it will print
	 */

	static void AddBorder(char dsgn, int numOfTimes) {
		for (int i = 0; i < numOfTimes; i++) {
			System.out.print(dsgn);
		}

		System.out.println();

	}

	/*
	 * method that has an argument of an obj
	 * switch statement that call the specific method that user specified to use
	 * had a default on which prompt whenever user inputs an invalid
	 */

	static void DisplayMenu(SinglyLinkList linkList) {

		Scanner sc = new Scanner(System.in);
		//@formatter:off
		AddBorder('*', 50);
		System.out.println("\tMidterm Lab Act#1\n\tLinked List Crud");
		AddBorder('*', 50);
		System.out.println(" PRESS[0] APPEND\n"
						+ " PRESS[1] DISPLAY\n"
						+ " PRESS[2] DELETE\n"
						+ " PRESS[3] DELETE ALL\n"
						+ " PRESS[4] END PROGRAM");
		AddBorder('*', 50);
		System.out.println("ENTER YOUR CHOICE: ");


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
			System.out.println("TERMINATING....\nThank your for trying!!");
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
