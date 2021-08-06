package homeworks.hwFromLecture7.database;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.repositories.AnimalRepository;
import homeworks.hwFromLecture7.repositories.AnimalRepositoryImpl;

import java.util.Optional;

public class DBSample {
    public static void main(String[] args) {
        try (ConnectionManager datasource = PostgresConnectionManager.getInstance()) {
            AnimalRepository repository = new AnimalRepositoryImpl(datasource);

            Optional<Animal> animal = repository.findAnimalByName("King");
            animal.ifPresent(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
