package lectures.lecture11;

import lectures.lecture4.Car;
import lectures.lecture4.Color;
import lectures.lecture4.Engine;
import lectures.lecture4.Wheels;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CarReflection {
    public static void main(String[] args) {
        try {
            Car car = getCar();
            System.out.println(car);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static Car getCar() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Color color = null;
        Engine engine = null;
        Wheels wheels = null;
        Field[] carFields = Car.class.getDeclaredFields();
        for (Field carField : carFields) {
            if (carField.getType().equals(Color.class)) {
                color = (Color) carField.getType().getConstructors()[0].newInstance(0, 0, 0);
            } else if (carField.getType().equals(Engine.class)) {
                engine = (Engine) carField.getType().getConstructors()[0].newInstance(2);
            } else if (carField.getType().equals(Wheels.class)) {
                wheels = (Wheels) carField.getType().getConstructors()[0].newInstance(20);
            }
        }

        System.out.println(color);
        System.out.println(engine);
        System.out.println(wheels);

        Constructor[] constructors = Car.class.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        return (Car) constructors[0].newInstance(engine, wheels, color);
    }
}
