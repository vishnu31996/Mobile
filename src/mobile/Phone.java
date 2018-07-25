package mobile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Phone {

	static Scanner sc = new Scanner(System.in);

	@SuppressWarnings("static-access")
	public static void main(String args[]) throws InterruptedException {

		System.out.println(" 	 Booting Up Your Mobile Please Wait..... ");

		try {
			Thread t = new Thread();
			t.start();
			t.sleep(1000);
			System.out.println("      	  		   Starting...\n");
			t.sleep(500);

			System.out.println("		Samsung");
			System.out.println("\n\nYou default Password is default.. Please Change it after Login :)");
			new LockScreen();
		} catch (Exception e) {
			System.out.println("You Mobile Crashed Unexpectedly :( \nPlease Restart Your device...\nIf condition presist's please contact the Developer :)");
		}
	}

	static void home() {
		if(LockScreen.warn==0)
		{
			System.out.println("\n----------Warning:The Default password hasn't been changed yet!----------\n\n");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy                   HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		System.out.println("\n\nSelect any number from the options given below to perform an action");
		System.out.println("\n                Main Menu");
		System.out.println(
				"\n1.Contacts\n2.phone\n3.message\n4.camera\n5.Calender\n6.Caculator\n7.Change Password\n8.Lock the Mobile\n9.Shutdown");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			new Contacts();
			break;
		case 2:
			new Call();
			break;
		case 3:
			new Message();
			break;
		case 4:
			try {
				new Camera();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			break;
		case 5:
			new Calendar1();
			break;
		case 6:
			new Calculator();
			break;
		case 7:
			LockScreen.changePassword();
			break;
		case 8:
			new LockScreen();
			break;
		case 9:
			System.out.println("\n\t\tShutting Down...");
			System.exit(1);
		default:
			System.out.println("Invalid entry!!");
			home();
			break;
		}
	}

}
