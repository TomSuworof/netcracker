package lectures.lecture14;

import java.sql.*;

public class Main {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = System.getenv("URL");
    private static final String USERNAME = System.getenv("USERNAME");
    private static final String PASSWORD = System.getenv("PASSWORD");

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Function f = new Function();

            conn.setAutoCommit(false);

            for (int i = 0; i < 10; i++) {
                CallableStatement callableStatement = conn.prepareCall("insert into java_function(x, y) values (?, ?);");
                callableStatement.setDouble(1, i);;
                callableStatement.setDouble(2, f.getY(i));
                callableStatement.execute();
            }

            conn.commit();

            ResultSet set = conn.createStatement().executeQuery("select * from java_function;");

            while (set.next()) {
                System.out.println(set.getString("x") + " " + set.getString("y"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
