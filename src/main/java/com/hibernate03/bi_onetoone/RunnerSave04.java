package com.hibernate03.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1 = new Student04();
        student1.setId(1001);
        student1.setName("Yusuf Kaplan");
        student1.setGrade(80);

        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Sinan Sarikaya");
        student2.setGrade(80);

        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Sezer Genc");
        student3.setGrade(80);

        Diary04 diary1 = new Diary04();
        diary1.setId(101);
        diary1.setName("Yusuf beyin Günlüğü");
        diary1.setStudent(student1);//ilişkinin düzgün kurulabilmesi için diary tarafında student setlenmesi gerekiyor.
       // student1.setDiary(student1);..
        //student1 gidip diary de setleyebiliriz artık

        Diary04 diary2 = new Diary04();
        diary2.setId(102);
        diary2.setName("Sinan Beyin Gunlugu");
        diary2.setStudent(student2);//burada aslında onetoone yapıyoruz

        Diary04 diary3=new Diary04();
        diary3.setId(103);
        diary3.setName("Kimseye ait değil");

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);//2 tane entity clas var

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        //student ve diary kaydet..3 günlük 3 öğrenci
        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);



        tx.commit();
        sf.close();
        session.close();

    }
}

