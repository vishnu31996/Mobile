package mobile;

import java.util.*;

public class Contacts {
	static int count = 0;
	static Scanner sc = new Scanner(System.in);
	private static LinkedHashMap<String, ContactStore> phonebook = new LinkedHashMap<String, ContactStore>();

	public Contacts() {
		System.out.println("                 Contacts App\n");
		run();
	}

	static void run() {

		System.out.println(
				"Enter   1 to print all\n\t2 to search and call or message \n\t3 to add\n\t4 to edit contact\n\t5 to Delete an Contact\n\t6 to main menu");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			if (count == 0) {
				System.out.println("No Contacts added yet!");
				add();
			} else {
				for (String w : phonebook.keySet()) {
					System.out.println(phonebook.get(w));
				}
				run();
			}
			break;
		case 2:
			if (count == 0) {
				System.out.println("No Contacts added yet!");
				add();
			} else {
				search();
			}
			break;
		case 3:
			add();
			break;
		case 4:
			if (count == 0) {
				System.out.println("No Contacts added yet!");
				add();
			} else {
				edit();
			}
			break;
		case 5:
			if (count == 0) {
				System.out.println("No Contacts added yet!");
				add();
			} else {
				delete();
			}
			break;
		case 6:
			Phone.home();
			break;
		default:
			run();
		}

	}

	private static void add() {

		String name, number, address;
		ArrayList<String> mailid = new ArrayList<>();
		ArrayList<String> number2 = new ArrayList<>();
		String tempsecondarynumber, mail;
		int tempmailcount, countmailid = 1;
		;
		System.out.println("\n------ Add New Contact ------\n");
		System.out.println("Enter Contact name");
		name = sc.next();
		for (String w : phonebook.keySet()) {
			if (name.equalsIgnoreCase(w)) {
				System.out.println("Contact name already Exists!!!");
				System.out.println("Enter 1 to see the contact\n\t2 to add new\n\t3 to Contact menu");
				int store = sc.nextInt();
				if (store == 1) {
					System.out.println(phonebook.get(w));
					run();
				} else if (store == 2) {
					add();
				} else if (store == 3) {
					run();
				} else {
					System.out.println("Invalid option!!!");
					run();
				}
			}
		}
		int tempflagnumber = 0;
		do {
			tempflagnumber = 0;
			System.out.println("Enter Contact Primary number");
			number = sc.next();
			char tempchar[] = new char[number.length()];
			tempchar = number.toCharArray();
			int tempintnumber[] = new int[number.length()];
			for (int start = 0; start < number.length(); start++) {
				tempintnumber[start] = (int) tempchar[start];
			}
			for (int find : tempintnumber) {
				if (find < 48 || find > 57) {
					System.out.println("Please Enter numbers only! \n");
					tempflagnumber = 1;
					break;
				}
			}

			if (number.length() < 10 || number.length() > 10) {
				System.out.println("The number you entered is Invalid Please Enter 10 digit number...\n");

			}
		} while (number.length() != 10 || tempflagnumber == 1);
		System.out.println("To add secondary Contact number enter 1 or To skip Secondary Contact number enter 0");
		int sectemp = sc.nextInt();
		int anothernumber;
		int numbercount = 1;
		if (sectemp == 1) {
			do {
				int tempflagnumber1 = 0;
				do {
					tempflagnumber1 = 0;
					System.out.println("Enter Contact Secondary number " + numbercount);
					tempsecondarynumber = sc.next();
					char tempchar1[] = new char[tempsecondarynumber.length()];
					tempchar1 = tempsecondarynumber.toCharArray();
					int tempintnumber1[] = new int[tempsecondarynumber.length()];
					for (int start = 0; start < tempsecondarynumber.length(); start++) {
						tempintnumber1[start] = (int) tempchar1[start];
					}
					for (int find : tempintnumber1) {
						if (find < 48 || find > 57) {
							System.out.println("Please Enter numbers only! \n");
							tempflagnumber1 = 1;
						}
					}

					if (tempsecondarynumber.length() < 10 || tempsecondarynumber.length() > 10) {
						System.out.println("The number you entered is Invalid Please Enter 10 digit number...");

					}
				} while (tempsecondarynumber.length() != 10 || tempflagnumber1 == 1);
				number2.add(tempsecondarynumber);
				numbercount++;
				System.out.println("To add another number enter 1 or enter any other number");
				anothernumber = sc.nextInt();
			} while (anothernumber == 1);
		}
		System.out.println("To add mail ID enter 1 or To skip mail enter 0");
		int emailtemp = sc.nextInt();
		if (emailtemp == 1) {
			do {
				int flag = 0;

				do {
					flag = 0;
					System.out.println("Enter Contact mail Id " + countmailid);
					mail = sc.next();
					char ch[] = new char[mail.length()];
					ch = mail.toCharArray();
					for (char w : ch) {
						if (w == '@') {
							flag = 1;
						}
					}
					if (flag == 0) {
						System.out.println("Enter a Vaild mail Id...");
					}
				} while (flag == 0);
				mailid.add(mail);
				countmailid++;
				System.out.println("To add Another Mail ID enter 1 or enter any other number");
				tempmailcount = sc.nextInt();
			} while (tempmailcount == 1);
		}
		System.out.println("To add Address enter 1 or To skip Address enter 0");
		int addresstemp = sc.nextInt();
		if (addresstemp == 1) {
			System.out.println("Enter Contact Address");
			address = sc.next();
		} else {
			address = "NULL";
		}
		phonebook.put(name, new ContactStore(name, number, number2, mailid, address));
		System.out.println("Contact " + name + " Added Successfully!");
		count++;
		run();

	}

	public static void search() {
		System.out.println("Enter the name to search");
		String key = sc.next();

		for (String w : phonebook.keySet()) {
			if (key.equalsIgnoreCase(w)) {
				System.out.println(phonebook.get(w));
				System.out.println("Enter 1 to call\n\t2 to search again \n\t3 to Contacts Menu\n\t4 to message");
				int a = sc.nextInt();
				switch (a) {
				case 1:
					System.out.println("Calling... " + w);
					Call.end();

					break;
				case 2:
					search();
					break;
				case 3:
					run();
					break;
				case 4:
					System.out.println("Enter your mesage...");
					String store = sc.nextLine();
					System.out.println("You Message has successfully Sent to " + w);
					Message.getMessagebook().put(store, w);

				default:
					System.out.println("Invalid Entry!!");
					search();
					break;
				}
			}
		}
		System.out.println("Contact not found!!!");
		run();

	}

	public static void msg1(String message) {
		System.out.println("Enter the name to search");
		String key = sc.next();

		for (String keyvalue : phonebook.keySet()) {
			if (key.equalsIgnoreCase(keyvalue)) {
				System.out.println(phonebook.get(keyvalue));
				System.out.println("Enter 1 to confirm\n 2 to search again\n 3 to cancel and go to home");
				int temp = sc.nextInt();
				switch (temp) {
				case 1:
					System.out.println("Message sent successfully to " + keyvalue);
					Message.getMessagebook().put(message, keyvalue);
					Phone.home();
					break;
				case 2:
					msg1(message);
					break;
				case 3:
					System.out.println("Message cancled :(");
					Phone.home();
					break;
				default:
					System.out.println("Invalid entry try again");
					msg1(message);
					break;
				}
			}

		}
		System.out.println("Contact not found!!!");
		System.out.println("To search Again Enter 1 or to Enter the number By yourself enter any other number ");
		int expect=sc.nextInt();
		if(expect==1)
		{
			msg1(message);
		}
		Message.msgnew(message);

	}

	static void edit() {
		System.out.println("Enter the name of the contact you want to Edit");
		String key = sc.next();
		for (String w : phonebook.keySet()) {
			if (key.equals(w)) {
				System.out.println("Contact Found!");
				System.out.println(phonebook.get(w));

				ifAvailableEdit(key);
			} else {
				System.out.println("Contact Not found!!!");
				run();
			}
		}

	}

	static void ifAvailableEdit(String key) {
		while (true) {
			System.out.println(
					"Edit What.... \n\t1.name\n\t2.Primary Number\n\t3.Secondary Number\n\t4.Mail\n\t5.Address\n\t6.Contacts menu");
			int inputEdit = sc.nextInt();
			switch (inputEdit) {
			case 1:
				editname();
				break;
			case 2:
				String tempnumber;
				int tempflagnumber = 0;
				do {
					tempflagnumber = 0;
					System.out.println("Enter the new Primary number");
					tempnumber = sc.next();
					char tempchar[] = new char[tempnumber.length()];
					tempchar = tempnumber.toCharArray();
					int tempintnumber[] = new int[tempnumber.length()];
					for (int start = 0; start < tempnumber.length(); start++) {
						tempintnumber[start] = (int) tempchar[start];
					}
					for (int find : tempintnumber) {
						if (find < 48 || find > 57) {
							System.out.println("Please Enter numbers only! \n");
							tempflagnumber = 1;
							break;
						}
					}
					if (tempnumber.length() < 10 || tempnumber.length() > 10) {
						System.out.println("The number you entered is Invalid Please Enter 10 digit number...");

					}
				} while (tempnumber.length() != 10 || tempflagnumber == 1);
				phonebook.get(key).setNumber(tempnumber);
				System.out.println("Primary number Changed Successfully to " + tempnumber);
				break;
			case 3:
				modifysecondarynumber(key);
				break;
			case 4:
				modifymail(key);
				break;
			case 5:
				System.out.println("Enter the new Address");
				String tempaddress = sc.next();
				phonebook.get(key).setAddress(tempaddress);
				System.out.println("Address Changed Successfully to " + tempaddress);
			case 6:
				run();
			default:
				System.out.println("Invalid Entry Try Again!!");

			}
		}
	}

	@SuppressWarnings("static-access")
	private static void modifymail(String key) {
		String tempmail;
		ArrayList<String> mailidarray = new ArrayList<>();
		int indexnumber = 0;
		int modifyflag = 0;
		int count = 1;
		int flag = 0;

	
		mailidarray = phonebook.get(key).getMailid();
		ListIterator<String> it = mailidarray.listIterator();

		while (it.hasNext()) {
			System.out.println("Mail ID " + count + " = " + it.next());
			count++;
		}

		System.out.println("To Modify Existing Mail ID enter 1 or to add new Mail ID enter any other number");
		int check = sc.nextInt();
		if (check == 1) {
			do {
				System.out.println("Enter the index number of which you want to edit");
				indexnumber = sc.nextInt();
				modifyflag = 1;
			} while (indexnumber > count || indexnumber <= 0);
		}

		indexnumber -= 1;
		do {
			System.out.println("Enter the new Mail Address");
			tempmail = sc.next();
			char ch[] = new char[tempmail.length()];
			ch = tempmail.toCharArray();
			for (char w : ch) {
				if (w == '@') {
					flag = 1;
				} else if (w == ch[tempmail.length() - 1] && flag == 0) {
					System.out.println("Enter a Vaild mail Id...");
					break;
				}
			}
		} while (flag == 0);

		if (modifyflag == 1) {
			mailidarray.set(indexnumber, tempmail);

			phonebook.get(key).setMailid(mailidarray);

			System.out.println("Mail ID " + (indexnumber + 1) + " Changed Successfully to " + tempmail);
		} else {
			mailidarray.add(tempmail);
			phonebook.get(key).setMailid(mailidarray);
			System.out.println("New Mail ID " + count + " has been added Successfully to " + key);
		}

		ifAvailableEdit(key);

	}

	@SuppressWarnings("static-access")
	private static void modifysecondarynumber(String key) {

		ArrayList<String> tempnumber2array = new ArrayList<>();
		String tempnumber2;
		int indexnumber = 0;
		int tempflagnumber1 = 0;
		int modifyflag = 0;
		int count = 1;

		
		tempnumber2array = phonebook.get(key).getNumber2();
		ListIterator<String> it = tempnumber2array.listIterator();

		while (it.hasNext()) {
			System.out.println("Other number " + count + " = " + it.next());
			count++;
		}

		System.out.println(
				"To Modify Existing Secondary number enter 1 or to add new secondary number enter any other number");
		int check = sc.nextInt();
		if (check == 1) {
			do {
				System.out.println("Enter the index number of which you want to edit");
				indexnumber = sc.nextInt();
				modifyflag = 1;
			} while (indexnumber > count || indexnumber <= 0);
		}

		indexnumber -= 1;
		do {
			tempflagnumber1 = 0;
			System.out.println("Enter the new Secondary number");
			tempnumber2 = sc.next();
			char tempchar1[] = new char[tempnumber2.length()];
			tempchar1 = tempnumber2.toCharArray();
			int tempintnumber1[] = new int[tempnumber2.length()];
			for (int start = 0; start < tempnumber2.length(); start++) {
				tempintnumber1[start] = (int) tempchar1[start];
			}
			for (int find : tempintnumber1) {
				if (find < 48 || find > 57) {
					System.out.println("Please Enter numbers only! \n");
					tempflagnumber1 = 1;
					break;
				}
			}

			if (tempnumber2.length() < 10 || tempnumber2.length() > 10) {
				System.out.println("The number you entered is Invalid Please Enter 10 digit number...");

			}
		} while (tempnumber2.length() != 10 || tempflagnumber1 == 1);
		if (modifyflag == 1) {
			tempnumber2array.set(indexnumber, tempnumber2);
			phonebook.get(key).setNumber2(tempnumber2array);

			System.out.println("Secondary number " + (indexnumber + 1) + " Changed Successfully to " + tempnumber2);
		} else {
			tempnumber2array.add(tempnumber2);
			phonebook.get(key).setNumber2(tempnumber2array);
			System.out.println("New Secondary number " + count + " has been added Successfully to " + key);
		}
		ifAvailableEdit(key);
	}

	private static void editname() {
		System.out.println("Enter the new name");
		String tempname = sc.next();
		for (String w : phonebook.keySet()) {
			if (tempname.equalsIgnoreCase(w)) {
				System.out.println("Contact name already Exists!!!");
				editname();
			} else {
				phonebook.get(w).setName(tempname);
				phonebook.put(tempname, phonebook.get(w));
				phonebook.remove(w);
				ifAvailableEdit(tempname);
			}
		}

	}

	static void delete() {
		System.out.println("Enter the name to delete");
		String input = sc.next();
		for (String w : phonebook.keySet()) {
			if (input.equalsIgnoreCase(w)) {
				System.out.println(phonebook.get(w));
				while (true) {
					System.out.println("Enter 1 to confirm\n\t2 to cancel");
					int tempinput = sc.nextInt();
					if (tempinput == 1) {
						phonebook.remove(w);
						System.out.println("Contact " + w + " Deleted Successfully!!!");
						count--;
						run();
					} else if (tempinput == 2) {
						System.out.println("Cancled!!");
						run();
					} else {
						System.out.println("Invalid Entry Please Try Again!!!");
					}
				}
			}
		}
		System.out.println("No such contact found!!!");
		run();
	}
}
