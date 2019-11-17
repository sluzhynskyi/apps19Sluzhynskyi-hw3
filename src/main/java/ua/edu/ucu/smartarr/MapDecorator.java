package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        array = Arrays.stream(smartArray.toArray()).map(function::apply)
                .toArray();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator, map every element " +
                "to another object using MyFunction";
    }
}
