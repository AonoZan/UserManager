
package org.bildit.zadaca;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bildit.DAO.UserDAOImplementation;
import org.bildit.DTO.User;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Main {
	private static Scanner input = new Scanner(System.in);
	private static UserDAOImplementation userDAO = new UserDAOImplementation();
	private static String name = null;
	private static int pass = 0;
	private static User user = null;
	
	public static void logInMenu() {
		while(true) {
			try {
				System.out.print("Please enter your name: ");
				name = input.nextLine();
				System.out.print(name + " enter your password: ");
				pass = input.nextInt();
				clearIn();
				
				
				user = userDAO.getUser(name, pass);
				if(user == null) {
					System.out.println("User doesn't exst or pass is not correct.");
				} else {
					userMenu();
				}
			} catch (SQLException sqle) {
				System.out.println("Error reading database.");
			} catch (InputMismatchException e) {
				System.out.println("Please enter only integers.");
				clearIn();
			}
		}
	}
	public static void userMenu() throws SQLException{
		boolean active = true;
		int option = 0;
		while(active) {
			System.out.println("Enter option:\n"
					+ "[1] Change name\n"
					+ "[2] Change pass\n"
					+ "[3] Shange age\n"
					+ "[4] See stats\n"
					+ "[5] Exit");
			option = input.nextInt();
			clearIn();
			
			switch(option) {
			case 1:
				System.out.print("Enter new name: ");
				name = input.nextLine();
				userDAO.updateName(user, name);
				break;
			case 2:
				System.out.print("Enter new pass: ");
				pass = input.nextInt();
				userDAO.updatePass(user, pass);
				break;
			case 3:
				System.out.print("Enter new age: ");
				int newAge = input.nextInt();
				userDAO.updatePass(user, newAge);
				break;
			case 4:
				userDAO.printUser(user);
				break;
			case 5:
				active = false;
				break;
			}
			
			clearIn();
			user = userDAO.getUser(name, pass);
		}
	}
	public static void registerMenu() {
		while(true) {
			try {
				System.out.print("Enter name: ");
				String newName = input.nextLine();
				System.out.print("Enter pass: ");
				int newPass = input.nextInt();
				System.out.print("Enter age: ");
				int newAge = input.nextInt();
				clearIn();
				
				User newUser = new User(0, newName, newPass, newAge);
				try {
					userDAO.addUser(newUser);
					return;
				} catch (SQLException e) {
					System.out.println("user can't be added." + e.getMessage());
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter only integers.");
				clearIn();
			}
		}
	}
	public static void clearIn() {
		input.nextLine();
	}
	public static void main(String[] args) {
		int option = 0;
		boolean active = true;
		System.out.println("Welcome to user database.");
		
		while(active) {
			try {
				System.out.println("Select option:\n"
						+ "[1] Register\n"
						+ "[2] Log in\n");
				option = input.nextInt();
				clearIn();
				
				switch (option) {
				case 1:
					registerMenu();
					break;
				case 2:
					logInMenu();
					break;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter only integers.");
				clearIn();
			}
			
		}
		
	}
}

