package module_1.homework.strategies;

import java.util.*;

public class AddByIteratorStrategy implements TestingStrategy {

    private ListIterator<Object> iterator = null;

    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            iterator.add(new Object());
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        List<Object> list = (List<Object>) collection;
        list.clear();
        iterator = list.listIterator();
    }
}
