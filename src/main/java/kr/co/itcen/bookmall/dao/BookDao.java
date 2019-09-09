package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.Category;

public class BookDao {

	public Boolean insert(Book vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "insert into book values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			
			Scanner sc = new Scanner(System.in);
			if(vo.getCategorynum()==null) {
				System.out.print("추가할 category 입력:");
				String input=sc.nextLine();
				CategoryDao dao =new CategoryDao();
				Category vo1 = new Category();
				vo1.setCategory(input);
				dao.insert(vo1);
				stmt=connection.createStatement();
				rs =stmt.executeQuery("select last_insert_id()");
				if(rs.next()) {
					Long no=rs.getLong(1);
				    vo.setCategorynum(no);
				}
			}
			pstmt.setLong(3, vo.getCategorynum());
			int count = pstmt.executeUpdate();
		    result = (count==1);
		    
		    stmt=connection.createStatement();
		    rs =stmt.executeQuery("select last_insert_id()");
		    if(rs.next()) {
		    	Long no=rs.getLong(1);
		        vo.setNo(no);
		    }
		}catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try{
				if(pstmt != null) {
					pstmt.close();
		        }if(rs!=null) {
		        	rs.close();
		        }if(stmt!=null) {
		        	stmt.close();
		        }if(connection != null){
		        	connection.close();
		        }
		     }catch (Exception e) {
		    	 e.printStackTrace();
		     }
		 }
		 return result;
	}
	private Connection getConnection() throws SQLException{
		Connection connection=null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
	        String url = "jdbc:mariadb://192.168.1.86:3306/bookmall?characterEncoding=utf8";
	        connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		}catch (ClassNotFoundException e) {
	         System.out.println("Fail to Loading Driver :" + e);
	    }
		return connection;
	}
	
}
