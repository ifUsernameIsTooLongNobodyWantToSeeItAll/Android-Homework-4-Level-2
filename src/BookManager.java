import java.util.Scanner;

/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 16:31
 */
public class BookManager {
    //    addBook() 方法：将图书对象添加到管理类中。
//    removeBook() 方法：根据图书对象的属性，从管理类中移除图书对象。
//    updateBook() 方法：根据图书对象的属性，更新图书对象的信息。
//    getBook() 方法：根据图书对象的属性，获取图书对象的信息。
//    getAllBooks() 方法：获取所有图书对象的列表。
    public static int number = 0;
    public static int nnumber = 0;

    public static int findBook() {
        System.out.println("Please enter 1 to find by title, enter 2 to find by author(All of the same author will be deleted,\n enter 3 to find by fiction/nonfiction");
        int choice = new Scanner(System.in).nextInt();
        boolean intAvailable = false;
        while (!intAvailable) {
            switch (choice) {
                case 1:
                    intAvailable = true;
                    System.out.println("Please enter the title:");
                    String find = new Scanner(System.in).nextLine();
                    for (int i = 0; i < number; i++) {
                        if (find.equalsIgnoreCase(Main.books.get(i).getTitle())) {
                            return i;
                        }
                    }
                    for(int i = 0; i < nnumber; i++){
                        if (find.equalsIgnoreCase(Main.books.get(i).getTitle())) {
                            return -i-1;
                        }
                    }
                    break;
                case 2:
                    intAvailable = true;
                    System.out.println("Please enter the name of the author");
                    String find2 = new Scanner(System.in).nextLine();
                    for (int i = 0; i <= number; i++) {
                        if (find2.equalsIgnoreCase(Main.books.get(i).getAuthor())) {
                            return i;
                        }
                    }
                    for(int i = 0; i <= nnumber; i++){
                        if (find2.equalsIgnoreCase(Main.books.get(i).getAuthor())) {
                            return -i-1;
                        }
                    }
                    break;
                case 3:
                    intAvailable = true;
                    System.out.println("What kind of book do you want to find");
                    System.out.println("Enter 1 or \"fiction\" to choose fiction book, enter 2 or \"non-fiction\" to choose non-fiction book ");
                    Scanner scanner = new Scanner(System.in);
                    String reply = scanner.nextLine();
                    boolean availableInput = false;
                    while (!availableInput) {
                        if (reply.equals("1") || reply.equalsIgnoreCase("fiction")) {
                            availableInput = true;
                            for (int i = 0; i < number; i++) {
                                if (Main.books.get(i) != null) {
                                    System.out.println("Book " + i);
                                    System.out.println("Title: " + Main.books.get(i).getTitle());
                                    System.out.println("Author: " + Main.books.get(i).getAuthor());
                                    System.out.println("Genres: " + Main.books.get(i).getGenre());
                                }
                                System.out.println("Which one do you want to find?");
                                int delete = new Scanner(System.in).nextInt();
                                for (int j = 0; j <= number; j++) {
                                    if (j == delete) {
                                        return j;
                                    }
                                }
                            }
                        } else if (reply.equals("2") || reply.equalsIgnoreCase("non-fiction") || reply.equalsIgnoreCase("nonfiction")) {
                            availableInput = true;
                            for (int i = 0; i < nnumber; i++) {
                                if (Main.nbooks.get(i) != null) {
                                    System.out.println("Book " + i);
                                    System.out.println("Title: " + Main.nbooks.get(i).getTitle());
                                    System.out.println("Author: " + Main.nbooks.get(i).getAuthor());
                                    System.out.println("Subject: " + Main.nbooks.get(i).getAuthor());
                                }
                                System.out.println("Which one do you want to delete?");
                                int delete = new Scanner(System.in).nextInt();
                                for (int j = 0; j <= nnumber; j++) {
                                    if (j == delete) {
                                        return -j-1;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Please retry!");
                            System.out.println("What book do you want to delete?");
                            System.out.println("Please enter 1 to find by title, enter 2 to find by author(All of the same author will be deleted,\n enter 3 to find by fiction/nonfiction");
                        }
                    }
                default:
                    System.out.println("Please retry!");
                    System.out.println("What book do you want to delete?");
                    System.out.println("Please enter 1 to find by title, enter 2 to find by author(All of the same author will be deleted,\n enter 3 to find by fiction/nonfiction");
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void addBook() {
        System.out.println("What kind of book do you want to add?");
        System.out.println("Enter 1 or \"fiction\" to add a fiction book, enter 2 or \"non-fiction\" to add a non-fiction book ");
        Scanner scanner = new Scanner(System.in);
        String reply = scanner.nextLine();
        if (reply.equals("1") || reply.equalsIgnoreCase("fiction")) {
            Main.books.add(new Fiction());
        } else if (reply.equals("2") || reply.equalsIgnoreCase("non-fiction") || reply.equalsIgnoreCase("nonfiction")) {
            Main.nbooks.add(new NonFiction());
        }

        if(reply.equals("1") || reply.equalsIgnoreCase("fiction")){
            System.out.println("Please enter the author of the book");
            String author = scanner.nextLine();
            Main.books.get(number).setAuthor(author);
            System.out.println("Please enter the title of the book");
            String title = scanner.nextLine();
            Main.books.get(number).setTitle(title);
            System.out.println("Please input the genres");
            String genre = scanner.nextLine();
            Main.books.get(number).setGenre(genre);
            number++;
        }else{
            System.out.println("Please enter the author of the book");
            String author = scanner.nextLine();
            Main.nbooks.get(nnumber).setAuthor(author);
            System.out.println("Please enter the title of the book");
            String title = scanner.nextLine();
            Main.nbooks.get(nnumber).setTitle(title);
            System.out.println("Please input the subjects of the book");
            String subject = scanner.nextLine();
            Main.nbooks.get(nnumber).setSubject(subject);
            nnumber++;
        }
    }

    public static void removeBook() {
        System.out.println("What book do you want to delete?");
        int a = findBook();
        if (a == Integer.MAX_VALUE) {
            System.out.println("Not find!");
        } else {
            if(a>0) {
                Main.books.remove(a);
            }
            else{
                Main.nbooks.remove(-(a+1));
            }
        }
    }

    public static void updateBook() {
        System.out.println("What book do you want to update?");
        int a = findBook();
        if (a == Integer.MAX_VALUE) {
            System.out.println("Not find!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the author of the book");
            String author2 = scanner.nextLine();
            if(a>=0) {
                Main.books.get(a).setAuthor(author2);
                System.out.println("Please enter the title of the book");
                String title2 = scanner.nextLine();
                Main.books.get(a).setTitle(title2);
                System.out.println("Please enter the genres of the book");
                String genre = scanner.nextLine();
                Main.books.get(number).setGenre(genre);
            }else{
                Main.nbooks.get(-(a+1)).setAuthor(author2);
                System.out.println("Please enter the title of the book");
                String title2 = scanner.nextLine();
                Main.nbooks.get(-(a+1)).setTitle(title2);
                System.out.println("Please enter the subjects of the book");
                String genre = scanner.nextLine();
                Main.nbooks.get(nnumber).setSubject(genre);
            }
        }
    }

    public static void getBook(int a) {

        if (a == Integer.MAX_VALUE) {
            System.out.println("Not find!");
        } else {
            if (a>0) {
                System.out.println("Book " + a);
                System.out.println("Title: " + Main.books.get(a).getTitle());
                System.out.println("Author: " + Main.books.get(a).getAuthor());
                System.out.println("It's a fiction, genre is "+ Main.books.get(a).getGenre());
            } else {
                System.out.println("Book " + -(a+1));
                System.out.println("Title: " + Main.nbooks.get(-(a+1)).getTitle());
                System.out.println("Author: " + Main.nbooks.get(-(a+1)).getAuthor());
                System.out.println("It's a non-fiction, subject is "+ Main.nbooks.get(-(a+1)).getSubject());
            }
        }
    }
    public static void getAllBooks(){
        for(int i = 0; i < number; i++){
            getBook(i+1);
        }
        for(int i = 0; i < nnumber; i++){
            getBook(-i-1);
        }
        System.out.println();
    }
}


