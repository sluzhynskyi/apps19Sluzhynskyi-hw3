package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        array = Arrays.stream(smartArray.toArray()).sorted(cmp).toArray();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator, Sorts elements using MyComparator to compare them";
    }
}
