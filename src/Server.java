import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Waiting a client.. ");
        ServerSocket ss = new ServerSocket(9942);
        int i = 0;
        while (true) {
            i++;
            Socket soc = ss.accept();
            System.out.println("Connection Established, client served: " + i);
            clientHandler client = new clientHandler(soc);
            client.start();
        }
    }
}
