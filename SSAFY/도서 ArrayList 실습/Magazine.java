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

