package service;

import dao.Userdao;
import entity.User;
public class Userservices {
	private Userdao userdao=new Userdao();
	
	public void registeruser(User user) {
		userdao.saveuser(user);
	}
	public User login(String email, String password) {
		return userdao.loginwithemailandpassword(email, password);
	}
	
	public void updateuser(User user) {
		userdao.updateuser(user);
	}
	
	public void deleteuser(int userid) {
		userdao.delteuser(userid);
	}
	public User getuserbyid(int userid) {
		return userdao.getuserbyid(userid);
	}
	public boolean isAdmin(User user) {
        return "Admin".equalsIgnoreCase(user.getRole());
    }
}
