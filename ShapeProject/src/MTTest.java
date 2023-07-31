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
public class MTTest {
public static void main(String[] args) {
	 Shape circle = new Circle(5);
     Shape rectangle = new Rectangle(4, 6);

     // Demonstrate is-a relationship through inheritance
     Shape[] shapes = {circle, rectangle};

     for (Shape shape : shapes) {
         ShapeManager.printShapeInfo(shape);
     }

     // Passing objects to methods
     compareShapes(circle, rectangle);

     // Returning an object
     Shape largerShape = getLargerShape(circle, rectangle);
     System.out.println("Larger shape:");
     ShapeManager.printShapeInfo(largerShape);

     // File handling
     List<Shape> shapeList = new ArrayList<>();
     shapeList.add(circle);
     shapeList.add(rectangle);

     FileHandler.writeShapestoFile(shapeList, "test.txt");

     List<Shape> readShapes = FileHandler.readShapesFromFile("test.txt");
     System.out.println("Shapes read from file:");
     for (Shape shape : readShapes) {
         ShapeManager.printShapeInfo(shape);
     }

     // Multithreading for shape objects
     ShapeProcessor circleProcessor = new ShapeProcessor(circle);
     ShapeProcessor rectangleProcessor = new ShapeProcessor(rectangle);

     circleProcessor.start();
     rectangleProcessor.start();

     try {
         circleProcessor.join();
         rectangleProcessor.join();
     } catch (InterruptedException e) {
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

 // Inner class to handle multithreading for shape processing
 static class ShapeProcessor extends Thread {
     private Shape shape;

     public ShapeProcessor(Shape shape) {
         this.shape = shape;
     }

     @Override
     public void run() {
         System.out.println("Processing shape: " + shape.getClass().getSimpleName());
         shape.displayInfo();
         System.out.println("Shape processing completed: " + shape.getClass().getSimpleName());
     }
}
}
