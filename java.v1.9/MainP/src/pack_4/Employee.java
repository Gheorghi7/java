package pack_4;

import java.util.Comparator;

public class Employee {
		 private int employeeId; 
		 private String name; 
		 private int yearStarted;
		
		//NASTED CLASS
				public static class EmployeeCmparator <T extends Employee> implements Comparator<Employee> {
				
					private String sortType; 
					
					
					public EmployeeCmparator(String sortType) {
						this.sortType = sortType;
					}
					public EmployeeCmparator() {
						
					}


					@Override
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						if( sortType.equalsIgnoreCase("yearStarted")){
						return o1.yearStarted - (o2.yearStarted);
						}
						return o1.name.compareTo(o2.name);
					}
					
				}
				
		//
				public Employee() {
					
				}
		public Employee(int employeeId, String name, int yearStarted) {
			this.employeeId = employeeId;
			this.name = name;
			this.yearStarted = yearStarted;
		}
		public String getName() {
			return name;
		}
		@Override
		public String toString() {
			return "%d %-8s %d".formatted(employeeId, name, yearStarted				);
		} 
		
		
		 
		 
}
