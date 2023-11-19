/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 16:07
 */
public abstract class Book {
    private String title;
    private String author;

    public abstract String getAuthor();
    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract void setAuthor(String author);
}
