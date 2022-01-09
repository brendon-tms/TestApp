package com.application.testapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.application.testapp.entities.User;


public class UserDao {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();


	public void create(User user) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

	public List<User> getUsers() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<User> usersList = session.createQuery("from users").getResultList();
		
		return usersList;
	}

	public User loginUser(String email, String password) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		User user;
		String query = "from users where email='" + email + "' and password='" + password + "'";
		
		User userToLogin = (User) session.createQuery(query).uniqueResult();
		
		return userToLogin;
	}
		

}
