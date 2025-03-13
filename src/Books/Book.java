package Books;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    String regexBookId = "^B.{4}$";
    String regexBookName = "^.{6,100}$";

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, double interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        Scanner sc = new Scanner(System.in);
        while (!bookName.matches(regexBookName)) {
            System.out.println("Tên sách không hợp lệ. Vui lòng nhập lại");
            bookName = sc.nextLine();
        }

        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        Scanner sc = new Scanner(System.in);
        while (importPrice < 0) {
            System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại.");
            importPrice = sc.nextDouble();
        }

        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        Scanner sc = new Scanner(System.in);
        while (exportPrice < 0 || exportPrice < importPrice * 1.1) {
            System.out.println("Giá xuất phải lớn hơn 0. Vui lòng nhập lại.");
            exportPrice = sc.nextDouble();
        }

        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        Scanner sc = new Scanner(System.in);
        while (author.isEmpty()) {
            System.out.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
            author = sc.nextLine();
        }

        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Scanner sc = new Scanner(System.in);
        while (title.isEmpty()) {
            System.out.println("Tiêu đề không được để trống. Vui lòng nhập lại: ");
            title = sc.nextLine();  // Cho phép nhập lại nếu bị rỗng
        }

        this.title = title;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Scanner sc = new Scanner(System.in);
        while (year < 1970){
            System.out.println("Năm xuất bản phải từ 1970 trở đi. Vui lòng nhập lại.");
            year = sc.nextInt();
        }
        this.year = year;
    }

    public String inputBookId(Scanner sc){
        while(true){
            System.out.println("Nhập id của sách: ");
            this.bookId = sc.nextLine();

            if(this.bookId.matches(regexBookId)){
                return bookId;
            }
            System.out.println("Id không hợp lệ. Vui lòng nhập lại");
        }
    }

    public String inputBookName(Scanner sc){
        while(true){
            System.out.println("Nhập tên sách:");
            this.bookName = sc.nextLine();

            if(this.bookName.matches(regexBookName)){
                return bookName;
            }else{
                System.out.println("Tên sách không hợp lệ. Vui lòng nhập lại");
            }
        }
    }

    public double inputImportPrice(Scanner sc){
        while(true){
            System.out.println("Nhập vào giá nhập:");
            this.importPrice = sc.nextDouble();

            if(this.importPrice > 0){
                return importPrice;
            }
            System.out.println("Giá xuất phải lớn hơn 0. Vui lòng nhập lại.");
        }
    }

    public double inputExportPrice(Scanner sc){
        while(true){
            System.out.println("Nhập vào giá xuất");
            this.exportPrice = sc.nextDouble();

            if(this.exportPrice > 0 && this.exportPrice >= this.importPrice * 1.1){
                return exportPrice;
            }
            System.out.println("Giá xuất phải lớn hơn 0. Vui lòng nhập lại.");
        }
    }

    public String inputTitle(Scanner sc){
        while(true){
            System.out.println("Nhâp tiêu đề:");
            this.title = sc.nextLine();

            if(!this.title.isEmpty()){
                return title;
            }
            System.out.println("Tiêu đề không được để trống. Vui lòng nhập lại.");
        }
    }

    public String inputAuthor(Scanner sc){
        while(true){
            System.out.println("Nhâp tác giả:");
            this.author = sc.nextLine();

            if(!this.author.isEmpty()){
                return author;
            }

            System.out.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
        }
    }

    public int inputYear(Scanner sc){
        while(true){
            System.out.println("Nhập năm xuất bản:");
            this.year = sc.nextInt();

            if(this.year >= 1970){
                return year;
            }
            System.out.println("Năm xuất bản phải từ 1970 trở đi. Vui lòng nhập lại.");
        }
    }

    public void inputData(Scanner sc) {
        sc.nextLine();
        inputBookId(sc);
        inputBookName(sc);

        inputImportPrice(sc);
        sc.nextLine();

        inputExportPrice(sc);
        sc.nextLine();

        inputTitle(sc);
        inputAuthor(sc);

        inputYear(sc);
        sc.nextLine();
    }


    public void displayBook(){
        System.out.printf("Book ID: %s\n", this.bookId);
        System.out.printf("Book Name: %s\n", this.bookName);
        System.out.printf("Import Price: %.2f\n", this.importPrice);
        System.out.printf("Export Price: %.2f\n", this.exportPrice);
        System.out.printf("Title: %s\n", this.title);
        System.out.printf("Author: %s\n", this.author);
        System.out.printf("Interest: %.2f\n", this.interest);
        System.out.printf("Year: %d\n", this.year);
    }

    public double callInterest(){
        return exportPrice - importPrice;
    }
}
