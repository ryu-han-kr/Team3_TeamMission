import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static String url = "jdbc:mysql://localhost:3306/teamproject?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static String user = "root";
	private static String password = "1018"; // 팀원들에게 각자 수정하라고 안내하세요.

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.err.println("❌ JDBC 드라이버 로딩 실패: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("❌ DB 연결 실패: " + e.getMessage());
		}
		return conn;
	}

	// 자원 해제 유틸 (Statement, ResultSet 등을 닫을 때 사용)
	public static void close(AutoCloseable... resources) {
		for (AutoCloseable res : resources) {
			if (res != null) {
				try {
					res.close();
				} catch (Exception e) {
					// ignore
				}
			}
		}
	}
}