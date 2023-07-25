
public class Coffeemaker {
public static void main(String[] args) {
	CoffeeBeans bean= new CoffeeBeans();
	bean.setBeanName("Coffea arabica");
	bean.setAroma("smoky");
	bean.setColor("brownish");
	
	Milk milk=new Milk();
	milk.setAroma("milky");
	milk.setColor("whitish yellow");
	milk.setDensity(1025);
	milk.setFlavour("vanilla-like");
	
	
	CoffeMaker coffeeMaker=new CoffeMaker();  
	coffeeMaker.CoffeeProcess(milk, bean);
}
}

class CoffeeBeans
{
	private String BeanName;
	private long bodyWeight;
	private String flavour;
	private String aroma;
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBeanName() {
		return BeanName;
	}
	public void setBeanName(String beanName) {
		BeanName = beanName;
	}
	public long getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(long bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public String getAroma() {
		return aroma;
	}
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	
	void showDetails()
	{
		System.out.println("----Coffee bean charactersitics----");
		System.out.println();
	}
}


class Milk
{
	private String color;
	private double boilingPoint;
	private String flavour;
	private String aroma;	
	private double density;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getBoilingPoint() {
		return boilingPoint;
	}
	public void setBoilingPoint(double boilingPoint) {
		this.boilingPoint = boilingPoint;
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public String getAroma() {
		return aroma;
	}
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	public double getDensity() {
		return density;
	}
	public void setDensity(double density) {
		this.density = density;
	}
}

class CoffeMaker
{
	    String aroma;
		String acidity ;
		String flavour;
		double density;
		String color;
		

	Milk CoffeeProcess(Milk milk, CoffeeBeans bean)
	{
		String aroma;
		String acidity ;
		String flavour;
		double density;
		String color;
		
		this.aroma=milk.getAroma();
		this.density=milk.getDensity();
		this.flavour=milk.getFlavour()+" "+ bean.getFlavour();
		this.color=bean.getColor();
		
		System.out.println("-----Coffee is Ready-----");
		Milk milkUsed=new Milk();
		milkUsed.setAroma(this.aroma);
		milkUsed.setDensity(this.density);
//		milkUsed.setFlavour(flavour);
//		System.out.println("Aroma of Coffee is: "+this.aroma);
//		System.out.println("Density of Coffee is: "+this.density);
//		System.out.println("Flavour of Coffee is: "+this.flavour);
		System.out.println("Color of Coffee is: "+this.color);
		return milkUsed;
	}
}

