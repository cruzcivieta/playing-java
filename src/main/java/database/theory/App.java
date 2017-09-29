package database.theory;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting jdbc test");

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "example");
            Connection conn = DriverManager.getConnection(url, props);


            BasicDataSource dbs = new BasicDataSource();
            dbs.setUsername("postgres");
            dbs.setPassword("example");
            dbs.setDriverClassName("org.postgresql.Driver");
            dbs.setUrl(url);
            dbs.setInitialSize(1);

            Connection pooledConnection = dbs.getConnection();

            System.out.println("connected to DB");


            Statement st = conn.createStatement();
            String sql = "SELECT NOW() as dateee";
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    Date date = rs.getDate("dateee");

                    System.out.println(date);
                }
            } catch ( SQLException ex ) {
                ex.printStackTrace();
                System.out.println("SQLException : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("VendorError : " + ex.getErrorCode());
            }



        } catch (Exception e) {
            System.out.println("Failed!" + e.getMessage());
        }
    }
}
