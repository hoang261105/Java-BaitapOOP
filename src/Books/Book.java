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
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
        this.year = year;
    }

    public String inputBookId(Scanner sc){
        while(true){
            System.out.println("Nhập id của sách: ");
            this.bookId = sc.nextLine();

            String regexBookId = "^B.{4}$";

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

            String regexBookName = "^.{6,100}$";

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
