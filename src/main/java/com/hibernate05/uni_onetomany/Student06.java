package com.hibernate05.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {
    @Id
    private int id;
    @Column(name="student_name",nullable = false)
    private String name;

    private int grade;

    @OneToMany//tekil bir değişken ile bırakamam
    @JoinColumn//FK burada olsun istesekde hibernate buna izin vermiyor,many tarafına atıyor
    //hibernate da farkı olmaz ama corejava kısmında inanlımaz değişir.
    //iki taraftada joıncolumn yazmassak üçüncü bir tablo oluşturur.
    private List<Book06> bookList=new ArrayList<>();

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

   // public void setBookList(List<Book06> bookList) {
      //  this.bookList = bookList;
    //}

    //toString
    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
