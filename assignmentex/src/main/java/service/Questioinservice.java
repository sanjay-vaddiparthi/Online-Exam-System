package service;

import java.util.List;

import dao.Questiondao;
import entity.Question;

public class Questioinservice {
	private Questiondao questiondao=new Questiondao();
	
	public void addquestion(Question question) {
		questiondao.savequestion(question);
	}
	
	public List<Question> getallquestions(){
		return questiondao.getallquestions();	}
	
	public void updatequestion(Question question) {
		questiondao.updatequestions(question);
	}
	
	public void deleletequestion(int questionid) {
		questiondao.deletequestion(questionid);
	}
	

}
