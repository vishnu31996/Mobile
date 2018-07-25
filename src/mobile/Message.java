package mobile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Message {
	private String message = new String();
	static Scanner sc = new Scanner(System.in);
	String end = "END";
	private static LinkedHashMap<String, String> messagebook = new LinkedHashMap<String, String>();

	Message() {
		System.out.println("Message APP");
		System.out.println(
				"Enter 1 to send message \n\tEnter 2 To see previous Message History\n\tEnter 0 to go to Main Menu");
		int tempinput = sc.nextInt();
		if (tempinput == 1) {
			msg();
		} else if (tempinput == 2) {
			int flag=0;
			for (Map.Entry<String, String> m : messagebook.entrySet()) {
				System.out.println(m.getValue() + " = " + m.getKey());
				flag=1;
			}
			if(flag==0)
			{
				System.out.println("New Message history Please come back later.. \n");
			}
			new Message();

		} else if (tempinput == 0) {
			Phone.home();
		} else {
			System.out.println("Invalid Entry!!");
			new Message();
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	void msg() {

		System.out.println("Enter your mesage...");
		setMessage(sc.next());
		System.out.println(
				"Enter 1 to search from stored contacts\n\t2 to send to new Number \n\t3 to See Message history\n\t4 to Quit to main menu");

		int temp = sc.nextInt();
		switch (temp) {
		case 1:
			msgold(getMessage());
			break;
		case 2:
			msgnew(getMessage());
			break;
		case 3:
			messagedisplay();
			System.out.println(
					"To Send your message from stored contacts enter 1 or to enter the number by your self enter any other number");
			int tempcheck = sc.nextInt();
			if (tempcheck == 1) {
				msgold(message);
			} else {
				msgnew(message);
			}
			break;
		case 4:
			Phone.home();
			break;
		default:
			System.out.println("Invalid option try again!!");
			msg();
		}

	}

	private void msgold(String message) {
		Contacts.msg1(message);

	}

	static void msgnew(String message) {
		int tempflagnumber = 0;
		String tempmsg;
		do {
			System.out.println("Enter the number to send");
			tempmsg = sc.next();
			char tempchar[] = new char[tempmsg.length()];
			tempchar = tempmsg.toCharArray();
			int tempintnumber[] = new int[tempmsg.length()];
			for (int start = 0; start < tempmsg.length(); start++) {
				tempintnumber[start] = (int) tempchar[start];
			}
			for (int find : tempintnumber) {
				if (find < 48 || find > 57) {
					System.out.println("Please Enter numbers only! \n");
					tempflagnumber = 1;
					break;
				}
			}
			if (tempmsg.length() < 10 || tempmsg.length() > 10) {
				System.out.println("Enter a valid 10 digit mobile number! ");
				msgnew(message);
			}
		} while (tempflagnumber == 1);
		System.out.println("Enter 1 to confirm\n\t2 to Change Number\n\t3 to cancel");
		int temp = sc.nextInt();
		switch (temp) {
		case 1:
			System.out.println("Message Successfully sent to " + tempmsg + "\n");
			getMessagebook().put(message, tempmsg);
			Phone.home();
			break;
		case 2:
			msgnew(message);
			break;
		case 3:
			System.out.println("Message canceled");
			Phone.home();
		default:
			System.out.println("Invalid entry");
			msgnew(message);
			break;
		}
	}

	public static LinkedHashMap<String, String> getMessagebook() {
		return messagebook;
	}

	public static void setMessagebook(LinkedHashMap<String, String> messagebook) {
		Message.messagebook = messagebook;
	}

	String messagedisplay() {
		int flag=0;
		for (Map.Entry<String, String> m : messagebook.entrySet()) {
			System.out.println(m.getValue() + " = " + m.getKey());
			flag=1;
		}
		if(flag==0)
		{
			System.out.println("New Message history Please check back later.. \n");
		}
		return end;

	}

	@Override
	public String toString() {
		return messagedisplay();
	}

}
