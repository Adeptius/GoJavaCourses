package module_1.homework.strategies;

import java.util.Collection;

public class PopulateStrategy implements TestingStrategy {
    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            collection.add(new Object());
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        collection.clear();
    }
}
