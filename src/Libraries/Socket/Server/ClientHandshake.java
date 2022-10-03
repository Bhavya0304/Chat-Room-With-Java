package Libraries.Socket.Server;

import Libraries.Models.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ClientHandshake {
    Socket client;

    public ClientHandshake(Socket soc){

        client = soc;
    }

    public User initHandshake() throws Exception {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in=new DataInputStream(client.getInputStream());

            out.writeUTF("Id?");


            String  str=(String)in.readUTF();
            Integer id = Integer.valueOf(str);
            User user = new User();
            user.UserId = id.toString();
            User userClient = User.getUser(user);


            out.writeUTF("Thank You!");

            out.close();
            in.close();

            return userClient;
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new Exception("Handshake Exception!");
        }
    }
}
