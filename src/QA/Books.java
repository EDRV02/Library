package QA;

public class Books {
    private String name;
    private int isbn;

    public Books(String name, int isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
