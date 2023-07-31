package shapes;
import java.io.Serializable;
public class Rectangle implements Serializable,Shape{
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length*width);
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle - Length: " + length + ", Width: " + width + ", Area: " + getArea() + ", Perimeter: " + getPerimeter());
		
	}

	public double getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void setRadius(int i) {
		// TODO Auto-generated method stub
		System.out.println("null");
		
	}

	@Override
	public void setLength(int i) {
		// TODO Auto-generated method stub
		this.length=i;
	}

	@Override
	public void setWidth(int i) {
		// TODO Auto-generated method stub
		this.width=i;
	}

	

}
