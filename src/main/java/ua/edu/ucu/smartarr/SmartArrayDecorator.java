package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;
    protected Object[] array;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public int size() {
        return this.array.length;
    }

}


