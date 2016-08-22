package module_1.homework.strategies;

import module_1.homework.util.Util;

import java.util.Collection;
import java.util.List;

public class RemoveByIndexStrategy implements TestingStrategy {

    private List<Object> list = null;

    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = repeat-1; i >= 0; i--) {
            list.remove(i);
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        list = (List<Object>) collection;
        Util.fullFillCollection(list, repeat);
        // Заполняем лист что бы было что удалять
    }
}
