import java.io.IOException;
import java.util.Arrays;

/** Book ---<> BookManager
 Aggregation (집합연관)
 -> BookManager 가 Book 의 배열을 가지고 있는 것
 */

// 캡슐화
class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;

    public Book(String isbn, String title, String author, String publisher, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(isbn).append(" | ")
                .append(title).append(" | ")
                .append(author).append(" | ")
                .append(publisher).append(" | ")
                .append(price).append(" | ")
                .append(desc)
                .toString();
    }
}
class BookManager {
    private static int MAX_SIZE = 100;
    private Book[] books;
    private int size;

    BookManager(){
        books = new Book[MAX_SIZE];
    }

    public void add(Book book){
        if(size < MAX_SIZE)
            books[size++] = book;
    }

    // 고유번호로 도서정보 삭제하는 remove 메소드
    public void remove(String isbn){
        Book removedBook = searchByIsbn(isbn);
        // 배열의 어떤 인덱스에 저장된지 찾고 그 이후부터 다 땡겨야 함.
        for(int i=0;i<books.length;i++){
            if(books[i] == removedBook){
                for(int j=i;j<books.length-1;j++){
                    books[j] = books[j+1];
                }
            }
        }
        size--;
    }

    public Book[] getList(){
        return books;
    }

    // 고유번호로 도서정보 반환하는 searchByIsbn 메소드 작성
    public Book searchByIsbn(String isbn){
        return Arrays
                .stream(books)
                .filter(book -> book.getIsbn().equals(isbn))
                .findAny()
                .orElseGet(null);
    }

    public int getSize() {
        return size;
    }

    public void print(){
        System.out.println("******************* 도서목록 ********************");
        for(int i=0;i<size;i++){
            System.out.println(books[i].getIsbn()+" | "+books[i].getTitle()+" | "+books[i].getAuthor()+" | "+
                    books[i].getPublisher()+" | "+books[i].getPrice()+" | "+books[i].getDesc());
        }
    }
}

public class ssafy {
    public static void main(String[] args) throws IOException {
        // 도서 객체를 등록한다.
        Book book1 = new Book("1", "책제목1", "작가1", "퍼블리셔1", 10000, "설명1");
        Book book2 = new Book("2", "책제목2", "작가2", "퍼블리셔2", 20000, "설명2");
        Book book3 = new Book("3", "책제목3", "작가3", "퍼블리셔3", 30000, "설명3");

        BookManager bookManager = new BookManager();
        bookManager.add(book1);
        bookManager.add(book2);
        bookManager.add(book3);

        System.out.println("현재 등록된 도서 권 수: "+bookManager.getSize());
        bookManager.print();

        // 도서 객체를 삭제한다.
        System.out.println("<1번 도서 객체 삭제한 후>");
        bookManager.remove("1");

        System.out.println("현재 등록된 도서 권 수: "+bookManager.getSize());
        bookManager.print();

        // 도서 객체를 테스트한다.
        String testNum = "2";
        Book findBook = bookManager.searchByIsbn(testNum);
        if(findBook != null)
            System.out.println(testNum+"번 고유번호의 도서 정보는"+findBook);
    }
}
