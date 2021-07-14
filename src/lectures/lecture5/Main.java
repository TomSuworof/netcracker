package lectures.lecture5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(){{
            add(1);
            add(2);
            add(1);
            add(2);
            add(1);
            add(2);
            add(3);
        }};

        List<String> list2 = new ArrayList<>(){{
            add("A");
            add("B");
            add("A");
            add("B");
            add("A");
            add("B");
            add("C");
        }};

        new MyDuplicateFinder<Integer>().getDuplicatedElements(list1).forEach(System.out::println);
        System.out.println();
        new MyDuplicateFinder<String>().getDuplicatedElements(list2).forEach(System.out::println);
        System.out.println();

        Repository<User> userRepository = new UserRepository();

        userRepository.save(new User(1, "Ivan", "Ivanov"));
        userRepository.save(new User(2, "Ivan", "Smirnov"));
        userRepository.save(new User(2, "Ivan", "Sobolev"));

        System.out.println(userRepository.getById(2) + "\n");

        userRepository.getElementsOrderedBy(10).forEach(System.out::println);
    }
}
