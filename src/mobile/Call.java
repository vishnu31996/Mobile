package mobile;

import java.util.Scanner;

public class Call {
	static Scanner sc = new Scanner(System.in);

	Call() {
		System.out.println("DialPad");
		callnum();
	}

	void callnum() {
		System.out.println("Enter 1. to search contact \n\t2. to Dial Directly");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			Contacts.search();
			break;
		case 2:
			dial();
			break;
		default:
			System.out.println("Invalid Entry Try Again");
			callnum();
			break;
		}

	}

	private static void dial() {
		// TODO Auto-generated method stub
		System.out.println("Enter number to dial");
		Long l = sc.nextLong();
		System.out.println("Calling...." + l);
		end();
	}

	static void end() {
		// TODO Auto-generated method stub
		System.out.println("Enter 0 to end");
		int a = sc.nextInt();
		if (a == 0) {
			System.out.println("Call Ended");
			Phone.home();
		} else {
			end();
		}
	}
}
