package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate myPr;

    public FilterDecorator(SmartArray smArr, MyPredicate myPr) {
        super(smArr);
        this.myPr = myPr;
    }

    @Override
    public Object[] toArray() {
        return Stream.of(smartArray.toArray()).filter(myPr).toArray();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

}
