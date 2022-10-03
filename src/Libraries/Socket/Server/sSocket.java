package Libraries.Socket.Server;

import Libraries.Models.ClientObj;
import Libraries.Models.User;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class sSocket {
    public ServerSocket sc;
    public static final int PORT = 5400;

    public ArrayList<ClientObj> clients;

    public sSocket() throws IOException {
        sc = new ServerSocket(PORT);
        clients =  new ArrayList<ClientObj>();
        System.out.println("Server is started on PORT: " + PORT);
    }

    public void initServer() throws Exception {
        while(true){
            Socket clientSocket = sc.accept();
            System.out.println("Connected to a client...");
            Handler handle = new Handler(clientSocket,clients);
            handle.start();

        }

    }

}
