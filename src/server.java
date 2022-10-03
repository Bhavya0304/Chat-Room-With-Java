
import Libraries.Socket.Server.sSocket;


public class server {
    public static void main(String[] args) throws Exception {
        sSocket server = new sSocket();
        server.initServer();
    }
}
