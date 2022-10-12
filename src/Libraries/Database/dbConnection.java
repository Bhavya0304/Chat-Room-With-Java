package Libraries.Database;

import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConnection {

    private static java.sql.Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/ChatRoom";
    private static String username = "root";
    private static String password = "257385";

    public static java.sql.Connection createConnection() throws SQLException {
        conn = DriverManager.getConnection(url,username,password);
        return conn;
    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }
//    public static boolean executeQuery(Connection conn, String query) throws SQLException {
//        boolean rs = cstmt.executeQuery(query);
//        return rs;
//    }
//
//    public static ResultSet executeQueryRS(Connection conn, String query) throws SQLException {
//        ResultSet rs = cstmt.executeQuery(query);
//        return rs;
//    }
}
