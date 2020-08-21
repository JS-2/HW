import java.util.ArrayList;
import java.util.Iterator;

public class EmpTest {

	public static void main(String[] args) {
		Employee employee;
		ArrayList<Employee> employees;
		Iterator<Employee> iter;
		EmpMgrImpl empMgrImpl = EmpMgrImpl.getInstance();
		
		// add() test
		empMgrImpl.add(new Employee(1, "김재성", "부장", "SW연구소"));
		empMgrImpl.add(new Employee(2, "김죄송", "사원", "HW연구소"));
		empMgrImpl.add(new Employee(3, "김바보", "대리", "SW연구소"));
		
		// search() test
		employees = empMgrImpl.search();
		iter = employees.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		// search(int empNo) test
		employee = empMgrImpl.search(2);
		System.out.println(employee);
		
		// search(String name) test
		employees = empMgrImpl.search("김");
		iter = employees.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		// update(int empNo, String dept) test
		empMgrImpl.update(3, "HW연구소");
		
		// delete(int empNo) test
		empMgrImpl.delete(2);
	}

}
