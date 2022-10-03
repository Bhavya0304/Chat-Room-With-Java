package Libraries.Socket.Client;

import java.io.IOException;
import java.net.Socket;

public class cSocket {
    Socket socket;
    public static final String HOST = "localhost";
    public static final int PORT = 5400;

    public int clientId;

    public cSocket(int id) throws IOException {
        socket = new Socket(HOST,PORT);
        clientId = id;
        System.out.println("Client Connected to server...");
    }

    public void initClient() throws Exception {
        ServerHandshake handshake = new ServerHandshake(socket);
        handshake.initHandshake(clientId);
        System.out.println("Client Handshake completed!");

    }

}
