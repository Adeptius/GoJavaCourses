package module_1.homework.strategies;

import java.util.Collection;

public interface TestingStrategy {

    void execute(Collection collection, int repeat);

    void prepare(Collection collection, int repeat);
}
