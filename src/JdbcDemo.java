import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcDemo {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "******";

        String query = "Select id, name,city from student";
        try (
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
        ){
            System.out.println("MYSQL Connection Successful!");
            System.out.println(" Id | Name | City ");
            System.out.println("------------------------");
            while (result.next()) {
                    System.out.println(
                    result.getInt("id") + " | " +
                    result.getString("name") + " | " +
                    result.getString("city")
                    );
                 
            };
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
