class ClientInfo
{
	private long memberId;
	private long memberPhNo;
	private long dateOfJoin;
	private String memberName; 
    private String branch;
	private boolean needRenewal;
	
	public ClientInfo() {
		System.out.println("\n");
		System.out.println("this is a non-argumented constructor");
		
		
	}
 
	ClientInfo(long memberId, long memberPhNo, long dateOfJoin, String memberName,String branch, boolean needRenewal)
	{
		this.memberId=memberId;
		this.memberPhNo=memberPhNo;
		this.dateOfJoin=dateOfJoin;
		this.memberName=memberName;
		this.branch=branch;
		this.needRenewal=needRenewal;
	}
	
//	1st type without arg without rttype
	public void printDetails()
	{
		System.out.println("Member's ID is "+memberId);
		System.out.println("Member's phone no is "+memberPhNo);
		System.out.println("Member's date of joining is "+dateOfJoin);
		System.out.println("Member's name is "+memberName);
		System.out.println("Member's branch is "+branch);
		System.out.println("Do member need renewal? "+needRenewal);
	
		
		
	}
//	2nd type w arg wt returntype
	void changePhoneNo(long memberPhNo)
	{
		System.out.println("\nChanging phone number....");
		this.memberPhNo=memberPhNo;
		System.out.println(this.memberPhNo);
	}
	
//	3rd type w arg w rttype
	long getFees(int months)
	{
		System.out.println("\n");
		return 1300*months;
	}
	
//	4th type w rettype
	long dateOfJoin()
	{
		System.out.println("\n");
		System.out.println("returning date of joining...");
		return this.dateOfJoin;
	}
	
	void memberStats(int sets)
	{
		System.out.println("Member can do "+ sets+" sets");
		
	}
	
	void memberStats(int sets, int reps)
	{
		System.out.println("Member can do "+ sets+" sets" + " with "+reps +" reps");
		
	}
	
	void memberHeight(int height)
	{
		System.out.println("member's height is + "+ height);
	}
	
	void memberHeight(float height)
	{
		System.out.println("member's height is + "+ height);
	}
	
}

class FitnessCentre
{
	private String GSTNO;
	private long zipcode;
	
	FitnessCentre(String GSTNO, long zipcode) {
		// TODO Auto-generated constructor stub
	this.GSTNO=GSTNO;
	this.zipcode=zipcode;
	}
	
	private void syso() {
		// TODO Auto-generated method stub

	}
	
}







public class GymMembership {
	public static void main(String[] args) {
		ClientInfo client=new ClientInfo(123,96654704,20072023,"Paritosh","Pune",true);
		client.printDetails();
		client.changePhoneNo(97670903);
		long f=client.getFees(6);
		System.out.println("Total fees to be paid is "+f);
		long doj=client.dateOfJoin();
		System.out.println(doj);
		client.memberStats(2);
		client.memberStats(3, 15);
		client.memberHeight(135);
		client.memberHeight(145.5f);
		
		ClientInfo client2=new ClientInfo(321,9850088,21062023,"Tom","Birmingham",true);
		client2.printDetails();
		client2.changePhoneNo(91330903);
		long f2=client2.getFees(18);
		System.out.println("Total fees to be paid is "+f);
		long doj2=client2.dateOfJoin();
		System.out.println(doj2);
		client2.memberStats(1);
		client2.memberStats(2, 15);
		

	}
}