package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.InhabitationLog;

import java.sql.SQLException;
import java.util.List;

public interface LogRepository {
    List<InhabitationLog> findAll() throws SQLException;

    void save(InhabitationLog log) throws SQLException;
}
