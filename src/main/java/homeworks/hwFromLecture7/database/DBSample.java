package homeworks.hwFromLecture7.database;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.repositories.AnimalRepository;
import homeworks.hwFromLecture7.repositories.AnimalRepositoryImpl;

import java.sql.ResultSet;
import java.util.Optional;

/*
        steps for initializing zoo:
        - load species (enum)
        - load log-events (enum)
        - load cages (class, never changes during execution)

        - start using animal checking in-out, while writing logs
*/

public class DBSample {
    public static void main(String[] args) {
        try (ConnectionManager datasource = PostgresConnectionManager.getInstance()) {
            AnimalRepository repository = new AnimalRepositoryImpl(datasource);

            Optional<Animal> animal = repository.findAnimalByName("King");
            animal.ifPresent(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ConnectionManager datasource = PostgresConnectionManager.getInstance()) {

            ResultSet set = datasource.getConnection().createStatement().executeQuery("select species_name from species;");

            while (set.next()) {
                String spec = set.getString("species_name");
                System.out.println(Species.valueOf(spec));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
