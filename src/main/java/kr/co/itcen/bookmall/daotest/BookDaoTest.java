package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.Book;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		//selectTest();
		//deleteAllTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		BookDao dao =new BookDao();
		Book vo1 = new Book();
		vo1.setPrice(1000L);
		vo1.setTitle("노인과바다");
		vo1.setCategorynum(3L);
		dao.insert(vo1);
		
		Book vo2 = new Book();
		vo2.setPrice(2000L);
		vo2.setTitle("흥부와놀부");
		vo2.setCategorynum(null);
		dao.insert(vo2);
	
		Book vo3 = new Book();
		vo2.setPrice(3000L);
		vo3.setTitle("각시탈");
		vo3.setCategorynum(null);
		dao.insert(vo3);
	}
//	private static void selectTest() {
//		System.out.println("select test---------------");
//		CategoryDao dao= new CategoryDao();
//		List<Category> list=dao.getList();
//		for(Category cat:list) 
//			System.out.println(cat);
//	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new CategoryDao().delete();
//	}

}
