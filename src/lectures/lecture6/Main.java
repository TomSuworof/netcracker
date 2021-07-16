package lectures.lecture6;

public class Main {
    private int mem = 10;

    class Inner {
        private int imem = new Main().mem; // т.к. в пределах одного класса
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        Outer2.Inner2 inner2 = new Outer2.Inner2();

        System.out.println(new Main().new Inner().imem); // т.к. всё в пределах одного класса, то эта магия работает
    }
}

class Outer {
    class Inner {
        void print() {
            System.out.println("ssss");
        }
    }
}

class Outer2 {
    static class Inner2 {
        void print() {
            System.out.println("ssss2");
        }
    }
}
