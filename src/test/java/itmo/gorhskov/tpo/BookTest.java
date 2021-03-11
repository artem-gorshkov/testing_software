package itmo.gorhskov.tpo;

import itmo.gorhskov.tpo.task3.Book;
import itmo.gorhskov.tpo.task3.Editor;
import itmo.gorhskov.tpo.task3.Information;
import itmo.gorhskov.tpo.task3.InformationType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    Editor editor = new Editor();

    @Test
    void checkEntertainingBook() {
        Book book = new Book("Hitchhiker's Guide to the Galaxy");
        List<Information> inf = book.getInformation();
        inf.add(new Information("Entertaining", "bump"));
        assertTrue(editor.checkIfBookEntertaining(book));
    }

    @Test
    void checkSadBook() {
        Book book = new Book("Hitchhiker's Guide to the Galaxy");
        List<Information> infList = book.getInformation();
        Information inf = new Information("Sad", "She start to cry");
        infList.add(inf);
        assertEquals(InformationType.SAD, editor.checkInformation(inf));
    }

    @Test
    void checkFunnyBook() {
        Book book = new Book("Hitchhiker's Guide to the Galaxy");
        List<Information> infList = book.getInformation();
        Information inf = new Information("Sad", "She start to do haha");
        infList.add(inf);
        assertEquals(InformationType.FUNNY, editor.checkInformation(inf));
    }

    @Test
    void checkOrdinaryBook() {
        Book book = new Book("Hitchhiker's Guide to the Galaxy");
        List<Information> infList = book.getInformation();
        Information inf = new Information("Ordinary topic", "It was a good day");
        infList.add(inf);
        assertEquals(InformationType.ORDINARY, editor.checkInformation(inf));
    }
}
