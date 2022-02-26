import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!!");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jbdl27", "root", "");

        Statement statement = connection.createStatement();
        statement.execute("create table jbdl_students(id int primary key, name varchar(40))");


        System.out.println("------------------------------------------------");
    }
}
