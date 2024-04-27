package module.LambdaExpressions;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> person = new ArrayList<>(Arrays.asList("Alpha", "Bravo", "Charlie", "Delta"));

        for (String i : person) {
            System.out.println(i);
        }
        System.out.println("--------------");
        person.forEach((i) -> System.out.println(i));

        System.out.println("--------------");
        person.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(myString + " means " + first);
        });
        System.out.println("---------------");

        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((var a, var b) -> a / b, 10.0, 2.5);

        var coords = Arrays.asList(
                new double[]{34.5463, -67.0090},
                new double[]{12.5463, -56.0090},
                new double[]{33.5463, -89.0090},
                new double[]{55.5463, -100.0090}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
        System.out.println("---------------");
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        System.out.println("---------------");
        person.removeIf(s -> s.equalsIgnoreCase("Charlie"));
        person.forEach(s -> System.out.println(s));
        System.out.println("---------------");
        person.addAll(List.of("easy", "echo", "earnest"));
        person.forEach(s -> System.out.println(s));
        System.out.println("---------------");
        person.removeIf(s -> s.startsWith("ea"));
        person.forEach(s -> System.out.println(s));
        System.out.println("---------------");
        person.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        person.forEach(s -> System.out.println(s));
        System.out.println("---------------");
        String[] reference = new String[10];
        System.out.println(Arrays.toString(reference));
        Arrays.fill(reference, "");
        System.out.println(Arrays.toString(reference));
        System.out.println("---------------");
        Arrays.setAll(reference, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(reference));
        System.out.println("---------------");
        Arrays.setAll(reference, (i) -> "" + (i + 1) + ". " + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(reference));

        System.out.println("---------------");
        String[] names = {"Anne", "Bob", "Jon", "Tom", "Jan", "David"};
        String[] randomList = randomlySelectedValue(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
    }

    public static <T> T calculator(BinaryOperator<T> func, T value1, T value2) {
        T result = func.apply(value1, value2);
        System.out.println("result of operation is: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {

        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValue(int count, String[] value, Supplier<Integer> s) {
        String[] selectValue = new String[count];
        for (int i = 0; i < count; i++) {
            selectValue[i] = value[s.get()];
        }
        return selectValue;
    }
}
