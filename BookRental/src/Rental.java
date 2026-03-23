import java.time.LocalDateTime;

public class Rental {
	private int id;
	private int memberId; // ERD의 member_id
	private int bookId; // ERD의 book_id
	private LocalDateTime rentDate;
	private LocalDateTime dueDate;
	private LocalDateTime returnDate;

	// 기본 생성자
	public Rental() {
	}

	// Getter / Setter (이클립스에서 Alt + Shift + S -> R로 자동생성 가능)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public LocalDateTime getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDateTime rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
}