/**
 * ..
 *
 * @author 2023210515
 * @date 2023/11/19
 * 16:16
 */
public class Fiction extends Book{
    private String author;
    private String title;
    private String genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
