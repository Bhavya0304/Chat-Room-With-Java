package Libraries.Models;

import java.net.Socket;

public class ClientObj {
    public Integer id;

    public String name;

    public Socket socket;

    public ClientObj(Integer id, String name, Socket socket) {
        this.id = id;
        this.name = name;
        this.socket = socket;
    }

}
