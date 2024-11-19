package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Question;
import util.Util;

public class Questiondao {
	public void savequestion(Question question) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		ses.save(question);
		trans.commit();
		ses.close();
		
	}
	public List<Question> getallquestions(){
		Session ses=Util.getSessionFactory().openSession();
		List<Question> questions=ses.createQuery("from Question",Question.class).list();
		ses.close();
		return questions;
	}
	public void updatequestions(Question question) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		ses.update(question);
		trans.commit();
		ses.close();
		
	}
	public void deletequestion(int questionid) {
		Session ses=Util.getSessionFactory().openSession();
		Transaction trans=ses.beginTransaction();
		Question question=ses.get(Question.class, questionid);
		if(question!=null) {
			ses.delete(question);
		}
		trans.commit();
		ses.close();
	}

}
