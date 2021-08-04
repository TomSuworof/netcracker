package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.database.ZooDatasource;
import homeworks.hwFromLecture7.database.ZooDatasourcePostgres;
import homeworks.hwFromLecture7.model.Species;

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

        try (ZooDatasource datasource = ZooDatasourcePostgres.getInstance()) {

            ResultSet set = datasource.execute("select species_name from species;");

            while (set.next()) {
                String spec = set.getString("species_name");
                System.out.println(Species.valueOf(spec));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
