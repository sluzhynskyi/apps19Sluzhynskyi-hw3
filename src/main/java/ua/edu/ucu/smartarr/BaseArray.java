package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    public Object[] array;

    public BaseArray(Object[] arr) {
        this.array = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return "Without decorators";
    }


    @Override
    public int size() {
        return array.length;
    }

    public void setValue(int index) {
        array[index] = 0;
    }
}
