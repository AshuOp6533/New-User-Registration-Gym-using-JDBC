package com.jspiders.gymuserregisteration.main;

import java.util.Scanner;

import com.jspiders.gymuserregisteration.operations.AddPerson;
import com.jspiders.gymuserregisteration.operations.DeletePerson;
import com.jspiders.gymuserregisteration.operations.SelectPerson;
import com.jspiders.gymuserregisteration.operations.UpdatePerson;

public class PersonMain {
	static boolean flag = true;
	static DeletePerson deletePerson = new DeletePerson();
	static UpdatePerson updatePerson = new UpdatePerson();
	static AddPerson addPerson = new AddPerson();
	static SelectPerson selectPerson = new SelectPerson();

	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		Scanner scanner = new Scanner(System.in);

		while (flag) {
			System.out.println("Enter 1 to add the person details");
			System.out.println("Enter 2 to Search the person");
			System.out.println("Enter 3 to update the person details");
			System.out.println("Enter 4 to remove the person");
			System.out.println("Enter 5 to Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addPerson.addingPerson(scanner);
				break;
			case 2:
				searchingPerson();
				mainMenu();
				break;
			case 3:
				updatePerson.updatingPerson(scanner);
				mainMenu();
				break;
			case 4:
				deletingPerson();
				mainMenu();
				break;
			case 5:
				System.out.println("Thank You!!!");
				flag = false;
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			}
		}
		scanner.close();
	}

	private static void searchingPerson() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to search person All users");
		System.out.println("Enter 2 to search person by Id");
		System.out.println("Enter 3 to search person by name");
		System.out.println("Enter 4 to search person by age");
		System.out.println("Enter 5 to search person by Date of Joining");
		System.out.println("Enter 6 to Exit");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			selectPerson.searchAllPersons();
			break;
		case 2:
			selectPerson.searchPersonById(scanner);
			break;
		case 3:
			selectPerson.searchPersonByName(scanner);
			break;
		case 4:
			selectPerson.searchPersonByAge(scanner);
			break;
		case 5:
			selectPerson.searchPersonByDOJ(scanner);
			break;
		case 6:
			System.out.println("Thank You!!!");
			break;
		default:
			System.out.println("Enter valid choice");
			break;
		}

	}

	private static void deletingPerson() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 if you want to delete person by Id ");
		System.out.println("Enter 2 if you want to delete person by name ");
		System.out.println("Enter 3 to Exit");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			deletePerson.deletingPersonById(scanner);
			break;
		case 2:
			deletePerson.deletingPersonByName(scanner);
			break;
		case 3:
			System.out.println("Thank You!!!");
			break;
		default:
			System.out.println("Enter valid choice");
			break;
		}

	}

}
