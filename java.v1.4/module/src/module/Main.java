package module;

import java.util.ArrayList;
import java.util.List;
record Employee(String name) implements QueryItem{
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printMoreList(students);

        List<LPAStudent> lpaStudents = new ArrayList<LPAStudent>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());

        }
        printMoreList(lpaStudents);

        testList(new ArrayList<Integer>(List.of(1, 2, 3)));
        testList(new ArrayList<String>(List.of("Marry", "Abigale", "Rachel")));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreList(matches);
        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(students2021);
        }

    public static void printMoreList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();

//        QueryList<Employee> employee = new QueryList<>();
    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String e) {
                System.out.println("String" + " " + e.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer" + " " + i.floatValue());
            }
        }
    }

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println("String " + element.toUpperCase());
//        }
//    }
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("Integer " + element.floatValue());
//        }
//    }
}
