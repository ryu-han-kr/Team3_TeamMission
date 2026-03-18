import java.sql.*;

public class ComicRepository {
    private Connection conn;
    private PreparedStatement pstmt;
    public void add(String title, String author, int volume) {
        // Scanner로 제목, 작가 입력받기
        String sql = "INSERT INTO comic (title, author, volume) VALUES (?,?,?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
            )
        {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, volume);
            pstmt.executeUpdate();
            System.out.println("만화책이 등록되었습니다.");

        } catch(Exception e) {
            System.out.println("에러가 발생했습니다.");
            e.printStackTrace();
        }
    }
    public void list() {
        String sql = "SELECT * FROM comic ORDER BY id DESC";
        // result set을 사용하여 목록 출력 로직 구현
    }
}
