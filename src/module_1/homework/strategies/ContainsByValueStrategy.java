package module_1.homework.strategies;

import module_1.homework.util.Util;

import java.util.Collection;

public class ContainsByValueStrategy implements TestingStrategy{


    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            collection.contains(new Object());
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        Util.fullFillCollection(collection,repeat);
        // Заполняем, что бы было что искать
    }
}
