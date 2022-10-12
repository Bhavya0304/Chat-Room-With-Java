package Libraries.Authentication;

import Libraries.Models.User;

import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
    User user;

    public int initAuthenticationUsingLogin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine().toString();
        System.out.print("Password: ");
        String password = scanner.nextLine().toString();
        this.user = new User();
        this.user.Username = username;
        this.user.Password = password;
        int id = User.verfiyUser(user);
        if(id == -1){
            throw new IllegalArgumentException("Username or Passwrod is incorrect!");
        }
        else{
            return id;
        }
    }
}
