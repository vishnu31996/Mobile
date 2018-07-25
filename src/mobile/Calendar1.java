package mobile;
import java.util.Calendar;
import java.util.Scanner;
public class Calendar1 {
	Calendar calendar = Calendar.getInstance();  
	static Scanner sc=new Scanner(System.in);
	public Calendar1() {
		System.out.println("\n\t\t Calendar App ");
		System.out.println("\nThe current date is : " + calendar.getTime());
		System.out.println("Enter 1 to check date\n\t2 to check month\n\t3 to check Year\n\t 4 to main menu");
		int tempswitch=sc.nextInt();
		switch (tempswitch) {
		case 1:checkDate();
			break;
		case 2:checkMonth();
		break;
		case 3:checkYear();
		break;
		case 4:Phone.home();
		break;
		default:System.out.println("Invalid Entry!!");new Calendar1();
			break;
		}
		
		
		
	}

	 private void checkYear() {
		// TODO Auto-generated method stub
		 System.out.println("How many Years before or after you want to check ?\n Enter in positive or negative numbers");
		 int tempyear=sc.nextInt();
		 System.out.print("The Year is - ");
		  calendar.add(Calendar.YEAR, tempyear);  
		   System.out.println(calendar.getTime());
		   new Calendar1();
	}

	private void checkMonth() {
		 System.out.println("How many Months before or after you want to check ?\n Enter in positive or negative numbers");
		 int tempmonth=sc.nextInt();
		 System.out.print("The Month is - ");
		  calendar.add(Calendar.MONTH, tempmonth);  
		   System.out.println(calendar.getTime());
		   new Calendar1();		
	}

	private void checkDate() {
		 System.out.println("How many days before or after you want to check ?\n Enter in positive or negative numbers");
		 int tempdate=sc.nextInt();
		 System.out.print("The Date is - ");
		  calendar.add(Calendar.DATE, tempdate);  
		   System.out.println(calendar.getTime());
		   new Calendar1();
	}
}
