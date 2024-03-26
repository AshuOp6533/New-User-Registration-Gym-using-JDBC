package com.jspiders.gymuserregisteration.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPerson {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public void addingPerson(Scanner scanner) {
		System.out.println("Enter how many persons do you want to add");
		int count = scanner.nextInt();

		try {
			openConnection();

			for (int i = 0; i < count; i++) {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				scanner.nextLine(); 
				System.out.println("Enter the name of person");
				String name = scanner.nextLine();
				System.out.println("Enter the age of the person");
				int age = scanner.nextInt();
				scanner.nextLine(); 
				System.out.println("Enter the email of the person");
				String email = scanner.nextLine();
				System.out.println("Enter the membership type of the person");
				String membership = scanner.nextLine();
				System.out.println("Enter the mobile number of the person");
				String mobile = scanner.nextLine();
				System.out.println("Enter the date of joining (YYYY-MM-DD)");
				String doj = scanner.nextLine();

				query = "INSERT INTO personinfo VALUES (?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setInt(3, age);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5, membership);
				preparedStatement.setString(6, mobile);
				preparedStatement.setString(7, doj);
				preparedStatement.executeUpdate(); 
			}
			System.out.println("Person(s) added successfully");
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
