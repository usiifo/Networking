import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
        Socket soc = new Socket("localhost", 9942);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        String name = userInput.readLine();
        System.out.println("Enter your date of birth: ");
        String dof = userInput.readLine();
        System.out.println("Enter your gender: ");
        String gender = userInput.readLine();
        System.out.println("Enter your nationality: ");
        String Nationality = userInput.readLine();

        // String to Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dof, formatter);
        User user = new User(name, date, gender, Nationality);


        try (ObjectOutputStream output = new ObjectOutputStream(soc.getOutputStream())) {
            output.writeObject(user);
        }
    }
}

