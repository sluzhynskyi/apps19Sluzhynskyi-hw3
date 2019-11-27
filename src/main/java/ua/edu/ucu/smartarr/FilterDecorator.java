package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    MyPredicate pr;
    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    @Override
    public Object[] toArray() {
        Object[] a = Arrays.stream(smartArray.toArray()).filter(pr::test).toArray();
        return Arrays.copyOf(a, a.length);
    }

    @Override
    public String operationDescription() {
        return "Filter decorator, tests every element "
                + "and removes it if it doesn't satisfy MyPredicate";
    }
}