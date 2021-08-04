package homeworks.hwFromLecture7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZooDatasourcePostgres implements ZooDatasource {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL =  System.getenv("ZOO_DATASOURCE_URL");
    private static final String USERNAME = System.getenv("ZOO_DATASOURCE_USERNAME");
    private static final String PASSWORD = System.getenv("ZOO_DATASOURCE_PASSWORD");

    private static ZooDatasource instance;
    private final Connection conn;

    private ZooDatasourcePostgres() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static ZooDatasource getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new ZooDatasourcePostgres();
        }
        return instance;
    }

    @Override
    public ResultSet execute(String query) throws SQLException {
        return conn.createStatement().executeQuery(query);
    }

    @Override
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
