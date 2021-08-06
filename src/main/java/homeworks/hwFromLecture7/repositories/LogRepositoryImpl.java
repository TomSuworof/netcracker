package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.InhabitationLog;
import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LogRepositoryImpl implements LogRepository {
    private final ConnectionManager connectionManager;

    public LogRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    private InhabitationLog getLogFromSet(ResultSet set) throws SQLException {
        Event logEvent = Event.valueOf(set.getString("event_name"));
        Date logDate = set.getDate("log_date");
        String animal = set.getString("animal");
        return new InhabitationLog(logEvent, logDate, animal);
    }

    @Override
    public List<InhabitationLog> findAll() throws SQLException {
        List<InhabitationLog> logs = new LinkedList<>();

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM logs;");
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            InhabitationLog log = this.getLogFromSet(set);
            logs.add(log);
        }

        return logs;
    }

    @Override
    public void save(InhabitationLog log) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);
        PreparedStatement statement = conn.prepareStatement("INSERT INTO logs(event_name, animal_name, log_date) VALUES (?, ?, ?);");
        statement.setString(1, log.getEvent().name());
        statement.setString(2, log.getAnimal());
        statement.setDate(3, new java.sql.Date(log.getDate().getTime()));
        statement.execute();
        conn.commit();
    }
}
