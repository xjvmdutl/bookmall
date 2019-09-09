package kr.co.itcen.bookmall.daotest;
import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.User;

public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
		
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		UserDao dao=new UserDao();
		User vo1 = new User();
		vo1.setName("김준호1");
		vo1.setPhone("010-5196-3977");
		vo1.setEmail("widn45@naver.com");
		vo1.setPassword("1234");
		dao.insert(vo1);
		
		User vo2 = new User();
		vo2.setName("김준호2");
		vo2.setPhone("010-1234-5678");
		vo2.setEmail("xjvmdutl@gmail.com");
		vo2.setPassword("4567");
		dao.insert(vo2);
		
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		UserDao dao= new UserDao();
		List<User> list=dao.getList();
		for(User user:list) 
			System.out.println(user);
	}
	private static void deleteAllTest() {
		System.out.println("delete test---------------");
		new UserDao().delete();
	}
}
