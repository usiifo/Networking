
import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable{
    private String name;
    private LocalDate DOF;
    private String gender;
    private String nationality;

    public User(String name, LocalDate DOF, String gender, String nationality) {
        this.name = name;
        this.DOF = DOF;
        this.gender = gender;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", DOF=" + DOF + ", gender=" + gender + ", nationality=" + nationality + '}';
    }

}