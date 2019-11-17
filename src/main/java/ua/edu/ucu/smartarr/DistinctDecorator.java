package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        LinkedHashSet<Object> lhs = new LinkedHashSet<>
                (Arrays.asList(smartArray.toArray()));
        this.array = lhs.toArray();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator, " +
                "removes duplicate elements from an array";
    }


}
