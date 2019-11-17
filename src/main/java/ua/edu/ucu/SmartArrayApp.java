package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
// Import all decorators
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;

public class SmartArrayApp {

    public static Integer[] filterPositiveIntegersSortAndMultiplyBy2(
            Integer[] integers) {

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
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate highMarksAndSophomore = new MyPredicate() {
            final static public int MINGPA = 4;
            final static public int EXACTYEAR = 2;

            @Override
            public boolean test(Object st) {
                return (((int) ((Student) st).getGPA()) >= MINGPA
                        && ((Student) st).getYear() == EXACTYEAR);
            }
        };
        MyComparator sortBySurname = new MyComparator() {
            @Override
            public int compare(Object firstSt, Object secondSt) {
                return (((Student) firstSt).getSurname().compareTo(
                        ((Student) secondSt).getSurname()));
            }
        };
        MyFunction surnameAndName = new MyFunction() {
            @Override
            public Object apply(Object st) {
                return ((Student) st).getSurname() + " " + ((Student) st).getName();
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        // Deletes all duplicates
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        // Filter by the greats and year in uni
        studentSmartArray = new FilterDecorator(studentSmartArray, highMarksAndSophomore);
        // Sorts students by surnames
        studentSmartArray = new SortDecorator(studentSmartArray, sortBySurname);
        // Leave only surname and name of student
        studentSmartArray = new MapDecorator(studentSmartArray, surnameAndName);
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
