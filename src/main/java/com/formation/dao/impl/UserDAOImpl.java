package com.formation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.formation.dao.UserDAO;
import com.formation.entity.User;

/**
 * The Class UserDAOImpl.
 */
@Repository
public class UserDAOImpl implements UserDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.formation.dao.UserDAO#insertUser(com.formation.model.User)
	 */
	@Override
	public void insertUser(User user) {
		entityManager.persist(user);
	}

	/* (non-Javadoc)
	 * @see com.formation.dao.UserDAO#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<User> cq = builder.createQuery(User.class);
		final Root<User> root = cq.from(User.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

}
