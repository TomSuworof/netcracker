package homeworks.hwFromLecture7.database;

import java.sql.Connection;

public interface ConnectionManager extends AutoCloseable {

    Connection getConnection();
}
