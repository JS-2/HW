import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMgrImpl implements EmpMgr{
	private static EmpMgrImpl singleton = null;
	
	private EmpMgrImpl() {}
	
	static public EmpMgrImpl getInstance() {
		if(singleton == null) singleton = new EmpMgrImpl();	
		return singleton;
	}
	
	public Connection getConnection() {
		String Driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String id = "ssafy";
		String password = "ssafy";
		Connection connection = null;
		
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void close(AutoCloseable ac) {
		try {
			if (ac != null) ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Employee b) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		String sql = "insert into employee (empNo, name, position, dept) values (?, ?, ?, ?)";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, b.getEmpNo());
			pStatement.setString(2, b.getName());
			pStatement.setString(3,  b.getPosition());
			pStatement.setString(4, b.getDept());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStatement);
			close(connection);
		}
	}

	@Override
	public ArrayList<Employee> search() {
		ArrayList<Employee> employees = null;
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		String sql = "select * from employee";
		
		try {
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			employees = new ArrayList<>();
			while(rSet.next()) {
				employees.add(new Employee(rSet.getInt("empNo")
						, rSet.getString("name")
						, rSet.getString("position")
						, rSet.getString("dept") ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStatement);
			close(connection);
		}
		
		return employees;
	}

	@Override
	public Employee search(int empNo) {
		Employee employee = null;
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		String sql = "select * from employee where empNo = ?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, empNo);
			rSet = pStatement.executeQuery();
			rSet.next();
			employee = new Employee(rSet.getInt("empNo")
						, rSet.getString("name")
						, rSet.getString("position")
						, rSet.getString("dept") );
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStatement);
			close(connection);
		}
		
		return employee;
	}

	@Override
	public ArrayList<Employee> search(String name) {
		ArrayList<Employee> employees = null;
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		String sql = "select * from employee where name like ?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, "%" + name + "%");
			rSet = pStatement.executeQuery();
			employees = new ArrayList<>();
			while(rSet.next()) {
				employees.add(new Employee(rSet.getInt("empNo")
						, rSet.getString("name")
						, rSet.getString("position")
						, rSet.getString("dept") ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStatement);
			close(connection);
		}
		
		return employees;
	}

	@Override
	public void update(int empNo, String dept) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		String sql = "update employee set dept = ? where empNo = ?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, dept);
			pStatement.setInt(2, empNo);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStatement);
			close(connection);
		}
		
	}

	@Override
	public void delete(int empNo) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		String sql = "delete from employee where empNo = ?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, empNo);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStatement);
			close(connection);
		}
	}

}
