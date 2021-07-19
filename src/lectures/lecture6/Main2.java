package lectures.lecture6;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        Integer c = new Integer(-3);

        List<Integer> list = new ArrayList<>(){{
            add(a);
            add(b);
            add(c);
        }};

        Collections.sort(list);

        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        list.sort((o1, o2) -> o1.compareTo(o2)); // same as above, but shorter

        list.sort(Integer::compareTo); // same as above, but even more shorter

        System.out.println(list);
    }
}
