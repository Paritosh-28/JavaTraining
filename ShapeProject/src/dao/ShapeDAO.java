package dao;

import shapes.Shape;

import java.util.List;

import customexceptions.DAOException;
public interface ShapeDAO {
    void insertShape(Shape shape) throws DAOException;
    List<Shape> getAllShapes() throws DAOException;
    void updateShape(Shape shape) throws DAOException;
    void deleteShape(Shape shape) throws DAOException;
}