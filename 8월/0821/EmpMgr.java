import java.util.ArrayList;

public interface EmpMgr {
	public void add(Employee b);
	public ArrayList<Employee> search();
	public Employee search(int empNo);
	public ArrayList<Employee> search(String name);
	public void update(int empNo, String dept);
	public void delete(int empNo);
}
