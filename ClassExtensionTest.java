
public class ClassExtensionTest {

	public static void main(String[] args) {
       Doctor x=new HeartSurgeon();
       x.diagnose();
       x.prescribe();
       x.charge();
       x.cut();
       x.stitch();
		
		
		if(x instanceof Doctor)
		{
			System.out.println("It's a Doctor's object");
			
		}
		else
		{
			System.out.println("Its not a Doctor's object");
		}
		
		
		if(x instanceof Surgeon)
		{
			System.out.println("It's a Doctor's object");
			
		}
		else
		{
			System.out.println("Its not a Doctor's object");
		}
		
		
		if(x instanceof HeartSurgeon)
		{
			System.out.println("It's a Doctor's object");
			
		}
		else
		{
			System.out.println("Its not a Doctor's object");
		}
		
		
		
	}

}

class Doctor
{
	void diagnose()
	{
		System.out.println("Doctor:is diagnosing ENT checkup...");	
	}
	
	void prescribe()
	{
		System.out.println("Doctor is prsecribing RGB pills");
	}
	
	void charge()
	{
		System.out.println("Doctor: is charging 300");
	}
}

class Surgeon extends Doctor
{
	void diagnose() {
		System.out.println("Surgeon: is diagnosing CT ScanMRI Scan....");

	}
	void prescribe() {
		System.out.println("Surgeon: is prescribing expensive pills");
	}
	void charge() {
		System.out.println("Surgeon: is charging 1000");
	}
	void cut() {
		System.out.println("Surgeon: is cutting");
	}
	void stitch() {
		System.out.println("Surgeon: is stitching");
	}
}

class HeartSurgeon extends Surgeon
{
	void diagnose() {
		System.out.println("HeartSurgeon: is diagnosing...ECG Report");
	}
	void prescribe() {
		System.out.println("HeartSurgeon: is prescribing...expensive pills....plus yoga..plus exercises");
	}
	void charge() {
		System.out.println("HeartSurgeon: is charging...3000 ");
	}
}