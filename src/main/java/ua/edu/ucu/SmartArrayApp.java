package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {

        MyPredicate goodStudents = new MyPredicate<Student>() {
            @Override
            public boolean test(Student t) {
                return t.getYear() == 2 && t.getGPA() >= 4;
            }
        };

        MyComparator compareBySurname = new MyComparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getSurname().compareTo(s2.getSurname());
            }
        };

        MyFunction joinName = new MyFunction<Student, String>() {
            @Override
            public String apply(Student t) {
                return t.getSurname().concat(" ").concat(t.getName());
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, goodStudents);
        sa = new SortDecorator(sa, compareBySurname);
        sa = new MapDecorator(sa, joinName);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
