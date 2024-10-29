package QA;

public class Books {
    private int bookId;
    private String name;
    private int isb;
    private String author;
    private boolean isAvailable; // Status of availability

    public Books(int bookId, String name, int isb, String author) {
        this.bookId = bookId;
        this.name = name;
        this.isb = isb;
        this.author = author;
        this.isAvailable = true; // by default a new book is available
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsb() {
        return isb;
    }

    public void setIsb(int isb) {
        this.isb = isb;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", isb='" + isb + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
