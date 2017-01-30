
package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.User;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public interface UserDAOInterface {
	public void updateName(User user, String newName) throws SQLException;
	public void updatePass(User user, int newPass) throws SQLException;
	public void updateAge(User user, int newAge) throws SQLException;
	public void addUser(User user) throws SQLException;
	public User getUser(String name, int pass) throws SQLException;
	public void printUser(User user) throws SQLException;
}

