
import Libraries.Models.User;
import Libraries.Socket.Client.cSocket;

import java.io.Console;
import java.util.Scanner;


public class client {
    public static void main(String[] args) throws Exception {
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine().toString();
        String password = String.valueOf(console.readPassword("Password: "));
        User user = new User();
        System.out.println(username);
        System.out.println(password);
        user.Username = username;
        user.Password = password;
        int id = User.verfiyUser(user);
        System.out.println(id);
        cSocket client = new cSocket(id);
        client.initClient();
    }
}
