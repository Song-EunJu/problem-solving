import java.util.ArrayList;
import java.util.List;

// 도서 리스트를 관리하는 클래스
public class BookManagerImpl implements IBookManager{
    private List<Book> books = new ArrayList<>();
    private static IBookManager instance = new BookManagerImpl();
    public static IBookManager getInstance() {
        return instance;
    }

    public BookManagerImpl() {
    }

    public void add(Book book){
        books.add(book);
    }

    // 고유번호로 도서정보 삭제하는 remove 메소드
    public void remove(String isbn){
        Book removedBook = searchByIsbn(isbn);
        books.remove(removedBook);
    }

    public Book[] getList(){
        return books.toArray(new Book[books.size()]);
    }

    // 고유번호로 도서정보 반환하는 searchByIsbn 메소드 작성
    public Book searchByIsbn(String isbn){
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findAny()
                .orElseGet(null);
    }

    // 제목을 일부 또는 전체로 포함하는 검색
    public Book[] searchByTitle(String title){
        return books.stream()
                .filter(book -> book.getTitle().contains(title))
                .toArray(Book[]::new);
    }

    // 잡지 리스트 반환
    public Magazine[] getMagazines(){
        // Book[] 배열에서 new Magazine 으로 만들어진 객체만 반환해야 함
        return books.stream()
                .filter(book -> book instanceof Magazine)
                .toArray(Magazine[]::new);
    }

    // 잡지가 아닌 일반도서 리스트 반환
    public Book[] getBooks(){
        // Book[] 배열에서 new Book 으로 만들어진 객체만 반환해야 함
        return books.stream()
                .filter(book -> !(book instanceof Magazine) && book!=null)
                .toArray(Book[]::new);
    }

    public int getTotalPrice(){
        int total = 0;
        for(int i=0;i<books.size();i++){
            total += books.get(i).getPrice();
        }
        return total;
    }

    public double getPriceAvg(){
        return (double)getTotalPrice()/books.size();
    }
}
