package ssafy.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books;
	
	/**
	 * 싱글톤 디자인패턴을 위해 유지하는 객체 참조값
	 * 클래스 메모리에 로드시에 객체 1번 생성하여 참조값 유지
	 */
	private static IBookManager instance = new BookManagerImpl();

	private BookManagerImpl() {
		/**
		 * 객체 생성시 기존에 저장된 데이터를 읽어오도록 한다.
		 * 외부에서 객체 생성을 하지 못하도록 접근 제어자를 private으로 만등
		*/
		loadData();
	}

	public static IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);
	}

	@Override
	public void remove(String isbn){
		final int size = books.size();	// 저장되어 있는 도서개수 확인
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치를 이용하여 리스트에서 도서 삭제
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
		
	}

	@Override
	public Book[] getList() {
		Book[] result = new Book[books.size()];	// 저장되어 있는 도서개수 만큼의 배열 생성
		return books.toArray(result);			// 컬렉션 내용을 배열로 복사 후 배열 리턴 
	}

	@Override
	public Book searchByIsbn(String isbn) {		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		throw new ISBNNotFoundException(isbn);
	}

	@Override
	public Book[] searchByTitle(String title) {
		// 제목을 포함하는 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}

	@Override
	public Magazine[] getMagazines() {
		// 잡지의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		Magazine[] result = new Magazine[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 					// 컬랙션의 내용을 배열로 복사 후 리턴
	} 	

	@Override
	public Book[] getBooks() {
		// 일반 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}

	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException {
		Book book = searchByIsbn(isbn);				// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn);
		// 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		// -> sell() 을 부르는 main에서도 throws QuanException 을 붙여줘야 에러 안남
		
		int res = book.getQuantity() - quantity;	// 판매 후 새로운 재고 수량 계산
		if(res < 0) throw new QuantityException();	// 재고수량 부족시 QuantityException 사용자 정의 예외 발생시킴
		book.setQuantity(res); 						// 판매후 남은 재고수량으로 재고수량 변경
	}

	@Override
	public void buy(String isbn, int quantity) {
		Book book = searchByIsbn(isbn);						// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn);
		// 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		// -> buy() 를 부르는 main에서는 throws ISBNException 없어도 에러 안남

		book.setQuantity(book.getQuantity() + quantity);	// 구매 후의 새로운 재고 수량 계산하여 재고 수량 변경 
	}
	@Override
	public void saveData() {
		// ObjectOutputStream
		// 객체를 파일에 저장하기 위한 메소드 -> 따라서 파일이나 네트워크로 데이터를 전달하기 위해 직렬화 수행
		// writeObject() 함수를 이용해서 변환
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.dat"))){
			out.writeObject(books);			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	private void loadData() {
		// ObjectInputStream
		// 파일이나 네트워크를 통해 전달 받은 직렬화된 데이터를 객체로 다시 만드는 것
		// 이때 쓰이는 함수가 readObject() 이며 직렬화 하기전 객체로 캐스팅
		File file = new File("book.dat");
		if(file.exists()) { // 데이터 파일이 존재하는 경우
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				books = (List<Book>) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else { // 데이터 파일이 없는 경우
			books = new ArrayList<>();
		}
	}
}











