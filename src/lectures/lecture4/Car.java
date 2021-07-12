package lectures.lecture4;

public class Car {
    private Engine engine;
    private Wheels wheels;
    private Color color;

    private Car(Engine engine, Wheels wheels, Color color) {
        this.engine = engine;
        this.wheels = wheels;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", wheels=" + wheels +
                ", color=" + color +
                '}';
    }

    public static class CarBuilder {
        private Engine engine;
        private Wheels wheels;
        private Color color;

        public Car build() throws NoSuchFieldException {
            if (this.engine == null || this.wheels == null || this.color == null) {
                throw new NoSuchFieldException("Not enough data for making car");
            }
            return new Car(engine, wheels, color);
        }

        public CarBuilder buildEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder buildWheels(Wheels wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder buildColor(Color color) {
            this.color = color;
            return this;
        }
    }
}
