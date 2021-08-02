package lectures.lecture4;

/*
    тут пример паттерна Строитель - Builder
    есть отдельный класс, который строит машину с определёнными параметрами
 */

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {

        Car.CarBuilder carBuilder = new Car.CarBuilder();

        try {
            Car car = carBuilder
                    .buildEngine(new Engine(8))
                    .buildWheels(new Wheels(20))
                    .buildColor(new Color(0, 0, 0))
                    .build();

            System.out.println(car);

        } catch (NotEnoughDataForCarBuildingException e) {
            e.printStackTrace();
        }


        Car.CarBuilder newCarBuilder = new Car.CarBuilder();

        try {
            Car nullCar = newCarBuilder
                    .buildColor(new Color(1, 1, 1))
                    .build();

            System.out.println(nullCar);
        } catch (NotEnoughDataForCarBuildingException e) {
            e.printStackTrace();
        }
    }
}
