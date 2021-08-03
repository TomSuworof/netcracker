package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Species;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/*
        steps for initializing zoo:
        - load species (enum)
        - load log-events (enum)
        - load cages (class, never changes during execution)

        - start using animal checking in-out, while writing logs
*/

public class DBSample {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                    System.getenv("ZOO_DATASOURCE_URL"),
                    System.getenv("ZOO_DATASOURCE_USERNAME"),
                    System.getenv("ZOO_DATASOURCE_PASSWORD")
            );

            ResultSet set = conn.createStatement().executeQuery("select species_name from species;");

            while (set.next()) {
                String spec = set.getString("species_name");
                System.out.println(Species.valueOf(spec));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
