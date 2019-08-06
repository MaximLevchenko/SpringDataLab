package com.example.demo.service;

import com.example.demo.dao.AuthorRepository;
import com.example.demo.dao.BookRepository;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.GanreEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Brainacad4 on 06.08.2019.
 */
@Service
public class BookLibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookLibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void addNewBook(Book book) {
        Author author = book.getAuthor();
        if (author == null) {
            throw new RuntimeException("Impossible to save book without an author");

        }
        if (author.getId() == null) {
            author = authorRepository.save(author);
            book.setAuthor(author);
        }
        bookRepository.save(book);
    }

    public Author findAuthorByFullName(String name, String secondName, String lastName) {
        Author author = authorRepository
                .getAuthorByNameAndSecondNameAndLastName(name, secondName, lastName)
                .orElse(null);
        if (author == null) {
            throw new RuntimeException("Impossible to find person by full name");
        }
        return author;
    }

    public List<Book> findBooksByGanres(Set<GanreEnum> ganres) {
        System.out.println("Output of books according to ganres");

        return bookRepository.findBooksByGanreIn(ganres);
    }

    public List<Book> findBooksByAuthor(String name, String secondName, String lastName) {
        System.out.println("Output of books according to authors");
        Author author = findAuthorByFullName(name, secondName, lastName);
        return bookRepository.findBooksByAuthor(author);


    }
}

