package dao;

import shapes.Circle;
import shapes.Shape;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import customexceptions.DAOException;

public class CircleDAO implements ShapeDAO {
    private static final String INSERT_QUERY = "INSERT INTO shapes (type, radius) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT type, radius FROM shapes WHERE type = 'Circle'";

    private Connection connection;

    public CircleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertShape(Shape shape) throws DAOException{
        Circle circle = (Circle) shape;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, "Circle");
            preparedStatement.setDouble(2, ((Circle) circle).getRadius());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	throw new DAOException("Failed to insert Circle in the database.", e);
 
        }
    }

    @Override
    public List<Shape> getAllShapes() throws DAOException {
        List<Shape> circleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                double radius = resultSet.getDouble("radius");
                Circle circle = new Circle(radius);
                circleList.add(circle);
            }
        } catch (SQLException e) {
        	throw new DAOException("Failed to retrieve Circle info from the database.", e);

        }
        return circleList;
    }
    private static final String UPDATE_QUERY = "UPDATE shapes SET radius = ? WHERE type = 'Circle'";
    private static final String DELETE_QUERY = "DELETE FROM shapes WHERE type = 'Circle'";

    @Override
    public void updateShape(Shape shape) throws DAOException{
        Circle circle = (Circle) shape;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setDouble(1, circle.getRadius());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("failed to update circle in database", e);
        
        }
    }

    @Override
    public void deleteShape(Shape shape) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	throw new DAOException("failed to delete circle in database", e);  
        
        }
    }
}