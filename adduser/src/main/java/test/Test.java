package test;

import java.util.List;

import dao.UserDAO;
import entity.User;

public class Test {

	public static void main(String[] args) throws Exception {
//		System.out.println(DBUtils.getConn());
//		
		UserDAO dao = new UserDAO();
//		List<User> users = dao.findAll();
//		System.out.println(users);
		
		User user = new User();
		user.setUsername("°Ý°Ý");
		user.setPassword("1233455");
		user.setEmail("tedu@1254fee");
		dao.save(user);
		
		


		
		
	}

}
