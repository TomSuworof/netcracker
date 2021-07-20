package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Species;

import java.util.Date;

public class InhabitationLog {
    private Date checkInDate;
    private Date checkOutDate;
    private Species animalSpecies;
    private String animalName;

    public InhabitationLog(final Date checkInDate,
                           final Date checkOutDate,
                           final Species animalSpecies,
                           final String animalName) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.animalSpecies = animalSpecies;
        this.animalName = animalName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Species getAnimalSpecies() {
        return animalSpecies;
    }

    public String getAnimalName() {
        return animalName;
    }

    @Override
    public String toString() {
        return "InhibitionLog{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", animalSpecies=" + animalSpecies +
                ", animalName='" + animalName + '\'' +
                '}';
    }
}