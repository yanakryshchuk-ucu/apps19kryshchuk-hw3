package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smArr) {
        super(smArr);
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for ( Object e : smartArray.toArray() ) {
            if ( ! result.contains(e)) {
                result.add(e);
            }
        }
        return result.toArray();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator";
    }

}
