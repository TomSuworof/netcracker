package homeworks.hwFromLecture7.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ZooDatasource extends AutoCloseable {

    ResultSet execute(String query) throws SQLException;
}
