package ssafy.book;

/** RuntimeException 클래스를 상속받으므로 unchecked Exception
 * 따라서 선언부에 throws 를 안 써줘도 아무 상관 없음
 * */
public class ISBNNotFoundException extends RuntimeException {

	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn+"고유번호는 존재하지 않습니다.");
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
}
