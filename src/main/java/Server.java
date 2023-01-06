import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final String host;
    private final int port;
    private final ServerSocket serverSocket;

    public Server(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.serverSocket = new ServerSocket();
    }

    public void start() throws IOException {
        serverSocket.bind(new InetSocketAddress(this.host, this.port));
        Socket clientSocket = serverSocket.accept();

        InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Server: " + bufferedReader.readLine());

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        printWriter.println("Hello from server");

        bufferedReader.close();
        printWriter.close();
    }

    public void stop() throws IOException {
        this.serverSocket.close();
    }
}
