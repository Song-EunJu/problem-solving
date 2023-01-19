import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;

    Book(){

    }

    Book(String isbn, String title, String author, String publisher, int price, String desc) {
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
        return new StringBuilder()
                .append(this.getIsbn()).append(" | ")
                .append(this.getTitle()).append(" | ")
                .append(this.getAuthor()).append(" | ")
                .append(this.getPublisher()).append(" | ")
                .append(this.getPrice()).append(" | ")
                .append(this.getDesc()).append(" | ")
                .toString();
    }
}

// Book 클래스 확장하여 잡지 정보 저장할 Magazine 클래스
class Magazine extends Book {
    private int year;
    private int month;

    Magazine(){

    }

    Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
        super(isbn, title, author, publisher, price, desc);
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getIsbn()).append(" | ")
                .append(this.getTitle()).append(" | ")
                .append(this.getAuthor()).append(" | ")
                .append(this.getPublisher()).append(" | ")
                .append(this.getPrice()).append(" | ")
                .append(this.getDesc()).append(" | ")
                .append(year).append(" | ")
                .append(month).append(" | ")
                .toString();
    }
}

class BookManager {
    private static int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE]; // 명세에 생성자가 없음
    private int size;
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
        return Arrays.copyOfRange(books, 0, size);
    }

    // 고유번호로 도서정보 반환하는 searchByIsbn 메소드 작성
    public Book searchByIsbn(String isbn){
        return Arrays
                .stream(books)
                .limit(size)
                .filter(book -> book.getIsbn().equals(isbn))
                .findAny()
                .orElseGet(null);
    }

    // 제목을 일부 또는 전체로 포함하는 검색
    public Book[] searchByTitle(String title){
        return Arrays
                .stream(books)
                .limit(size)
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList())
                .toArray(Book[]::new);
    }

    // 잡지 리스트 반환
    public Magazine[] getMagazines(){
        // Book[] 배열에서 new Magazine 으로 만들어진 객체만 반환해야 함
        return Arrays.stream(books)
                .limit(size)
                .filter(book -> book instanceof Magazine)
                .toArray(Magazine[]::new);
    }

    // 잡지가 아닌 일반도서 리스트 반환
    public Book[] getBooks(){
        // Book[] 배열에서 new Book 으로 만들어진 객체만 반환해야 함
        return Arrays.stream(books)
                .limit(size)
                .filter(book -> !(book instanceof Magazine) && book!=null)
                .toArray(Book[]::new);
    }

    public int getTotalPrice(){
        int total = 0;
        for(int i=0;i<size;i++){
            total += books[i].getPrice();
        }
        return total;
    }

    public double getPriceAvg(){
        return (double)getTotalPrice()/size;
    }
}

public class ssafy {
    public static void main(String[] args) throws IOException {
        // 도서 객체를 등록한다.
        Book book1 = new Book("1", "java1", "작가1", "퍼블리셔1", 10000, "설명1");
        Book book2 = new Book("2", "java2", "작가2", "퍼블리셔2", 20000, "설명2");
        Book book3 = new Book("3", "java3", "작가3", "퍼블리셔3", 30000, "설명3");
        Magazine book4 = new Magazine("4", "c++4", "작가4", "퍼블리셔4", 40000, "설명4", 2022, 4);
        Magazine book5 = new Magazine("5", "c++5", "작가5", "퍼블리셔5", 50000, "설명5", 2022, 5);
        Magazine book6 = new Magazine("6", "python6", "작가6", "퍼블리셔6", 60000, "설명6", 2022, 6);

        Book[] books = {book1, book2, book3, book4, book5, book6};
        BookManager bookManager = new BookManager();

        // 책 등록하기
        for(int i=0;i<books.length;i++){
            bookManager.add(books[i]);
        }

        System.out.println("************************* 도서 전체 목록 *************************");
        Book[] allBooks = bookManager.getList();
        for(int i=0;i<allBooks.length;i++){
            System.out.println(allBooks[i]);
        }

        System.out.println("************************* 잡지 목록 *************************");
        Magazine[] magazines = bookManager.getMagazines();
        for(int i=0;i<magazines.length;i++){
            System.out.println(magazines[i]);
        }

        System.out.println("************************* 일반 도서 목록 *************************");
        Book[] generalBooks = bookManager.getBooks();
        for(int i=0;i<generalBooks.length;i++){
            System.out.println(generalBooks[i]);
        }

        System.out.println("********************** 도서 제목 포함검색 : java ***********************");
        Book[] searchedByTitle = bookManager.searchByTitle("python");
        for(int i=0;i<searchedByTitle.length;i++){
            System.out.println(searchedByTitle[i]);
        }

        System.out.println("도서 가격 총합 : "+bookManager.getTotalPrice());
        System.out.println("도서 가격 평균 : "+bookManager.getPriceAvg());
    }
}
