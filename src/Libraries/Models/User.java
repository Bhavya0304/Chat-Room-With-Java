package Libraries.Models;

import Libraries.Database.Query;
import Libraries.Database.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    public String UserId;
    public String Username;
    public String Password;
    public String Name;

    public static boolean createUser(User data) throws SQLException {
        ArrayList<String> args = new ArrayList<>();
        args.add(data.Username);
        args.add(data.Password);
        args.add(data.Name);
        Connection conn = dbConnection.createConnection();
        boolean result = Query.executeProc(conn,"createUser",args);
        return result;
    }

    public static int verfiyUser(User data) throws SQLException {
        ArrayList<String> args = new ArrayList<>();
        args.add(data.Username);
        args.add(data.Password);
        Connection conn = dbConnection.createConnection();
        ResultSet result = Query.executeProcRS(conn,"verifyUser",args);
        if(result.next()){
            return result.getInt("UserId");
        }
        else{
            return -1;
        }
    }

    public static User getUser(User data) throws SQLException {
        ArrayList<String> args = new ArrayList<>();
        args.add(data.UserId);
        Connection conn = dbConnection.createConnection();
        ResultSet result = Query.executeProcRS(conn,"getUser",args);
        if(result.next()){
            data.Name = result.getString("Name");
            data.Username = result.getString("Username");
            return data;
        }
        else{
            return null;
        }
    }
}
