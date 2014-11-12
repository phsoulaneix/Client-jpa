package com.formation.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.UserDAO;
import com.formation.entity.User;
import com.formation.manager.UserManager;

/**
 * The Class UserManagerImpl.
 */
@Service
public class UserManagerImpl implements UserManager {

	/** The user dao. */
	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see com.formation.manager.UserManager#insertUser(com.formation.model.User)
	 */
	@Override
	@Transactional
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	/* (non-Javadoc)
	 * @see com.formation.manager.UserManager#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

}
