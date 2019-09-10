package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kr.co.itcen.bookmall.vo.Book;

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
	public List<Book> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<Book> result = new ArrayList<Book>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select * from book order by no asc";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	String title = rs.getString(2);
	        	Long price = rs.getLong(3);
	        	Long category_no=rs.getLong(4);
	        	Book vo = new Book();
	        	vo.setNo(no);
	        	vo.setCategorynum(category_no);
	        	vo.setPrice(price);
	        	vo.setTitle(title);
	        	result.add(vo);
	         }
	      }catch (SQLException e) {
	         System.out.println("error : " + e);
	      }finally {
	         try {
	        	if(rs!=null) {
	        		rs.close();
	        	}
	            if (pstmt != null) {
	               pstmt.close();
	            }
	            if (connection != null) {
	               connection.close();
	            }
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      return result;
	}
	public void delete() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    try {
	    	connection = getConnection();
	    	String sql = "delete from book";
	        pstmt = connection.prepareStatement(sql);
	        pstmt.executeUpdate();
	      }catch (SQLException e) {
	    	  System.out.println("error : " + e);
	      }finally {
	    	  try{
	    		  if (pstmt != null) {
	              pstmt.close();
	            }
	    		  if(connection != null) {
	    			  connection.close();
	            }
	    	  }catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	}
	public Boolean update(Book vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "update book set price = ? where no=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getPrice());
			pstmt.setLong(2, vo.getNo());
			int count = pstmt.executeUpdate();
			pstmt.executeQuery();
			result = (count==1);
		    
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
}
