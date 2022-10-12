package Libraries.Socket.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Listener extends Thread {
    public Socket server;

    public Listener(Socket server){
        this.server = server;
    }

    @Override
    public void run() {
        try {
            DataInputStream in=new DataInputStream(server.getInputStream());
            while(true){
                if(in.available()>0){
                    String data = in.readUTF().toString();
                    System.out.println(data);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
