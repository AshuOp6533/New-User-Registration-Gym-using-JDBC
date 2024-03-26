package com.jspiders.gymuserregisteration.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectPerson {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public void searchAllPersons() {
		try {
			openConnection();

			query = "SELECT * FROM personinfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String email = resultSet.getString("email");
				String membership = resultSet.getString("membership");
				double mobile = resultSet.getDouble("mobile");
				String doj = resultSet.getString("doj");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("Email: " + email);
				System.out.println("Membership: " + membership);
				System.out.println("Mobile: " + mobile);
				System.out.println("Date of Joining: " + doj);
				System.out.println();
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

	public void searchPersonById(Scanner scanner) {
		System.out.println("Enter the id of Person");
		int id  = scanner.nextInt();		
		try {
			openConnection();

			query = "SELECT * FROM personinfo WHERE id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Age: " + resultSet.getInt(3));
                System.out.println("Email: " + resultSet.getString(4));
                System.out.println("Membership: " + resultSet.getString(5));
                System.out.println("Mobile: " + resultSet.getDouble(6));
                System.out.println("Date of Joining: " + resultSet.getString(7));
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
	
	public void searchPersonByName(Scanner scanner) {
        System.out.println("Enter name of the person");
        String name = scanner.nextLine();

        try {
            openConnection();

            query = "SELECT * FROM personinfo WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Age: " + resultSet.getInt(3));
                System.out.println("Email: " + resultSet.getString(4));
                System.out.println("Membership: " + resultSet.getString(5));
                System.out.println("Mobile: " + resultSet.getDouble(6));
                System.out.println("Date of Joining: " + resultSet.getString(7));
            } else {
                System.out.println("Person not found");
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

    public void searchPersonByAge(Scanner scanner) {
        System.out.println("Enter age of the person");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        try {
            openConnection();

            query = "SELECT * FROM personinfo WHERE age = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, age);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Age: " + resultSet.getInt(3));
                System.out.println("Email: " + resultSet.getString(4));
                System.out.println("Membership: " + resultSet.getString(5));
                System.out.println("Mobile: " + resultSet.getDouble(6));
                System.out.println("Date of Joining: " + resultSet.getString(7));
            } else {
                System.out.println("Person not found");
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

    public void searchPersonByDOJ(Scanner scanner) {
        System.out.println("Enter date of joining (YYYY-MM-DD)");
        String doj = scanner.nextLine();

        try {
            openConnection();

            query = "SELECT * FROM personinfo WHERE doj = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doj);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Age: " + resultSet.getInt(3));
                System.out.println("Email: " + resultSet.getString(4));
                System.out.println("Membership: " + resultSet.getString(5));
                System.out.println("Mobile: " + resultSet.getDouble(6));
                System.out.println("Date of Joining: " + resultSet.getString(7));
            } else {
                System.out.println("Person not found");
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

}
