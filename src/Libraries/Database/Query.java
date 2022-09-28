package Libraries.Database;

import java.sql.*;
import java.util.ArrayList;

public class Query {
    public static Statement stmt;
    public static CallableStatement cstmt;

    public static ResultSet executeProcRS(Connection conn,String proc) throws SQLException {
        String query = "{ call "+proc  +"() }";
        cstmt = conn.prepareCall(query);
        ResultSet rs = cstmt.executeQuery();
        return rs;
    }

    public static boolean executeProc(Connection conn,String proc) throws SQLException {
        String query = "{ call "+proc  +"() }";
        cstmt = conn.prepareCall(query);
        boolean rs = cstmt.execute();
        return rs;
    }

    public static ResultSet executeProcRS(Connection conn, String proc, ArrayList<String> args) throws SQLException {
        String argsLen = "";
        for (int i = 0;i<args.size();i++){
            argsLen += "?,";
        }
        argsLen = argsLen.substring(0,argsLen.length()-1);
        String query = "{ call "+proc  + "("+ argsLen +")}";

        cstmt = conn.prepareCall(query);
        for (int i = 0;i<args.size();i++){
            cstmt.setString(i+1,args.get(i));
        }
        ResultSet rs = cstmt.executeQuery();
        return rs;
    }

    public static boolean executeProc(Connection conn, String proc, ArrayList<String> args) throws SQLException {
        String argsLen = "";
        for (int i = 0;i<args.size();i++){
            argsLen += "?,";
        }
        argsLen = argsLen.substring(0,argsLen.length()-1);
        String query = "{ call "+proc  + "("+ argsLen +")}";
        System.out.println(query);
        cstmt = conn.prepareCall(query);
        for (int i = 0;i<args.size();i++){
            cstmt.setString(i+1,args.get(i));
        }
        System.out.println("Success0");
        boolean rs = cstmt.execute();
        System.out.println("Success");
        return rs;
    }

}
