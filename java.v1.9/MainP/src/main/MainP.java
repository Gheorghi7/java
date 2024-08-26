package main;
import main.DayOfTheWeek;
import java.util.ArrayList;
import java.util.List;


public class MainP {
	public static void main(String... args) {
	ArrayList<String> list = new ArrayList<>(List.of("a","b","c","d"));
	iterateElement(list);
	
	}
	public static String iterateElement(ArrayList<String> list) {
		var iterator = list.iterator();
		var previos = list.getFirst();
		while(iterator.hasNext()) {
			var next = iterator.next();
			System.out.println(previos + " " +next);
			previos = next;
			if (previos.equals("b")) {
				break;
			}
		}
		
		
		return "";
	}
	
	public static Integer arragucu(int i) {
		return i;
	}
}
