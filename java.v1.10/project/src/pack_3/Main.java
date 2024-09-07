package pack_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

 class PlainOld{
	 private static int last_id = 1; 
	 private int id; 
	public PlainOld(){
		id = PlainOld.last_id++;
		System.out.println("Creating the PiamoOld Object: id = " + id);
	}
}


public class Main {
	public static void main(String... args) {
		List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Klark", "Dave"));
		
		//list.forEach(s -> System.out.println(s));
//		list.forEach(System.out::print);
		calculator((a,b)-> a+b, 5,10);
		calculator(Integer::sum, 10, 5);
//		Supplier<PlainOld> reference1 = ()-> new PlainOld();  
		Supplier<PlainOld> reference1 = PlainOld::new;
		PlainOld pojo = reference1.get();
		System.out.println("Getting Array"); 
		PlainOld[] pojo1 = seedArray(PlainOld::new, 10); 
		calculator(String::concat, "Helo ", "World!!");
		
	}
	private   static <T> void calculator(BinaryOperator<T> func, T val1, T val2) {
		T result = func.apply(val1, val2); 
		
		System.out.println("Result of operation: "+result);
	}
	private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
		
		PlainOld[] array = new PlainOld[count]; 
		Arrays.setAll(array, i->reference.get());
		return array;
	}
}
