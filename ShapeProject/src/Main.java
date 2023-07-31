import dao.CircleDAO;
import dao.RectangleDAO;
import dao.ShapeDAO;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.utils.FileHandler;
import shapes.utils.ShapeManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import customexceptions.DAOException;
import customexceptions.InvalidShapeException;
public class Main {
public static void main(String[] args) {
	try
	{
	Shape circle=new Circle(5);
	Shape rectangle=new Rectangle(4,6);
	
	List<Shape> shapeList=new ArrayList<>();
	shapeList.add(circle);
	shapeList.add(rectangle);
	
	  for (Shape shape : shapeList) {
	         ShapeManager.printShapeInfo(shape);
	     }
//	
//	List<Thread> threads=new ArrayList<>();
//	for (Shape shape:shapeList)
//	{
//		Thread thread =new Thread();
//			
//		ShapeManager.printShapeInfo(shape);
//		threads.add(thread);
//		thread.start();
//	}
//	
//	   for (Thread thread : threads) {
//           try {
//               thread.join();
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//       }
	compareShapes(circle, rectangle);
	
	Shape largerShape=getLargerShape(circle,rectangle);
	  System.out.println("Larger shape:");
      ShapeManager.printShapeInfo(largerShape);
      
      
      List<Shape> shapeList1 = new ArrayList<>();
      shapeList1.add(circle);
      shapeList1.add(rectangle);

      FileHandler.writeShapestoFile(shapeList1, "shapes.txt");

      List<Shape> readShapes = FileHandler.readShapesFromFile("shapes.txt");
      System.out.println("Shapes read from file:");
      for (Shape shape : readShapes) {
          ShapeManager.printShapeInfo(shape);
      }
      
      ShapeProcessor circleProcessor=new ShapeProcessor(circle);
      ShapeProcessor rectangleProcessor=new ShapeProcessor(rectangle);
      circleProcessor.start();
      rectangleProcessor.start();
      try
      {
    	  
      }catch(InterruptedException e)
      {
    	  e.printStackTrace();
      }
      
      
      try  
      {
    	  System.out.println("Trying to load the driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		System.out.println("Driver loaded....");
	
		System.out.println("Trying to connect....");
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
		System.out.println("Connected : "+ connection);
          ShapeDAO circleDAO = new CircleDAO(connection);
          ShapeDAO rectangleDAO = new RectangleDAO(connection);

          for (Shape shape : shapeList1) {
              if (shape instanceof Circle) {
                  circleDAO.insertShape(shape);
              } else if (shape instanceof Rectangle) {
                  rectangleDAO.insertShape(shape);
              }
          }
          System.out.println("Shapes inserted into the database.");

          // Retrieve shape data from the database using DAO
          List<Shape> retrievedShapes = new ArrayList<>();
          retrievedShapes.addAll(circleDAO.getAllShapes());
          retrievedShapes.addAll(rectangleDAO.getAllShapes());

          System.out.println("Shapes retrieved from the database:");
          for (Shape shape : retrievedShapes) {
              ShapeManager.printShapeInfo(shape);
          }

          // Update shape data in the database using DAO
          circle.setRadius(7);
          circleDAO.updateShape(circle);
          rectangle.setLength(5);
          rectangle.setWidth(8);
          rectangleDAO.updateShape(rectangle);

          // Delete shape data from the database using DAO
          circleDAO.deleteShape(circle);
          rectangleDAO.deleteShape(rectangle);

          // Display updated shape data from the database
          retrievedShapes = new ArrayList<>();
          retrievedShapes.addAll(circleDAO.getAllShapes());
          retrievedShapes.addAll(rectangleDAO.getAllShapes());

          System.out.println("Shapes retrieved from the database after update and delete:");
          for (Shape shape : retrievedShapes) {
              ShapeManager.printShapeInfo(shape);
          }
      } catch (SQLException  | DAOException e) {
          e.printStackTrace();
      }
	}catch(InvalidShapeException e)
	{
		e.printStackTrace();
	}
	
}

public static void compareShapes(Shape shape1, Shape shape2) {
    double area1 = shape1.getArea();
    double area2 = shape2.getArea();

    String largerShape = (area1 > area2) ? "Shape 1" : "Shape 2";
    System.out.println("Comparing Shapes - " + largerShape + " has a larger area.");
}

public static Shape getLargerShape(Shape shape1, Shape shape2) {
    double area1 = shape1.getArea();
    double area2 = shape2.getArea();

    return (area1 > area2) ? shape1 : shape2;
}

static class ShapeProcessor extends Thread
{
	private Shape shape;
	public ShapeProcessor(Shape shape)
	{
		this.shape=shape;
	}
	
	public void run()
	{
		System.out.println("Processing shape: "+shape.getClass().getSimpleName());
		shape.displayInfo();
		System.out.println("Processing completed "+shape.getClass().getSimpleName());
	}
}

}

