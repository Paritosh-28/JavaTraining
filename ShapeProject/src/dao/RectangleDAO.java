package dao;

import shapes.Rectangle;
import shapes.Shape;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import customexceptions.DAOException;

public class RectangleDAO implements ShapeDAO {
    private static final String INSERT_QUERY = "INSERT INTO shapes (type, length, width) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT type, length, width FROM shapes WHERE type = 'Rectangle'";

    private Connection connection;

    public RectangleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertShape(Shape shape) throws DAOException {
        Rectangle rectangle = (Rectangle) shape;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, "Rectangle");
            preparedStatement.setDouble(2, rectangle.getLength());
            preparedStatement.setDouble(3, rectangle.getWidth());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	throw new DAOException("Failed to insert rectangle in the database.", e);
        	 
        }
    }

    @Override
    public List<Shape> getAllShapes()throws DAOException {
        List<Shape> rectangleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                double length = resultSet.getDouble("length");
                double width = resultSet.getDouble("width");
                Rectangle rectangle = new Rectangle(length, width);
                rectangleList.add(rectangle);
            }
        } catch (SQLException e) {
        	throw new DAOException("Failed to retrieve rectangle info from the database.", e);

        }
        return rectangleList;
    }
    
    private static final String UPDATE_QUERY = "UPDATE shapes SET length = ?, width = ? WHERE type = 'Rectangle'";
    private static final String DELETE_QUERY = "DELETE FROM shapes WHERE type = 'Rectangle'";

    @Override
    public void updateShape(Shape shape)throws DAOException {
        Rectangle rectangle = (Rectangle) shape;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setDouble(1, rectangle.getLength());
            preparedStatement.setDouble(2, rectangle.getWidth());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("failed to update rectangle in database", e);
            
        }
    }

    @Override
    public void deleteShape(Shape shape) throws DAOException{
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        	throw new DAOException("failed to delete rectangle in database", e);  
            
        }
    }
}