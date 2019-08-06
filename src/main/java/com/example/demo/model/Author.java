package com.example.demo.model;

/**
 * Created by Brainacad4 on 06.08.2019.
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
