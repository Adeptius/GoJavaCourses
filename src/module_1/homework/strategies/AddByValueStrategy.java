package module_1.homework.strategies;

import java.util.Collection;
import java.util.Set;

public class AddByValueStrategy implements TestingStrategy{

    private Set<Object> set = null;

    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            set.add(new Object());
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        set = (Set<Object>) collection;
        set.clear();
    }
}
