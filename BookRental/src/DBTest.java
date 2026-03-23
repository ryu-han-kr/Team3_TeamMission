
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        System.out.println("=== MySQL 연결 테스트 시작 ===");

        // 1. 연결 시도
        Connection conn = DBUtil.getConnection();

        // 2. 결과 확인
        if (conn != null) {
            System.out.println("✅ 성공: MySQL 데이터베이스에 정상적으로 연결되었습니다!");

            // 연결 성공 시, 실제 스키마 이름 출력 (확인용)
            try {
                System.out.println("연결된 DB 이름: " + conn.getCatalog());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 3. 자원 반납
                DBUtil.close(conn);
                System.out.println("🔌 연결이 안전하게 닫혔습니다.");
            }
        } else {
            System.out.println("❌ 실패: DB 연결에 실패했습니다.");
            System.out.println("확인사항: 1. MySQL 실행 여부 / 2. ID, PW 일치 여부 / 3. Connector JAR 등록 여부");
        }
    }
}