package pack_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
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
	 List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);
	 
	 Set<Task> assignedTask = getUnion(sets); 
	 sortAndPrint("AssignedTask ", assignedTask);
	 
	 Set<Task> everyTask = getUnion(List.of(assignedTask, tasks)); 
	 sortAndPrint("Set All task True ", everyTask);
	 
	 Set<Task> missingTasks = getDifference(everyTask, tasks); 
	 sortAndPrint("Missing tasks  ", missingTasks);
	 
	 Set<Task> unassignedTasks = getDifference(tasks, assignedTask); 
	 sortAndPrint("Unassigned tasks  ", unassignedTasks, sortByPriority);
	 
	 Set<Task> overlap = getUnion(List.of(
			 getIntersect(annsTasks, bobsTasks),
			 getIntersect(carolsTasks, bobsTasks),
			 getIntersect(annsTasks, carolsTasks)
			 ));
	 sortAndPrint("Assigned to multiples  ", overlap, sortByPriority);
	 
	 List<Task> overlaping = new ArrayList<>(); 
	 for (Set<Task> set : sets) {
		 Set<Task> dupes = getIntersect(set, overlap); 
		 overlaping.addAll(dupes);
	 }
	 Comparator<Task> priorityNatural = sortByPriority.thenComparing(Comparator.naturalOrder());
	 
	 sortAndPrint("Overlappng ", overlaping, priorityNatural);
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
 
 // A U B
 private static Set<Task> getUnion(List<Set<Task>> sets){
	 Set<Task> union = new HashSet<>();
	 for (var taskSet: sets) {
		 union.addAll(taskSet);
	 }
	return union;
	 
	 
 }
 

 private static Set<Task> getIntersect(Set<Task> a, Set<Task> b){
	 Set<Task> setA = new HashSet<>(a);
	 setA.retainAll(b);
	 return setA;
 }
 
 
 private static Set<Task> getDifference(Set<Task> a, Set<Task> b){
	 Set<Task> result = new HashSet<>(a); 
	 result.removeAll(b);
	 return result;
 }
 
}
