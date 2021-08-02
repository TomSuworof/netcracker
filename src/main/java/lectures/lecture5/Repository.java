package lectures.lecture5;

import java.util.List;

public interface Repository<T> {
    T getById(long id);

    void save(T t);

    List<T> getElementsOrderedBy(int limit);
}
