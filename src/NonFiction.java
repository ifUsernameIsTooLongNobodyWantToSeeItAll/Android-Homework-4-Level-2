/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 16:17
 */
public class NonFiction extends Book{
    private String author;
    private String title;
    private String subject;
    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
