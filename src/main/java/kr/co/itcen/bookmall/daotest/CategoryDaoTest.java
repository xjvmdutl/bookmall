package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.Category;

public class CategoryDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
		
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		CategoryDao dao =new CategoryDao();
		Category vo1 = new Category();
		vo1.setCategory("컴퓨터");
		dao.insert(vo1);
		
		Category vo2 = new Category();
		vo2.setCategory("사회");
		dao.insert(vo2);
	
		Category vo3 = new Category();
		vo3.setCategory("인문");
		dao.insert(vo3);
		
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		CategoryDao dao= new CategoryDao();
		List<Category> list=dao.getList();
		for(Category cat:list) 
			System.out.println(cat);
	}
	private static void deleteAllTest() {
		System.out.println("delete test---------------");
		new CategoryDao().delete();
	}
}
