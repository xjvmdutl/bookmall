package kr.co.itcen.bookmall.daotest;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.Book;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		//updatePriceTest(16L,5000L);
		selectTest();
		//deleteAllTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		BookDao dao =new BookDao();
		Book vo1 = new Book();
		vo1.setPrice(1000L);
		vo1.setTitle("노인과바다");
		vo1.setCategorynum(13L);
		dao.insert(vo1);
		
		Book vo2 = new Book();
		vo2.setPrice(10000L);
		vo2.setTitle("webmaster");
		vo2.setCategorynum(11L);
		dao.insert(vo2);
	
		Book vo3 = new Book();
		vo3.setPrice(777L);
		vo3.setTitle("차세대");
		vo3.setCategorynum(11L);
		dao.insert(vo3);
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		BookDao dao= new BookDao();
		List<Book> list=dao.getList();
		for(Book book:list) 
			System.out.println(book);
	}
	private static void deleteAllTest() {
		System.out.println("delete test---------------");
		new BookDao().delete();
	}
	public static void updatePriceTest(Long no,Long price) {
		BookDao dao =new BookDao();
		Book vo1 = new Book();
		vo1.setPrice(price);
		vo1.setNo(no);
		dao.update(vo1);
	}
}
