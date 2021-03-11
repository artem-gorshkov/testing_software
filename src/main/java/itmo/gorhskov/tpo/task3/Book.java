package itmo.gorhskov.tpo.task3;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private List<Information> information;

    public Book(String name) {
        this.name = name;
        information = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Information> getInformation() {
        return information;
    }

    public void setInformation(List<Information> information) {
        this.information = information;
    }
}
