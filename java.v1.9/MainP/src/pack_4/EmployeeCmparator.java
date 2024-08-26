package pack_4;

import java.util.Comparator;

public class EmployeeCmparator <T extends Employee> implements Comparator<Employee> {
	


	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}