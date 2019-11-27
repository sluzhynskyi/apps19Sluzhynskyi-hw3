package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        LinkedHashSet<Object> lhs = new LinkedHashSet<>(
                Arrays.asList(smartArray.toArray()));
        return Arrays.copyOf(lhs.toArray(), lhs.toArray().length);
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator, "
                + "removes duplicate elements from an array";
    }


}
