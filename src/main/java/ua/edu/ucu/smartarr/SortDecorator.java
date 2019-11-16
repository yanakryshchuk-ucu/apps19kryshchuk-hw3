package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator myComp;

    public SortDecorator(SmartArray smArr, MyComparator myComp) {
        super(smArr);
        this.myComp = myComp;
    }


    private Object[] sortArr() {
        return Stream.of(smartArray.toArray()).sorted(myComp).toArray();
    }

    @Override
    public Object[] toArray() {
        return sortArr();
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

}
