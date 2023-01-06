import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket socket;

    private final String host;
    private final int port;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
        this.socket = new Socket();
    }

    public void connect() throws IOException {
        this.socket = new Socket(this.host, this.port);
    }

    public void sendMessage(String message) throws IOException, InterruptedException {
        PrintWriter printWriter = new PrintWriter(this.socket.getOutputStream(), true);
        printWriter.println(message);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Client: " + bufferedReader.readLine());

        bufferedReader.close();
        printWriter.close();
    }

    public void finish() throws IOException {
        this.socket.close();
    }
}
