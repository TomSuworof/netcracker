package homeworks.hwFromLecture7.database;

import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.repositories.AnimalRepository;
import homeworks.hwFromLecture7.repositories.AnimalRepositoryImpl;

import java.sql.ResultSet;

/*
        steps for initializing zoo:
        - load species (enum)
        - load log-events (enum)
        - load cages (class, never changes during execution)

        - start using animal checking in-out, while writing logs
*/

public class DBSample {
    public static void main(String[] args) {

        AnimalRepository repository = new AnimalRepositoryImpl(PostgresConnectionManager.class);

        repository.findAnimalByName("King");

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
