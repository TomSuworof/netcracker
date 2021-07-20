package homeworks.hwFromLecture7.parsers;

import homeworks.hwFromLecture7.Zoo;

public interface Parser {
    void parse(String expression);

    void linkToZoo(Zoo zoo);
}
