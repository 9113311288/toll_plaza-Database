package Project;
import java.sql.*;
public class Connect {
    private static final String Database="jdbc:mysql://localhost:3306/toll_plaza";
    private static final String userName ="root";
    private static final String passwd="akshay7061@45";
    Statement sql;
    Connection con;
    Connect() throws  Exception
    {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Trying to connect");
            con=DriverManager.getConnection(Database,userName,passwd);
            System.out.println("Connected");
            sql= con.createStatement();

    }
    public static void main(String[] args) throws Exception {
         new Connect();
    }
}