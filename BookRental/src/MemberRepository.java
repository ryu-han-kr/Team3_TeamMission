import java.sql.*;

public class MemberRepository {

    private Connection conn;
    private PreparedStatement pstmt;
    public void add(String name, String phone) {
        String sql = "INSERT INTO member (name, phone) VALUES (?,?)";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
            )
        {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.executeUpdate();
            System.out.println("회원이 등록되었습니다");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
