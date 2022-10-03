
import Libraries.Socket.Client.cSocket;
import Libraries.Socket.Server.sSocket;

import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        int va = sc.nextInt();
        if(va == 1){
            cSocket c = new cSocket(1);
            c.initClient();
        }
        else{
            sSocket s = new sSocket();
            s.initServer();
        }
    }
}