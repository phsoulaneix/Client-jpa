package com.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.entity.User;
import com.formation.manager.UserManager;

/**
 * The Class HelloServlet.
 */
public class HelloServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3710394419902888789L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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

		req.setAttribute("nb", list.size());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
		.forward(req, resp);
	}
}
