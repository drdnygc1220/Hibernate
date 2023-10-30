package com.hibernate03.uni_direction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity//create
public class Diary {

    @Id
    private int id;
    private String name;
    @OneToOne//alter table
    //column yazmak zorunda degilim
    //@JoinColumn(name="std_id")  yazarsam kolaylıla set etmesini saglarım.
    private Student03 student;

    //getter-setter-toString

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
