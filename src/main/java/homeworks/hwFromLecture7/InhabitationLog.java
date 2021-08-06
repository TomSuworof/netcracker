package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Event;

import java.util.Date;

public class InhabitationLog implements Comparable {
    private final Event event;
    private final Date date;
    private final Animal animal;

    public InhabitationLog(final Event event, final Date date, final Animal animal) {
        this.event = event;
        this.date = date;
        this.animal = animal;
    }

    public Event getEvent() {
        return event;
    }

    public Date getDate() {
        return date;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return "InhabitationLog{" +
                "event=" + getEvent() +
                ", date=" + getDate() +
                ", animal=" + getAnimal() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        InhabitationLog log = (InhabitationLog) o;
        return this.date.compareTo(log.getDate());
    }
}