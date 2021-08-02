package lectures.lecture5;

import java.util.*;

public class MyDuplicateFinder<T> implements DuplicateFinder<T> {
    @Override
    public List<T> getDuplicatedElements(List<T> array) {
        new HashSet<>(array).forEach(array::remove);
        return array;
    }
}
