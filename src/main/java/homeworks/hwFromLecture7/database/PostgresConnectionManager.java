package homeworks.hwFromLecture7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionManager implements ConnectionManager {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL =  System.getenv("ZOO_DATASOURCE_URL");
    private static final String USERNAME = System.getenv("ZOO_DATASOURCE_USERNAME");
    private static final String PASSWORD = System.getenv("ZOO_DATASOURCE_PASSWORD");

    private static ConnectionManager instance;
    private final Connection conn;

    private PostgresConnectionManager() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static ConnectionManager getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new PostgresConnectionManager();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
