package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.GanreEnum;
import com.example.demo.service.BookLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {
    @Autowired
    private BookLibraryService bookLibraryService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        addTestRoman();
        addTestFantasy();
        printAuthorBooks();
        printFilteredBooks();
    }

    private void printFilteredBooks() {
        Set<GanreEnum> ganres = new HashSet<>();
        ganres.add(GanreEnum.FANTAZY);
        ganres.add(GanreEnum.ROMAN);
        List<Book> books = bookLibraryService
                .findBooksByGanres(ganres);
        books.forEach(System.out::println);
    }

    private void printAuthorBooks() {
        List<Book> books = bookLibraryService
                .findBooksByAuthor("Inokentiy", "Pedrosovich", "Pypuryshkin");
        books.forEach(System.out::println);
    }

    private void addTestFantasy() {
        Book book = new Book();
        book.setBooking("Roof on the Chekists's street");
        book.setGanre(GanreEnum.FANTAZY);
        book.setName("Lord Of RIngs");
        book.setPagesCount(350);
        book.setReleaseDate(Year.of(2005));

        Author author = bookLibraryService
                .findAuthorByFullName("Inokentiy", "Pedrosovich", "Pypuryshkin");
        book.setAuthor(author);
        bookLibraryService.addNewBook(book);
    }

    private void addTestRoman() {
        Book book = new Book();
        book.setBooking("Подвал на улице Ленина");
        book.setName("Армено и Жилетта");
        book.setPagesCount(400);
        book.setReleaseDate(Year.of(2017));
        book.setGanre(GanreEnum.ROMAN);

        Author author = new Author();
        author.setName("Inokentiy");
        author.setSecondName("Pedrosovich");
        author.setLastName("Pypuryshkin");
        author.setBirthDate(LocalDate.of(1990, 4, 12));
        book.setAuthor(author);
        bookLibraryService.addNewBook(book);
    }
}
