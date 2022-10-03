
import Libraries.Socket.Client.cSocket;



public class client {
    public static void main(String[] args) throws Exception {
        cSocket client = new cSocket(2);
        client.initClient();
    }
}
