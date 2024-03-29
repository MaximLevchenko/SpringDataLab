package com.example.demo.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;

/**
 * Created by Brainacad4 on 06.08.2019.
 */
@Entity
@Table(name = "book_library")
@NoArgsConstructor
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "pages", nullable = false)
    private Integer pagesCount;
    @Column
    private Year releaseDate;
    @Column
    private String booking;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @Column(name = "ganre",nullable = false)
    @Enumerated(EnumType.STRING)
    private GanreEnum ganre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Year getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Year releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public GanreEnum getGanre() {
        return ganre;
    }

    public void setGanre(GanreEnum ganre) {
        this.ganre = ganre;
    }



}
