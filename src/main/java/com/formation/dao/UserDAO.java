package com.formation.dao;

import java.util.List;

import com.formation.entity.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO {

	/**
	 * Insert user.
	 *
	 * @param user the user
	 */
	void insertUser(User user);

	/**
	 * Find all users.
	 *
	 * @return the list
	 */
	List<User> findAllUsers();
}
