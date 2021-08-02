package lectures.lecture5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository implements Repository<User> {
    private final Map<Long, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
        // чтобы сортировать по ID, можно использовать TreeMap
        // оно использует сбалансированное дерево для сортировки по ключам
    }

    @Override
    public User getById(long id) {
        return userMap.get(id);
    }

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public List<User> getElementsOrderedBy(int limit) {
        List<User> sorted = userMap.values().stream().sorted().collect(Collectors.toList());
        try {
            return sorted.subList(0, limit);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return sorted;
        }
    }
}
