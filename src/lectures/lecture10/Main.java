package lectures.lecture10;

import static java.lang.System.*;

abstract public class Main { // да, абстрактный класс для main
    public static void main(String[] args) {
//        OrderingInitChecker.doLogic(); // static loader, method
//        OrderingInitChecker initChecker = new OrderingInitChecker(); // static, non-static, constructor
//        new OrderingInitChecker().doLogic(); // static, non-static, constructor, method

        OrderingInitChecker checker1 = new OrderingInitChecker();
        OrderingInitChecker checker2 = new OrderingInitChecker();
        // static loader выполняется только один раз - при загрузке класса
        // остальные методы принадлежат каждому экземпляру и будут выведены по два раза

        out.println("I am static import!");

        OrderingInitChecker.NestedClass nestedClass = new OrderingInitChecker.NestedClass();
        nestedClass.doLogic(); // только тело метода вложенного класса, т.к. внешний класс не загружается

        try {
            exit(0);
        } finally {
            out.println("Does it always run? Nope");
        }
    }
}
