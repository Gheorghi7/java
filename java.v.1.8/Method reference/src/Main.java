import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;


public class Main {
    private record Person(String first){
        public String last(String s){
            return first+" "+s.substring(0, s.indexOf(" "));
        }
    }
    private static Random random = new Random();

    public static void main(String[] args) {
        Person tim = new Person("Tim");
        String[] names = {"Anna", "David", "Darvin", "Jobs", "Mike", "Steve"};
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(String::toUpperCase,
                s -> s + " " + randomizer('A', 'Z') + ".",
                Main::reverseNames,
                tim::last,
                new Person("Marry")::last
        ));
        applyChanges(names, list);

    }

    public static char randomizer(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String reverseNames(String name) {
        return reverseNames(name, 0, name.length());
    }

    private static String reverseNames(String name, int start, int end) {

        return new StringBuilder(name.substring(start, end)).reverse().toString();
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunction) {
        List<String> backedArray = Arrays.asList(names);
        for (var function : stringFunction) {
            backedArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }
}