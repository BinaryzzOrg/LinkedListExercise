import java.util.Scanner;

public class Main {

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
			linkList.append();
			break;
		}
		case 1: {
			linkList.display();
			break;
		}
		case 2: {
			if (!linkList.isThisNodeAvailable(linkList.getHead())) {
				System.out.println("You don't have a list yet!");
			} else {
				System.out.print(linkList.GetPromptMsg(1));
				sc = new Scanner(System.in);
				int position = sc.nextInt();
				linkList.delete(position);
			} // end if
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
			System.out.println("Only enter [0], [1], [2], [3], [4]");
		}// end switch
		DisplayMenu(linkList);
	}// end method

}// end class
