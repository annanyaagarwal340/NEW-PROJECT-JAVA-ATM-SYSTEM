import java.sql.*;
public class connection {
    Connection c;
    Statement s;
    public connection() {
        try {
            c=DriverManager.getConnection("jdbc:mysql:///bank","root","#12anaykhushi");
            s=c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
    }
}
