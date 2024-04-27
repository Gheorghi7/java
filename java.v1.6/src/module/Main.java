package module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> person = new ArrayList<>(Arrays.asList(new Person("Gabriel", "Eurel"),
                new Main.Person("Penoks", "Penokievich"),
                new Person("Gardon", "Gardonenko")));

//        var comparator = new Comparator<Person>(){
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName.compareTo(o2.lastName);
//            }
//        };
        person.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(person);

        interface EnhancedComparator<T> extends Comparator<T> {
            int seconfLevel(T o1, T o2);

        }
        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int seconfLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? seconfLevel(o1, o2) : result);
            }
        };

        person.sort(comparatorMixed);
        System.out.println(person);
    }

}
