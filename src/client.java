
import Libraries.Authentication.UserLogin;
import Libraries.Socket.Client.cSocket;

import java.util.HashMap;
import java.util.Map;


public class client {
    public static void main(String[] args) throws Exception {
        UserLogin login = new UserLogin();
        int id;

        while(true){
            try{
                id = login.initAuthenticationUsingLogin();
                break;
            }catch (Exception e){
                System.out.println(e);
                continue;
            }
        }
        cSocket client = new cSocket(id);
        client.initClient();
    }
}
