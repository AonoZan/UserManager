
package org.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bildit.DTO.User;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class UserDAOImplementation implements UserDAOInterface{
	
	Connection connection = ConnMan.getInstance().getConnection();
	
	private static final String SELECT_TABLE_SQL = 
			  "CREATE DATABASE IF NOT EXISTS userManager;\n"
			+ "USE userManager;\n"
			+ "CREATE TABLE IF NOT EXISTS users (\n"
			+ "  id INT PRIMARY KEY,\n"
			+ "  name VARCHAR(80),\n"
			+ "  password INT(4),\n"
			+ "  age INT(3)\n"
			+ ");";
	
	
	private void createTable() throws SQLException {
		try (
				PreparedStatement statement = connection.prepareStatement(SELECT_TABLE_SQL)){
			statement.executeUpdate();
		}
	}
	
	@Override
	public void updateName(User user, String newName) throws SQLException {
		updateString(user.getId(), "name", newName);
	}
	@Override
	public void updatePass(User user, int newPass) throws SQLException {
		updateInt(user.getId(), "pass", newPass);
	}
	@Override
	public void updateAge(User user, int newAge) throws SQLException {
		updateInt(user.getId(), "age", newAge);
	}
	
	public void updateString(int id, String attribute, String newValue) throws SQLException {
		String sqlString = "UPDATE users SET " + attribute + " = ? WHERE id = ?;";
		
		try (
				PreparedStatement statement = connection.prepareStatement(SELECT_TABLE_SQL + sqlString)){
			
			statement.setString(1, newValue);
			statement.setInt(2, id);
			
			statement.executeUpdate();
			System.out.println("Name updated.");
		}
	}
	public void updateInt(int id, String attribute, int newValue) throws SQLException {
		String sqlString = "UPDATE users SET " + attribute + " = ? WHERE id = ?;";
		
		try (
				PreparedStatement statement = connection.prepareStatement(SELECT_TABLE_SQL + sqlString)){
			
			statement.setInt(1, newValue);
			statement.setInt(2, id);
			
			statement.executeUpdate();
			System.out.println("Name updated.");
		}
	}

	@Override
	public void addUser(User user) throws SQLException {
		String sqlString = "INSERT INTO users VALUES ( ?, ?, ?);";
		
		try (
				PreparedStatement statement = connection.prepareStatement(SELECT_TABLE_SQL + sqlString)){
			
			statement.setString(1, user.getName());
			statement.setInt(2, user.getPass());
			statement.setInt(3, user.getPass());
			
			statement.executeUpdate();
			
			System.out.println("User added.");
		}
	}

	@Override
	public User getUser(String name, int pass) throws SQLException {
		String sqlQuery = "USE userManager;  SELECT * FROM users WHERE name = ? AND password = ?";
		
		ResultSet rs = null;
		User user = null;

		try (
				PreparedStatement statement =
				connection.prepareStatement(sqlQuery);) {
			statement.setString(1, name);
			statement.setInt(2, pass);
			
			createTable();
			rs = statement.executeQuery();

			if (rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("pass"),
						rs.getInt("age"));
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}
	@Override
	public void printUser(User user){
		System.out.printf
				( "ID: %d\n"
				+ "Name: %s\n"
				+ "Pass: %d\n"
				+ "Age: %d\n"
				, user.getId()
				, user.getName()
				, user.getPass()
				, user.getAge());
	}
}

