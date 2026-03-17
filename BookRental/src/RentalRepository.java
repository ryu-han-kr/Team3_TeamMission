import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalRepository {


    public void rentBook(int memberId, int bookId) {
        Connection conn = null;
        PreparedStatement pstmtInsert = null; // rental 테이블 기록용
        PreparedStatement pstmtUpdate = null; // book 테이블 상태 변경용

        try {
            conn = DBUtil.getConnection();

            // 두 개의 SQL이 모두 성공해야 하므로 트랜잭션 수동 제어 시작
            conn.setAutoCommit(false);

            // 1. 대여 기록 생성 (rental 테이블)
            // 테이블명과 컬럼명이 팀원들이 만든 SQL과 일치하는지 확인하세요!
            String insertSql = "INSERT INTO rental (member_id, book_id, rental_date) VALUES (?, ?, NOW())";
            pstmtInsert = conn.prepareStatement(insertSql);
            pstmtInsert.setInt(1, memberId);
            pstmtInsert.setInt(2, bookId);
            pstmtInsert.executeUpdate();

            // 2. 도서 상태 업데이트 (book 테이블)
            // 'isRented' 컬럼을 1(대여중)로 변경
            String updateSql = "UPDATE book SET isRented = 1 WHERE id = ?";
            pstmtUpdate = conn.prepareStatement(updateSql);
            pstmtUpdate.setInt(1, bookId);
            pstmtUpdate.executeUpdate();

            // 모든 작업이 정상적으로 끝나면 DB에 최종 반영
            conn.commit();
            System.out.println("대여 처리가 완료되었습니다. (회원ID: " + memberId + ", 도서ID: " + bookId + ")");

        } catch (SQLException e) {
            // 오류 발생 시 작업 취소(Rollback)
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("오류 발생으로 대여 처리가 취소되었습니다.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // 사용한 자원 반납 (DBUtil에 close 메서드가 있다면 그것을 사용해도 됩니다)
            try {
                if (pstmtInsert != null) pstmtInsert.close();
                if (pstmtUpdate != null) pstmtUpdate.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}