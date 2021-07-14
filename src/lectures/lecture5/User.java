package lectures.lecture5;

public class User implements Comparable<User> {
    private final long id;
    private final String firstname;
    private final String lastname;

    public long getId() {
        return id;
    }

    public User(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int result = firstname.compareTo(o.getFirstname());
        if (result == 0) {
            result = lastname.compareTo(o.getLastname());
        }
        return result;
    }
}
