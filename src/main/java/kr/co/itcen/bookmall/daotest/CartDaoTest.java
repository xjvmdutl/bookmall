package kr.co.itcen.bookmall.daotest;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.Cart;
import kr.co.itcen.bookmall.vo.Category;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		//selectTest();
		//deleteTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		CartDao dao =new CartDao();
		Cart vo1 = new Cart();
		vo1.setCategory("컴퓨터");
		dao.insert(vo1);
		
		Category vo2 = new Category();
		vo2.setCategory("사회");
		dao.insert(vo2);
	
		Category vo3 = new Category();
		vo3.setCategory("인문");
		dao.insert(vo3);
	}
}
