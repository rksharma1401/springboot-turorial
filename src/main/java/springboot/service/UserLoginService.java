/**
 * 
 */
package springboot.service;

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
	
	public static boolean isValid(int id) throws Exception {
		System.out.println("inside validation");
		 
		Session session=HibernateConnection.getSession();
		Transaction tx=session.beginTransaction();
		User user=(User) session.get(User.class, id);
		tx.commit();
		 if(user!=null){
			 return true; 
		 }
		return false;
	}

	 
}
