
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class clientHandler extends Thread {

        Socket soc;
        private final Lock lock = new ReentrantLock();
        private ObjectInputStream input;

        public clientHandler(Socket soc) {
            this.soc = soc;
        }

        @Override
        public void run() {
            try {
                writingObject();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(clientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void writingObject() throws IOException, ClassNotFoundException {
            synchronized (this) {
                input = new ObjectInputStream(soc.getInputStream());
                User user = (User) input.readObject();
                input.close();

                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output.txt", true))) {
                    out.writeObject(user);
                    out.flush();
                }
            }
        }
    }

