import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	
	// 연결객체 생성, 반환
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void close(Connection connection) {
		try {
			if(connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
   public void close(PreparedStatement statement) {//매개변수 전달된 Statement객체에 대한 자원반환
	   try {
		   if(statement != null) statement.close();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
   }
   
   public void close(ResultSet resultSet) {//매개변수 전달된 결과집합객체에 대한 자원반환
	   try {
		   if(resultSet != null) resultSet.close();
	   } catch (SQLException e) {
		e.printStackTrace();
	   }
   }
	
	// name을 포함한 모든 상품 반환
	public ArrayList<Product> searchWithName(String name) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ArrayList<Product> products = new ArrayList<>();
		
		String sql= "select * from product where name like ?";
		connection = getConnection();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, "%" + name + "%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				products.add(new Product(resultSet.getString("isbn")
						, resultSet.getString("name")
						, resultSet.getInt("price")
						, resultSet.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pStatement);
			close(connection);
		}
		
		return products;
	}
	// price 이하의 가격의 모든 상품을 반환
	public ArrayList<Product> searchWithPrice(int price) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ArrayList<Product> products = new ArrayList<>();
		
		String sql= "select * from product where price <= ?";
		connection = getConnection();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, price);
			resultSet = pStatement.executeQuery();
		 
			while(resultSet.next()) {
				products.add(new Product(resultSet.getString("isbn")
						, resultSet.getString("name")
						, resultSet.getInt("price")
						, resultSet.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pStatement);
			close(connection);
		}
		
		return products;
	}
	// isbn으로 상품 검색 후 반환
	public Product searchWithIsbn(String isbn) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Product product = null;
		
		String sql= "select * from product where isbn = ?";
		connection = getConnection();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, isbn);
			resultSet = pStatement.executeQuery();
			resultSet.next();
			product = new Product(resultSet.getString("isbn")
					, resultSet.getString("name")
					, resultSet.getInt("price")
					, resultSet.getInt("quantity"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pStatement);
			close(connection);
		}
		
		return product;
	}
	// isbn으로 상품 제거 
	public void deleteWithIsbn(String isbn) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		String sql= "delete from product where isbn = ?";
		connection = getConnection();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, isbn);
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pStatement);
			close(connection);
		}
	}
	// isbn과 price로 찾은 상품 price 수정
	public void updatePrice(String isbn, int oldPrice, int newPrice) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		String sql= "update product set price = ? where isbn = ? and price = ?";
		connection = getConnection();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, newPrice);
			pStatement.setString(2, isbn);
			pStatement.setInt(3, oldPrice);
			pStatement.executeUpdate();
		 } catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pStatement);
			close(connection);
		}
	}
}
