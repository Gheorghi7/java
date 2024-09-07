package pack_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
		
		for (String s: list) {
			System.out.println(s);
		}
		System.out.println("---------");
	list.forEach((s) -> System.out.println(s));
	
	System.out.println("---------");
	
	list.forEach((var myString)->{
		char first = myString.toUpperCase().charAt(0);
		System.out.println(myString + " means " + first);
	});
	System.out.println("---------");
//	int result = calculator((a,b)->a+b, 5,10);
	
	var coords = Arrays.asList(
			new double[] {47.2170, -95.2348}, 
			new double[] {29.4432, -83.2382}, 
			new double[] {35,1213, -63.4278}
			);
	System.out.println("---------");
	coords.forEach(s -> System.out.println(Arrays.toString(s)));
	
	System.out.println("---------");
	BiConsumer<Double, Double> p1 = (lat, lng)->System.out.println("[lat:%.3f lng:%,3f]%n".formatted(lat, lng));
	var firstPoint = coords.get(0); 
	processPoint(firstPoint[0], firstPoint[1], p1);
	
	System.out.println("---------");
	coords.forEach(s -> processPoint(s[0], s[1], p1));
	
	System.out.println("---------");
	list.removeIf(s-> s.equalsIgnoreCase("bravo"));
	list.forEach((s) -> System.out.println(s));
	
	System.out.println("---------");
	
	list.replaceAll(s->s.charAt(0)+ " - " +s.toUpperCase());
	list.forEach((s) -> System.out.println(s));
	System.out.println("---------");
	
	String[] emptyArray = new String[10]; 
	System.out.println(Arrays.toString(emptyArray));
	Arrays.fill(emptyArray, "");
	System.out.println(Arrays.toString(emptyArray));
	
	Arrays.setAll(emptyArray, i -> ""+(i+1)+". "+switch(i){
	case 0 -> "one"; 
	case 1 -> "two";
	case 2-> "three";
	default -> "";});
	System.out.println(Arrays.toString(emptyArray));
	
	System.out.println("---------");
	String[] names = {"Ann", "Bob", "Marry", "Josh", "Carol", "David"};
	String[] randomly = randomlySelectedValues(15, names, ()-> new Random().nextInt(0, names.length));
	System.out.println(Arrays.toString(randomly));
	
	}
public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
		
		T result = function.apply(value1, value2);
		System.out.println("result of operation: "+result);
		return result;
	}
//	public static <T> T calculator(Operation<T> function, T value1, T value2) {
//		
//		T result = function.operate(value1, value2);
//		System.out.println("result of operation: "+result);
//		return result;
//	}
	
	public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
		consumer.accept(t1, t2);
		
	}
	
	public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
	
	String[] selectedValues = new String[count]; 
	for(int i=0; i<count; i++){
		selectedValues[i] = values[s.get()];
		
	}
		return selectedValues;
		
	
	}
}
