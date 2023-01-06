import java.io.IOException;

public class ClientStarter {

    public static void main(String[] args) {
        Client client = new Client(Configuration.host, Configuration.port);
        try {
            client.connect();
            client.sendMessage("Hello from client");
            client.finish();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
