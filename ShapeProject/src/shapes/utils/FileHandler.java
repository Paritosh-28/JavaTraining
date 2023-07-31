package shapes.utils;
import shapes.Shape;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
public static void writeShapestoFile(List<Shape>shapes , String filename)
{
	try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(filename)))
	{
		outputStream.writeObject(shapes);
		System.out.println("Shapes written to file: " + filename);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

public static List<Shape> readShapesFromFile(String filename)
{
	List<Shape> shapes=new ArrayList<>();
	 try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
         shapes = (List<Shape>) inputStream.readObject();
         System.out.println("Shapes read from file: " + filename);
     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
	 return shapes;
}
}
