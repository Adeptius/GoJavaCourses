package module_1.homework.strategies;

import module_1.homework.util.Util;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class RemoveByIteratorStrategy implements TestingStrategy{

    private ListIterator<Object> iterator = null;

    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            iterator.next();
            iterator.remove();
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        List<Object> list = (List<Object>) collection;
        Util.fullFillCollection(list, repeat);
        iterator = list.listIterator();
        // Заполняем лист, что бы было что удалять
    }
}
