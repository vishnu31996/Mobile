package mobile;

import java.util.Scanner;

public class Calculator {
	Scanner sc = new Scanner(System.in);
	 long value;
	 int flag = 0;
	 Long temp1;
	 long temp2;
	 int count=1;

	public Calculator() {
		// TODO Auto-generated constructor stub
		System.out.println("\n\t\tCalculator App");
		System.out.println("\nEnter 1 to calculate 2 to go back to main menu \n");
		int store=sc.nextInt();
		switch (store) {
		case 1:calculate();
			break;
		case 2: Phone.home();
		break;
		default:System.out.println("Invalid entry!!!");
		new Calculator();
			break;
		}

	}

	void calculate() {
		
		if (flag == 0) {
			System.out.println("Enter the number " + count);
			 temp1 = sc.nextLong();
			count++;
		} else {
			temp1 = value;
		}
		System.out.println("Enter the number " + count);
		temp2 = sc.nextLong();
		count++;
		System.out.println("Enter the number to perform Operations  1.Addition 2.Subtract 3.multiply 5.divide");
		int tempinput = sc.nextInt();
		switch (tempinput) {
		case 1:
			value = (temp1 + temp2);
			System.out.println(value);
			flag = 1;
			System.out.println("To perform more calculation on the same number enter 1 or to end this process enter 0");
			int tempswi = sc.nextInt();
			if (tempswi == 1) {
				calculate();
			} else {
				new Calculator();
			}
			break;
		case 2:
			value = (temp1 - temp2);
			System.out.println(value);
			flag = 1;
			System.out.println("To perform more calculation enter 1 or enter 0");
			int tempswi1 = sc.nextInt();
			if (tempswi1 == 1) {
				calculate();
			} else {
				new Calculator();
			}
			break;
		case 3:
			value = (temp1 * temp2);
			System.out.println(value);
			flag = 1;
			System.out.println("To perform more calculation enter 1 or enter 0");
			int tempswi3 = sc.nextInt();
			if (tempswi3 == 1) {
				calculate();
			} else {
				new Calculator();
			}
			break;
		case 4:
			value = (temp1 / temp2);
			System.out.println(value);
			flag = 1;
			System.out.println("To perform more calculation enter 1 or enter 0");
			int tempswi4 = sc.nextInt();
			if (tempswi4 == 1) {
				calculate();
			} else {
				new Calculator();
			}
			break;

		default:System.out.println("Invalid Entry!!!!");
		new Calculator();
			break;
		}
	}

}
