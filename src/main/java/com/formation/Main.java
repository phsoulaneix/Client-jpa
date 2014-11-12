package com.formation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.entity.User;
import com.formation.manager.UserManager;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final UserManager userManager = (UserManager) ctx
				.getBean("userManagerImpl");

		List<User> list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());

		final User user = new User();
		user.setUsername("johndoe");
		user.setName("John Doe");
		userManager.insertUser(user);
		System.out.println("User inserted!");

		list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());

	}
}
