package ssafy.book;

/** Exception 클래스를 상속받으므로 checked Exception
 * -> try~catch 를 해서 에러를 잡든, throws 를 통해서 호출한 메소드로 예외를 던지든 해야 함
 * */
public class QuantityException extends Exception {

	public QuantityException() {
		super("수량이 부족합니다.");
	}

}
