package homeworks.hwFromLecture7.parsers;

import homeworks.hwFromLecture7.Zoo;

import java.io.IOException;

public interface Parser {
    void parse(String expression) throws IOException;

    void linkToZoo(Zoo zoo);

    void close();
}
