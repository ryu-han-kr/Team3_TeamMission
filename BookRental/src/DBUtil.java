import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/comic_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PWD = "0000";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PWD);

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("DB 연결 실패: " + e.getMessage());
        }
        return conn;
    }

    // 자원 해제 유틸 메서드 (선택 사항)
    public static void close(AutoCloseable... resources) {
        for(AutoCloseable res : resources) {
            if(res != null) {
                try { res.close(); } catch (Exception ignored) {}
            }
        }
    }
}
