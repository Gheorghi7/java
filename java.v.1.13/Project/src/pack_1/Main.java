package pack_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main {
 public static void main(String[] args) {
	 Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
	 Set<Task> tasks = TaskData.getTask("all"); 
	 sortAndPrint("All Tasks", tasks);
	 
	 Set<Task> annsTasks = TaskData.getTask("Ann"); 
	 sortAndPrint("Ann`s Tasks", annsTasks);
	 sortAndPrint("Ann`s Tasks (sorted)", annsTasks, sortByPriority);
	 Set<Task> bobsTasks = TaskData.getTask("Bob"); 
	 sortAndPrint("Bob`s Tasks", bobsTasks);
	 Set<Task> carolsTasks = TaskData.getTask("Carol"); 
	 sortAndPrint("Carol`s Tasks", carolsTasks);
 }
 
 
 private static void sortAndPrint(String header, Collection<Task> collection) {
	 sortAndPrint(header , collection, null);
 }
 			
 private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {
	 String lineSeparator = "_".repeat(90);
	 System.out.println(lineSeparator);
	 System.out.println(header);
	 System.out.println(lineSeparator);
	 List<Task> list = new ArrayList<>(collection);
	 list.sort(sorter);
	 list.forEach(System.out::println);
	 
 }
}
