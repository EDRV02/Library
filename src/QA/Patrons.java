package QA;
import java.util.*;

public class Patrons {
    private String name;

    @Override
    public String toString() {
        return "Patrons{" +
                "name='" + name + '\'' +
                '}';
    }

    public Patrons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
