package mobile;

import java.util.Scanner;

public class LockScreen {
static int warn=0;
private static String password="default";
static Scanner sc=new Scanner(System.in);
public LockScreen() {
	
	
	System.out.println("\nYour Mobile is Locked Please Enter the Password to Unlock...");
	String s=sc.next();
	if(s.equals(password))
	{
		System.out.println("\n\t\tWelocme Back!!\n");
		Phone.home();
	}else {
		System.out.println("The password you entered is incorrect ...\nTry Again");
		new LockScreen();
	}
}
static void changePassword()
{
	System.out.println("Enter you old Password");
	String temppass=sc.next();
	if(temppass.equals(password))
	{
		System.out.println("Enter new password");
		password=sc.next();
		System.out.println("You Password has been successfully Changed!!!");
		warn=1;
		new LockScreen();
	}else {
		System.out.println("The password you entered is incorrect ....");
		new LockScreen();
	}
}
}
