package Libraries.Socket.Server;

import Libraries.Models.ClientObj;
import Libraries.Models.User;

import java.net.Socket;
import java.util.ArrayList;

public class Handler extends Thread{
    Socket client;
    public ArrayList<ClientObj> clients;
    public Handler(Socket client, ArrayList<ClientObj> clients){
        this.client = client;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            ClientHandshake handshake = new ClientHandshake(client);
            User user = handshake.initHandshake();
            System.out.println("Handshake completed welcome, "+user.Name);
            ClientObj clientObj = new ClientObj(Integer.valueOf(user.UserId),user.Name,client);
            clients.add(clientObj);
            ClientHandler clientHandler = new ClientHandler(clientObj);
            clientHandler.startClientHandler();

        }
        catch (Exception e){
            System.out.println("Exception Occurred");
        }
    }
}
