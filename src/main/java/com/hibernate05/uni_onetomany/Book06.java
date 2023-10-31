package com.hibernate05.uni_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {
    @Id
    private int id;//Integer Almak demek null almak demek..
    private String name;

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
    //toString

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
