package lectures.lecture3;

public class Main {
    public static void main(String[] args) {
        System.out.println(Constants.DEFAULT_USER_NAME);

        Singleton singleton = Singleton.getInstance();

        singleton.setMessage("First call");
        System.out.println(singleton.getMessage());

        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.getMessage());

        System.out.println(singleton.getClass().getName());
    }
}
