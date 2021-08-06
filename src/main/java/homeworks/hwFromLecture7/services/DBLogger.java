package homeworks.hwFromLecture7.services;

import homeworks.hwFromLecture7.InhabitationLog;
import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Event;
import homeworks.hwFromLecture7.repositories.LogRepository;
import homeworks.hwFromLecture7.repositories.LogRepositoryImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DBLogger {
    private final LogRepository logRepository;

    public DBLogger(ConnectionManager connectionManager) {
        this.logRepository = new LogRepositoryImpl(connectionManager);
    }

    public Set<InhabitationLog> getHistory() {
        try {
            return new HashSet<>(logRepository.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public void checkInAnimal(Animal animal) {
        this.logAnimal(animal, Event.ANIMAL_CHECKED_IN);
    }

    public void checkOutAnimal(Animal animal) {
        this.logAnimal(animal, Event.ANIMAL_CHECKED_OUT);
    }

    private void logAnimal(Animal animal, Event event) {
        try {
            logRepository.save(new InhabitationLog(
                    event,
                    new Date(),
                    animal
            ));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
