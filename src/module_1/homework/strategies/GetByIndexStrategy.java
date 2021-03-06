package module_1.homework.strategies;

import module_1.homework.util.Util;

import java.util.Collection;
import java.util.List;

public class GetByIndexStrategy implements TestingStrategy {

    private List<Object> list = null;
    @Override
    public void execute(Collection collection, int repeat) {
        for (int i = 0; i < repeat; i++) {
            list.get(i);
        }
    }

    @Override
    public void prepare(Collection collection, int repeat) {
        list = (List<Object>) collection;
        Util.fullFillCollection(list,repeat);
        // Заполняем лист что бы было что брать
    }
}
