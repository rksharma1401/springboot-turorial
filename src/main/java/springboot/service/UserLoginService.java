/**
 * 
 */
package springboot.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import springboot.config.db.HibernateConnection;
import springboot.model.User;
 

/**
 * @author ravikant.sharma Nov 11, 2016
 */
public class UserLoginService {

	
	public static User createUser(User u) throws Exception{
		System.out.println("inside createUser");
		 
		Session session=HibernateConnection.getSession();
		Transaction tx=session.beginTransaction();
		Integer id=(Integer) session.save(u);
		tx.commit();
		System.out.println("createUser : User created for Id " + id);
		u.setId(id);
		return u;
	}
	
	public static User isValid(int id) throws Exception {
		System.out.println("inside validation");
		 
		Session session=HibernateConnection.getSession();
		Transaction tx=session.beginTransaction();
		User user=(User) session.get(User.class, id);
		tx.commit(); 
		return user;
	}
	
	public static List<User> getAllUser() throws Exception {
		System.out.println("inside getAllUser");
		 
		Session session=HibernateConnection.getSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> users = criteria.list();
		tx.commit(); 
		return users;
	}

	 
}
