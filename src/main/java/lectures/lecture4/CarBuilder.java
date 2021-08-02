//package lectures.lecture4;
//
//public class CarBuilder {
//    private Car car;
//
//    public CarBuilder() {
//        this.car = new Car();
//    }
//
//    public Car build() {
//        return car;
//    }
//
//    public CarBuilder buildEngine(Engine engine) {
//        this.car.setEngine(engine);
//        return this;
//    }
//
//    public CarBuilder buildWheels(Wheels wheels) {
//        this.car.setWheels(wheels);
//        return this;
//    }
//
//    public CarBuilder buildColor(Color color) {
//        this.car.setColor(color);
//        return this;
//    }
//
//    // по-хорошему, надо, если машина не создана полностью, то не надо её возвращать
//    // также обычно этот билдер делают внутренним классом
//}
