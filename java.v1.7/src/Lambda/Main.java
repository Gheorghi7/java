package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.function.*;

class PlainOld {
    private static int last_id = 1;

    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld object: id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        Consumer<String> printTheParts = (i) -> {
            Arrays.asList(i.split(" ")).forEach(s -> System.out.println(s));
        };
        printTheParts.accept("Print this up into an array");
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    s.append(source.charAt(i));
                }
            }
            return s.toString();
        };

        Supplier<String> iLoveJava = () -> "I Love Java";
        Supplier<String> iLoveJava2 = () -> {
            return "I Love Java";
        };
        System.out.println(everySecondChar.apply("1234567890"));
        System.out.println(iLoveJava.get().replace("\s", ""));

        List<String> arguments = new ArrayList<>(List.of("Anna", "Bob", "Daniel"));
        arguments.forEach(System.out::println);

        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 2.0, 2.5);

        Supplier<PlainOld> reference1 = PlainOld::new;
        reference1.get();
        System.out.println("getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator(String::concat, "Hello ", "World!!!");
    }

    public static String everySecondCharacter(Function<String, String> func, String source) {

        return func.apply(source);
    }

    public static <T> void calculator(BinaryOperator<T> func, T value1, T value2) {
        T result = func.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
