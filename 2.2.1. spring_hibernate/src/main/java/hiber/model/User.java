package hiber.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "name")
    private final String firstName;

    @Column(name = "last_name")
    private final String lastName;

    @Column(name = "email")
    private final String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_car")
    private final Car car;

    public Car getCar() {
        return car;
    }

    protected User() {
        this.car = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
    }

    public User(String firstName, String lastName, String email, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
