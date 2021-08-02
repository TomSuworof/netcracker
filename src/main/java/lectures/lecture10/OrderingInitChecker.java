package lectures.lecture10;

public class OrderingInitChecker {
    static int staticInt = 1;
    int nonStaticInt = 2;

    static {
        System.out.println("I am static block init: " + staticInt);
    } // вызывается во время первого обращения к классу (до любого его метода)

    {
        System.out.println("I am non-static block init: " + staticInt + " " + nonStaticInt);
    } // вызывается до конструктора, но только если потом вызывается конструктор

    public OrderingInitChecker() {
        System.out.println("I am constructor: " + staticInt + " " + nonStaticInt);
    } // просто конструктор

    public static void doLogic() {
        System.out.println("Some logic here");
    } // просто статичный метод - не нужен экземпляр класса

    public static class NestedClass {
        public void doLogic() {
            System.out.println("I am static NestedClass!");
        }
    }
}
