package firstspringapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionManager {
    private static final String URL_KEY = "url";
    private static final String LOGIN_KEY = "login";
    private static final String PASSWORD_KEY = "password";
    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(LOGIN_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
