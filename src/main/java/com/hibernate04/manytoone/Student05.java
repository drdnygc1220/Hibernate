package com.hibernate04.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {
    @Id
    private int id;
    @Column(name="student_name",nullable = false)
    private String name;
    private int grade;
    private LocalDateTime createOn;//create edilme tarihi ve saati
    //bunu setlemem lazım.

    @ManyToOne
    @JoinColumn(name="university_id")//kolonu burada oluşturmamız gerek (diğer türlü coklu kısım unıversite tablosunda student id kısmı daha kalabalık.)
    private University university;//Many(student),One(unıversty)
    // cok olan classda oldugu için manytoone diyorum

    @PrePersist//nesne save edilme tarihi ve saati set ediyor
    private void prePersist(){
        createOn=LocalDateTime.now();
    }
    //geter-setter


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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

  //  public void setCreateOn(LocalDateTime createOn) {
  //      this.createOn = createOn;
   // }:yukarıda createOn degişkenini prepersist değişkeniyle ben zaten setledim.

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    //toString
    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
