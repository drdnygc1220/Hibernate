package com.hibernate06;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {

    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;

    @ManyToMany
    @JoinTable(
            name = "student08_book08",
            joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book08> bookList = new ArrayList<>();
}