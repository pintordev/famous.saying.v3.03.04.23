package application.famousSaying.entity;

public class FamousSaying {
    private long id;
    private String author;
    private String contents;

    public FamousSaying(long id, String author, String contents) {
        this.id = id;
        this.author = author;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getList() {
        return this.id +
                " / " + this.author +
                " / " + this.contents;
    }
}
