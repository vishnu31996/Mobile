package mobile;

import java.util.Scanner;

public class Camera {
	static Scanner sc = new Scanner(System.in);
	static int pic_Count = 0;

	public Camera() throws InterruptedException {
		System.out.println("		Camera App");
		run();
	}

	void run()  {
		System.out.println("Enter 1. to take picture \n\t2. to open galley\n\t3.go back to main menu");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			picture();
			break;
		case 2:
			gallery();
			break;
		case 3: Phone.home();
		break;
		default:System.out.println("Invalid");run();
			break;
		}
	}

	private void gallery()  {
		System.out.println("Total number of pictures taken is " + pic_Count);
		System.out.println("Enter 1.to Take more picture \n\t2.to main menu");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			picture();
			break;
		case 2:
			Phone.home();
			break;
		default:
			System.out.println("Invalid Entry!!");
			gallery();
			break;
		}

	}

	@SuppressWarnings("static-access")
	private void picture() {
		Thread temppic=new Thread();
		temppic.start();
		System.out.println("\t\tSmile Please :)");
		try {
			temppic.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\t\tPicture took!!!\n\n");
		pic_Count++;
		run();
	}

}
