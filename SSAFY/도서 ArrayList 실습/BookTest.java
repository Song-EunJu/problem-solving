import java.io.IOException;

public class BookTest {
    public static void main(String[] args) throws IOException {
        // 도서 객체를 등록한다.
        Book book1 = new Book("1", "java1", "작가1", "퍼블리셔1", 10000, "설명1");
        Book book2 = new Book("2", "java2", "작가2", "퍼블리셔2", 20000, "설명2");
        Book book3 = new Book("3", "java3", "작가3", "퍼블리셔3", 30000, "설명3");
        Magazine book4 = new Magazine("4", "c++4", "작가4", "퍼블리셔4", 40000, "설명4", 2022, 4);
        Magazine book5 = new Magazine("5", "c++5", "작가5", "퍼블리셔5", 50000, "설명5", 2022, 5);
        Magazine book6 = new Magazine("6", "python6", "작가6", "퍼블리셔6", 60000, "설명6", 2022, 6);

        Book[] books = {book1, book2, book3, book4, book5, book6};
        IBookManager bookManager = BookManagerImpl.getInstance();

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
