package module_1.homework.strategies;

import module_1.homework.util.Util;

import java.util.Collection;
import java.util.Set;

public class RemoveByValueStrategy implements TestingStrategy{

    private Set<Object> set = null;

    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            set.remove(new Object());
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        set = (Set<Object>) collection;
        Util.fullFillCollection(set,repeat);
        // Заполняем сет, что бы было что удалять
    }
}
