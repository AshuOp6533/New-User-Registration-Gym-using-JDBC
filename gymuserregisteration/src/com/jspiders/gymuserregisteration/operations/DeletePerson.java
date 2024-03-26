package com.jspiders.gymuserregisteration.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePerson {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public void deletingPersonById(Scanner scanner) {
		System.out.println("Enter ID of the person to delete:");
		int id = scanner.nextInt();
		scanner.nextLine(); 

		try {
			openConnection();

			query = "DELETE FROM personinfo WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Person with ID " + id + " deleted successfully");
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

	public void deletingPersonByName(Scanner scanner) {
		System.out.println("Enter name of the person to delete:");
		String name = scanner.nextLine();

		try {
			openConnection();

			query = "DELETE FROM personinfo WHERE name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Person with name " + name + " deleted successfully");
			} else {
				System.out.println("No person found with name: " + name);
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
