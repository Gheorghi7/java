package pack_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
	public static void main(String[] args) {
		List<StoreEmployee> listEmployee = new ArrayList<>(List.of(	
				new StoreEmployee(10001, "Ralph", 2015, "Target"), 
				new StoreEmployee(10005, "Carole", 2020,"Warmalt"), 
				new StoreEmployee(12021, "Lora", 2018,"Macys"), 
				new StoreEmployee(13451, "Jane", 2012,"Warmalt")));
		var c0 = new EmployeeCmparator<StoreEmployee>();
		var c1 = new Employee.EmployeeCmparator<StoreEmployee>();
		var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();
		
		sortIt(listEmployee, c0);
		//sortIt(listEmployee, c1);
		sortIt(listEmployee, c2);
		class NameSort<T> implements Comparator<StoreEmployee>{

			@Override
			public int compare(StoreEmployee o1, StoreEmployee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}}
		var c3 = new NameSort<StoreEmployee>();
		var c4 = new Comparator<StoreEmployee>() {

			@Override
			public int compare(StoreEmployee o1, StoreEmployee o2) {
				return o1.getName().compareTo(o2.getName());
			}};
		sortIt(listEmployee, c3);
		sortIt(listEmployee, c4);
		
	
	}
	
	public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
		System.out.println("Sorting with comparator: "+comparator.toString());
		list.sort(comparator);
		for(var employee: list) {
			System.out.println(employee);
		}
	}
}
