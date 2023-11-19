import java.util.ArrayList;
import java.util.Scanner;

/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 16:04
 */


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static NewArrayList<Fiction> books = new NewArrayList<Fiction>();
    public static NewArrayList<NonFiction> nbooks = new NewArrayList<NonFiction>();

    public static void main(String[] args) {
        System.out.println("----------Library-----------");
        System.out.println("Enter 1 to add books, 2 to remove, 3 to update, 4 to get a book, 5 to get all books, other to quit");
/*addBook() 方法：将图书对象添加到管理类中。
removeBook() 方法：根据图书对象的属性，从管理类中移除图书对象。
updateBook() 方法：根据图书对象的属性，更新图书对象的信息。
getBook() 方法：根据图书对象的属性，获取图书对象的信息。
getAllBooks()*/
        int choice = new Scanner(System.in).nextInt();
        while (choice <= 5 && choice >= 1) {
            switch (choice) {
                case 1:
                    BookManager.addBook();
                    break;
                case 2:
                    BookManager.removeBook();
                    break;
                case 3:
                    BookManager.updateBook();
                    break;
                case 4:
                    System.out.println("What book do you want to get?");
                    int a = BookManager.findBook();
                    BookManager.getBook(a);
                    break;
                case 5:
                    BookManager.getAllBooks();
                    break;
                default:
                    break;
            }
            System.out.println("Enter 1 to add books, 2 to remove, 3 to update, 4 to get a book, 5 to get all books");
            choice = new Scanner(System.in).nextInt();
        }
    }
}