package pack_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String... args) {
		List<Employee> list = new ArrayList<>(List.of(	
			new Employee(10001, "Ralph", 2015), 
			new Employee(10005, "Carole", 2020), 
			new Employee(12021, "Lora", 2018), 
			new Employee(13451, "Jane", 2012)));
		
		list.sort(new Employee.EmployeeCmparator<Employee>("yearStarted"));
		
		for (Employee e :list) {
			System.out.println(e);
			
		System.out.println();	
		List<StoreEmployee> listEmployee = new ArrayList<>(List.of(	
					new StoreEmployee(10001, "Ralph", 2015, "Target"), 
					new StoreEmployee(10005, "Carole", 2020,"Warmalt"), 
					new StoreEmployee(12021, "Lora", 2018,"Macys"), 
					new StoreEmployee(13451, "Jane", 2012,"Warmalt")));
		
		var genericEmployee = new StoreEmployee();
		var comparator =  genericEmployee.new StoreComparator<>();
		listEmployee.sort(comparator);
		for(StoreEmployee e1 : listEmployee) {
			System.out.println(e1);
		}
		
		System.out.println("With Pig latin names"); 
		addPigLatinName(listEmployee);
		
		}
	}
	public static void addPigLatinName(List<? extends StoreEmployee> list) {
		class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>	 {
			private String pigLatinName; 
			private Employee originalInstance;
			
			
			public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
				this.pigLatinName = pigLatinName;
				this.originalInstance = originalInstance;
			}
			@Override
			public String toString() {
				return originalInstance.toString() + " " + pigLatinName;
			}
			@Override
			public int compareTo(DecoratedEmployee o) {
				return	pigLatinName.compareTo(o.pigLatinName);
			}
			
			
			
		}
		List<DecoratedEmployee> newList = new ArrayList(list.size());	
		
		for(var employee: list) {
			String name = employee.getName(); 
			String pigLatin = name.substring(1)+name.charAt(0)+"ay";
			newList.add(new DecoratedEmployee(pigLatin,employee));
		}
		newList.sort(null);
		for(var dEmployee: newList) {
			System.out.println(dEmployee);
		}
	}
	
}
