package pack_3;

import java.util.ArrayList;
import java.util.List;
record Employee(String name) implements QueryItem {

	@Override
	public boolean matchFieldValue(String fieldName, String value) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
public class Main {
	
		public static void main(String... args) {
			int studentCount = 10; 
			List<Student> students = new ArrayList<>();
			for (int i =0; i<=studentCount;i++) {
				students.add(new Student());
			}
			printList(students);
			
			List<LPAStudent> lpaStudents = new ArrayList<>();
			for (int i =0; i<=studentCount;i++) {
				lpaStudents.add(new LPAStudent());
			}
			printList(lpaStudents);
			
			
			var queryList = new QueryList<>(lpaStudents);
			var matches = queryList.getMatchs("Course", "java");
			printList(matches);
			
			var students2021 = QueryList.getMatchs(students,"YearStarted", "2021");
			printList(students2021);
			
			//QueryList<Employee> employee = new QuetyList<>();
		}
		
		public static  void printList(List<? super LPAStudent> student) {
			for (var a : student) {
				System.out.println(a);
			}
			System.out.println();		}
}

	

