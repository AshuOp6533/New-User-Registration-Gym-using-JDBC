package com.jspiders.gymuserregisteration.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePerson {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static String query;

    public void updatingPerson(Scanner scanner) {
        System.out.println("Enter ID of the person to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        try {
            openConnection();

            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            System.out.println("Enter new age:");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter new email:");
            String email = scanner.nextLine();
            System.out.println("Enter new membership:");
            String membership = scanner.nextLine();
            System.out.println("Enter new mobile number:");
            String mobile = scanner.nextLine();
            System.out.println("Enter new date of joining (YYYY-MM-DD):");
            String doj = scanner.nextLine();

            query = "UPDATE personinfo SET name=?, age=?, email=?, membership=?, mobile=?, doj=? WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, membership);
            preparedStatement.setString(5, mobile);
            preparedStatement.setString(6, doj);
            preparedStatement.setInt(7, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Person with ID " + id + " updated successfully");
            } else {
                System.out.println("No person found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
    }

    private static void closeConnection() throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
