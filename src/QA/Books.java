package QA;

public class Books {
    private String name;
    private int isb;

    public Books(String name, int isb) {
        this.name = name;
        this.isb = isb;
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

    public void setIsbn(int isb) {
        this.isb = isb;
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", isbn=" + isb +
                '}';
    }
}
