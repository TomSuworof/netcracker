package lectures.lecture7;

import java.util.*;

/*
    по заданию надо вывести покупателей и их покупки в лексикографическом порядке
    в таком случае хорошо работает tree map
 */

public class Buyers {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> shopHistory = new TreeMap<>();

        shopHistory.put("Petrov", new TreeMap<>(){{
            put("envelop", 20);
            put("pens", 5);
        }});

        shopHistory.put("Ivanov", new TreeMap<>(){{
            put("marker", 3);
            put("paper", 17);
            put("envelop", 5);
        }});

        for (Map.Entry<String, Map<String, Integer>> buyer : shopHistory.entrySet()) {
            StringBuilder str = new StringBuilder();
            str.append(buyer.getKey()).append(": ");
            for (Map.Entry<String, Integer> item : buyer.getValue().entrySet()) {
                str.append(item.getKey()).append(" ").append(item.getValue()).append(", ");
            }
            str = new StringBuilder(str.substring(0, str.length() - 2));
            System.out.println(str);
        }
    }
}
