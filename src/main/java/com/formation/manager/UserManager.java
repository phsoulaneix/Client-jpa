package com.formation.manager;

import java.util.List;

import com.formation.model.User;

/**
 * The Interface UserManager.
 */
public interface UserManager {

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
