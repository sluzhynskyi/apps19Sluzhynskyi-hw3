package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction function;
    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] a = Arrays.stream(smartArray.toArray()).map(function::apply).toArray();
        return Arrays.copyOf(a, a.length);
    }

//    public static void main(String[] args) {
//        BaseArray a = new BaseArray(new Integer[]{1, 2, 3, 4, 5});
//        MapDecorator b = new MapDecorator(a, x -> (Integer) x * (Integer) x);
//        System.out.println(Arrays.toString(a.toArray()));
//        System.out.println(Arrays.toString(b.toArray()));
//        a.setValue(0); // що це працювало додайте метод
//        System.out.println(Arrays.toString(a.toArray())); // [0, 2, 3, 4, 5]
//        System.out.println(Arrays.toString(b.toArray())); // [0, 4, 9, 16, 25]
//    }

    @Override
    public String operationDescription() {
        return "MapDecorator, map every element "
                + "to another object using MyFunction";
    }
}
