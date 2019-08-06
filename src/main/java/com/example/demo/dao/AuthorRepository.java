package com.example.demo.dao;

import com.example.demo.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Brainacad4 on 06.08.2019.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> getAuthorByNameAndSecondNameAndLastName(String name, String secondName,
                                                             String lastName);

    @Query("from Author a where a.name=?1and a.secondName=?2 and a.lastName=?3")
    Optional<Author> getAuthorByFullName(String name, String secondName, String lastName);

}
