package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.User;
import util.Util;

public class Userdao {
	public void saveuser(User user) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		ses.save(user);
		trans.commit();
		ses.close();		
	}
	public User loginwithemailandpassword(String email,String password) {
		Session ses=Util.getSessionFactory().openSession();
		User user=(User) ses.createQuery("from User where email=:email and password=:password",User.class)
				.setParameter("email",email)
				.setParameter("password", password)
				.uniqueResult();
		ses.close();
		return user;
		
	}
	
	public void updateuser(User user) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		ses.update(user);
		trans.commit();
		ses.close();
		
	}

	public void delteuser(int userid) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		User user=ses.get(User.class, userid);
		if(user!=null) {
			ses.delete(user);
		}
		trans.commit();
		ses.close();
		
	}
	public User getuserbyid(int userid) {
		Session ses=Util.getSessionFactory().openSession();
		User user=ses.get(User.class, userid);
		ses.close();
		return user;
	}
}
