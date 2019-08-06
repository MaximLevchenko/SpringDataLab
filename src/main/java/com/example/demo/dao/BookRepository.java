package com.example.demo.dao;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.GanreEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Brainacad4 on 06.08.2019.
 */
public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findBooksByAuthor(Author author);
    List<Book>findBooksByGanreIn(Collection<GanreEnum>ganres);
}
