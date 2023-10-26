package com.hibernate01.annotation;

import javax.persistence.*;
import java.util.Arrays;

@Entity//Entity koydugumuz sınıf,Veritabanında bir tabloya karşılık gelecek//student01 şeklinde oluşur tablo
@Table(name="t_student01") //oluşacak tablonun adını degiştirebiliriz.

public class Student01 {//t_student01 oldu
    //1-database de(SQL) artık tablomuz :t_student01 oldu bunu kullanmak zorundayım.
    //2-java dayken classın ismiyle yapacagım :Student01

    //encapsulation yapmış oluyorum private de getter olabilir ama set edilemesin
    //PK OLMASI LAZIM:@ID=Aşagıdaki değişkeni pk yaptı;bir classın içinde bir tane primarkey olur
    @Id//Primary key
    private int id;

    @Column(name="student_name",length = 100,nullable = false,unique = false)
    //column:1.avantajı tablodaki header customize etmek
    //2.avantajı lenght karakterini ayırabiliyorum.
    //3.avantaj not null yaptık:nullable
    //4.avantaj unique olmasın:false ahmet adında iki öğrenci olabilir.

    //öğrenci ismi
    private String name;//javada:student1.name;DB ye gittiğimizde student_name olsun diyorsam


    //@Transient:DB de grade isminde bir kolon OLUŞMASIN.
    private int grade;


    //ÖĞRENCİ RESİM,ses ,video =byte[] olarak yazılır.
    //dosyanın hacmi yukarıdakilerden daha yüksek,verisi büyük olsun demek:Lob=LARGE OBJECT
    @Lob
    private byte[] image;


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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    //toString

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
