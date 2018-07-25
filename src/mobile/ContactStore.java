package mobile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;


@SuppressWarnings("serial")
public class ContactStore implements Serializable {

	/**
	 * Created by vishnu
	 */
	
	private String name,number,address;
	private static ArrayList<String> number2 = new ArrayList<>();
	private static ArrayList<String> mailid = new ArrayList<>();
	String end="End";


	@SuppressWarnings("static-access")
	public ContactStore(String name,String number, ArrayList<String> number2, ArrayList<String> mailid, String address) {
		this.name = name;
		this.number = number;
		this.number2 = number2;
		this.mailid = mailid;
		this.address = address;
	}

	
	public static ArrayList<String> getNumber2() {
		return number2;
	}


	public static void setNumber2(ArrayList<String> number2) {
		ContactStore.number2 = number2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	




	public static ArrayList<String> getMailid() {
		return mailid;
	}


	public static void setMailid(ArrayList<String> mailid) {
		ContactStore.mailid = mailid;
	}


	public Object getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	String displaynumber()
	{
		System.out.println("\n\n\nname = " + name + "\nnumber 1 = " + number);
		ListIterator<String> it=number2.listIterator();
		int count=1;
		int flagnumber=0;
		while(it.hasNext())
		{
			System.out.println("Other number"+count +" = "+it.next());
			count++;
			flagnumber=1;
		}
		if(flagnumber==0)
		{
			System.out.println("Secondary number = NULL");
		}
		ListIterator<String> it1=mailid.listIterator();
		int countmail=1;
		int flagging=0;
		while(it1.hasNext())
		{
			System.out.println("mail id "+countmail +" = "+it1.next());
			countmail++;
			flagging=1;
		}
		if(flagging==0)
		{
			System.out.println("Mail = NULL");
		}
		System.out.println("Address = " + address);
		
		return end;
	}


	@Override
	public String toString() {
		return displaynumber();
	}

}
