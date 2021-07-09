package lectures.lecture3;

// this is POJO
// этот объект просто что-то хранит, ничего не делает

import java.util.Objects;

// есть immutable POJO - для этого убирают сеттеры и проставляют в полях final
public class User {
    private String name;
    private String lastname;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // строчка проверки ссылок. если равно, то всё просто. написана самой первой для ускорения
        if (o == null || getClass() != o.getClass()) return false; // если передан null или дан вообще другой класс - пиши пропало
        User user = (User) o; // каст
        return Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname); // проверка полей
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }
}
