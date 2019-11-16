package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.stream.Stream;


// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray smArr, MyFunction func) {
        super(smArr);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return Stream.of(smartArray.toArray()).map(func).toArray();
    }

    @Override
    public String operationDescription() {
        return "Map Decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

}
