package com.hibernate02.embeddable;

import javax.persistence.*;
//ADRESS CLASSI GİBİ EMBEDABLE CLASSI BİRDEN FAZLA OLABİLİR.
@Entity
@Table(name="t_student02")
public class Student02 {
    //tablonun headrları;id,student_name,greate,adress(street,city,country,zp)
    @Id
    private int id;
    @Column(name="student_name",length = 100,nullable = false,unique = false)
    private String name;

    private int grade;

    //!!!!!!!
    //embeddable:tablo oluşturmayıp diğer tablo içinde okunmasını saglıyor aslında burada yazmasada olabilir.
   // @Embeddable =NORMALDE BİR NESNE İÇİN 4 TANE GET YAPIP GETİRMEM LAZIM.
    //ARTIK NESNE OLDUGU İÇİN GİTTİĞİ YERE KENDİ FIELDLARI İLE GİDİYOR.
    private Address address;

    //GETTER-SETTER-TOSTRİNG

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
