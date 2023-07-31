package shapes;
import java.io.Serializable;
public class Circle implements Serializable,Shape{
	private double radius;
	

	public Circle(double radius)
	{
		this.radius=radius;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		 return 2 * Math.PI * radius;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("Circle - Radius: " + radius + ", Area: " + getArea() + ", Perimeter: " + getPerimeter());
	}
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	@Override
	public void setRadius(int i) {
		// TODO Auto-generated method stub
		this.radius=i;
		
	}
	public void setLength(int i) {
		// TODO Auto-generated method stub
		System.out.println("null");
	}
	@Override
	public void setWidth(int i) {
		// TODO Auto-generated method stub
		System.out.println("null");
		
	}

}
