package Libraries.Socket.Server;

import Libraries.Models.ClientObj;
import Libraries.Models.Command;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler{

    ClientObj client;

    public ClientHandler(ClientObj client){
        this.client = client;
    }

    public void startClientHandler() throws IOException {
        DataInputStream in=new DataInputStream(client.socket.getInputStream());
        while(true){
            if(in.available()>0){
                String data = in.readUTF().toString();
                Command command = Command.DeserializeObject(data);


            }
        }
    }

}

