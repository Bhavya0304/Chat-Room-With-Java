package Libraries.Socket.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.ServerException;

public class ServerHandshake {
    Socket socObj;

    public ServerHandshake(Socket soc){
        socObj = soc;
    }

    public void initHandshake(int id) throws Exception {
        DataInputStream in=new DataInputStream(socObj.getInputStream());
        DataOutputStream out = new DataOutputStream(socObj.getOutputStream());


        String  str=(String)in.readUTF();
        if(str.equals("Id?")){

            out.writeUTF(String.valueOf(id));
            str = (String)in.readUTF();

            if(str.equals("Thank You!")){
                in.close();
                out.close();
                return;
            }

            else{
                throw new Exception("Handshake Exception");
            }
        }
        else{
            throw new Exception("Handshake Exception");
        }
    }
}
