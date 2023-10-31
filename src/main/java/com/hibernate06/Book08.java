package com.hibernate06;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book08 {

    @Id
    private int id;

    private String name;

    @ManyToMany
    private List<Student08> students= new ArrayList<>();

}
