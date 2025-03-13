package Books;

import java.util.Scanner;

public class TestBook {
    private static Book[] books = new Book[100];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("--------------------MENU------------------");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách ");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách ");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần ");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)");
            System.out.println("9. Thống kê sách theo mỗi tác giả ");
            System.out.println("10. Thoát");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printBook(sc);
                    break;
                case 2:
                    addBook(sc);
                    break;
                case 3:
                    calculateInterest();
                    break;
                case 4:
                    updateBook(sc);
                    break;
                case 5:
                    deleteBook(sc);
                    break;
                case 6:
                    sortInterest(sc);
                    break;
                case 7:
                    searchAuthor(sc);
                    break;
                case 8:
                    searchBookByPrice(sc);
                    break;
                case 9:
                    statisticAuthor(sc);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn lại từ 1 - 9");
            }
        } while (true);
    }

    public static void printBook(Scanner sc) {
        System.out.println("----------------Danh sách sách---------------");
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayBook();
            System.out.println("--------------------------------------");
        }
    }

    public static void addBook(Scanner sc) {
        Book newBook = new Book();

        newBook.inputData(sc);

        books[currentIndex++] = newBook;
        System.out.println("Thêm sách thành công");
    }

    public static void calculateInterest() {
        for (int i = 0; i < currentIndex; i++) {
            books[i].setInterest(books[i].callInterest());
        }
        System.out.println("Tinh lợi nhuận thành công");
    }

    public static void updateBook(Scanner sc) {
        System.out.println("Nhập vào 1 id cần cập nhật");
        if (sc.hasNextLine()) sc.nextLine();
        String bookId = sc.nextLine();
        int findIndex = findBookById(bookId);
        if (findIndex == -1) {
            System.out.println("Không tìm thấy id trong danh sach");
        } else {
            while (true) {
                System.out.println("-------------CẬP NHẬT THÔNG TIN SÁCH--------------");
                System.out.println("1. Cập nhật tên sách");
                System.out.println("2. Cập nhật giá nhập");
                System.out.println("3. Cap nhật giá xuất");
                System.out.println("4. Cập nhật tiêu đề");
                System.out.println("5. Cập nhật tác giả");
                System.out.println("6. Cập nhật năm xuất bản");
                System.out.println("7. Trở về menu chính");
                System.out.printf("Lựa chọn của bạn: ");

                int choice2 = sc.nextInt();

                if (choice2 == 7) {
                    break;
                }

                switch (choice2) {
                    case 1:
                        System.out.println("Nhập tên sách:");
                        if (sc.hasNextLine()) sc.nextLine();
                        books[findIndex].setBookName(sc.nextLine());
                        System.out.println("Cập nhật tên sách thành công");
                        break;
                    case 2:
                        System.out.println("Nhập giá nhập");
                        books[findIndex].setImportPrice(sc.nextDouble());
                        System.out.println("Cập nhật giá nhập thành công");
                        break;
                    case 3:
                        System.out.println("Nhập giá xuất");
                        books[findIndex].setExportPrice(sc.nextDouble());
                        System.out.println("Cập nhật giá xuất thành công");
                        break;
                    case 4:
                        System.out.println("Nhập tiêu đề");
                        books[findIndex].setTitle(sc.nextLine());
                        System.out.println("Cập nhật tiêu đề thành công");
                        break;
                    case 5:
                        System.out.println("Nhập tác giả");
                        books[findIndex].setAuthor(sc.nextLine());
                        System.out.println("Cập nhật tác giả thành công");
                        break;
                    case 6:
                        System.out.println("Nhập năm xuất bản");
                        books[findIndex].setYear(sc.nextInt());
                        System.out.println("Cập nhật năm xuất bản thành công");
                        break;
                    default:
                        System.out.println("Vui lòng nhập từ 1 - 7");
                }
            }
        }
    }

    public static void deleteBook(Scanner sc) {
        System.out.println("Nhập vào 1 id cần xóa");
        if (sc.hasNextLine()) sc.nextLine();
        String bookId = sc.nextLine();
        int findIndex = findBookById(bookId);

        if(findIndex == -1) {
            System.out.println("Không tìm thấy id trong danh sach");
        }else{
            for(int i = findIndex; i < currentIndex - 1; i++) {
                books[i] = books[i + 1];
            }
            books[currentIndex - 1] = null;
            currentIndex--;

            System.out.println("Xóa thông tin sách thành công!");
        }
    }

    public static int findBookById(String bookId) {
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookId().equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public static void sortInterest(Scanner sc) {
        for (int i = 0; i < currentIndex; i++) {
            boolean isSwapped = false;
            for(int j = 0; j < currentIndex - i - 1; j++) {
                if(books[j].getInterest() > books[j + 1].getInterest()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }
        System.out.println("Đã sắp xếp!!");
    }

    public static void searchAuthor(Scanner sc) {
        System.out.println("Nhập tác giả cần tìm");
        if (sc.hasNextLine()) sc.nextLine();
        String author = sc.nextLine();

        boolean isFound = false;

        for(int i = 0; i < currentIndex; i++) {
            if(books[i].getAuthor().equals(author)) {
                books[i].displayBook();
                System.out.println("--------------------------------------");
                isFound = true;
            }
        }

        if(!isFound) {
            System.out.println("Không tìm thấy tác giả");
        }
    }

    public static void searchBookByPrice(Scanner sc) {
        System.out.println("Nhập vào khoảng giá:");
        if (sc.hasNextLine()) sc.nextLine();
        double priceMin = sc.nextDouble();
        double priceMax = sc.nextDouble();

        boolean isFound = false;

        for(int i = 0; i < currentIndex; i++) {
            if(books[i].getExportPrice() >= priceMin && books[i].getExportPrice() <= priceMax) {
                books[i].displayBook();
                System.out.println("--------------------------------------");
                isFound = true;
            }
        }
        if(!isFound) {
            System.out.println("Không có sách nằm trong khoảng giá này!");
        }
    }

    public static void statisticAuthor(Scanner sc) {
        String[] authors = new String[currentIndex];
        int[] counts = new int[currentIndex];
        int authorCount = 0;

        for(int i = 0; i < currentIndex; i++) {
            String author = books[i].getAuthor();

            boolean isFound = false;
            for(int j = 0; j < authorCount; j++) {
                if(authors[j].equals(author)) {
                    counts[j]++;
                    isFound = true;
                    break;
                }
            }

            if(!isFound) {
                authors[authorCount] = author;
                counts[authorCount] = 1;
                authorCount++;
            }
        }

        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < authorCount; i++) {
            System.out.println("Tác giả: " + authors[i] + " - Số sách: " + counts[i]);
        }
    }
}
