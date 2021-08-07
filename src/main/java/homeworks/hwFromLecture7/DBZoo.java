package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.cages.MyCage;
import homeworks.hwFromLecture7.repositories.AnimalRepository;
import homeworks.hwFromLecture7.repositories.AnimalRepositoryImpl;
import homeworks.hwFromLecture7.repositories.CageRepository;
import homeworks.hwFromLecture7.repositories.CageRepositoryImpl;
import homeworks.hwFromLecture7.services.DBLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBZoo implements Zoo {
    private static final String ANIMAL_EXISTS = "We already have this animal";
    private static final String ANIMAL_DOES_NOT_EXIST = "We do not have this animal";
    private static final String NO_PLACE = "Sorry, we do not have place for this animal";
    private static final String CAGE_EXISTS = "This cage already exist";

    private final AnimalRepository animalRepository;
    private final CageRepository cageRepository;
    private final DBLogger zooLogger;

    private DBZoo(CageRepository cageRepository, ConnectionManager connectionManager) {
        this.animalRepository = new AnimalRepositoryImpl(connectionManager);
        this.cageRepository = cageRepository;
        this.zooLogger = new DBLogger(connectionManager);
    }

    @Override
    public void checkInAnimal(Animal animal) {
        try {
            Optional<Animal> animalOpt = animalRepository.findAnimalByName(animal.getName());

            if (animalOpt.isPresent()) {
                throw new IllegalArgumentException(ANIMAL_EXISTS);
            }

            Optional<Cage> cageOpt = cageRepository.findEmptyCageAvailTo(animal.getSpecies().name());

            if (cageOpt.isPresent()) {
                Cage cage = cageOpt.get();
                cage.setAnimal(animal);

                animalRepository.insertWithCageUpdate(animal, cage);

                zooLogger.checkInAnimal(animal);
            } else {
                throw new IllegalArgumentException(NO_PLACE);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void checkOutAnimal(Animal animal) {
        try {

            Optional<Cage> cageOpt = cageRepository.findCageByAnimalName(animal.getName());

            if (cageOpt.isPresent()) {
                Cage cage = cageOpt.get();
                cage.setAnimal(null);

                animalRepository.deleteWithCageUpdate(animal, cage);

                zooLogger.checkOutAnimal(animal);
            } else {
                throw new IllegalArgumentException(ANIMAL_DOES_NOT_EXIST);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<InhabitationLog> getHistory() {
        return new ArrayList<>(zooLogger.getHistory());
    }

    public static class ZooBuilder {
        private final CageRepository cageRepository;
        private final ConnectionManager connectionManager;

        public ZooBuilder(ConnectionManager connectionManager) {
            this.connectionManager = connectionManager;
            this.cageRepository = new CageRepositoryImpl(connectionManager);
        }

        public Zoo build() {
            return new DBZoo(cageRepository, connectionManager);
        }

        public ZooBuilder buildCageFor(Species species, int number, double area) {
            try {
                for (Cage cage : cageRepository.findAll()) {
                    if (cage.getNumber() == number) {
                        throw new IllegalArgumentException(CAGE_EXISTS);
                    }
                }

                cageRepository.createEmptyCage(new MyCage(number, area, List.of(species)));
                return this;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }
    }
}
