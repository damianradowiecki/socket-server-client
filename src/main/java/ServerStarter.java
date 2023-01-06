import java.io.IOException;

import static java.util.Objects.nonNull;

public class ServerStarter {

    public static void main(String[] args){

        Server server = null;
        try {
            server = new Server(Configuration.host, Configuration.port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if(nonNull(server)) {
                    server.stop();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
