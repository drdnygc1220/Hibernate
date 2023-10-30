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

        Diary04 diary2 = new Diary04();
        diary2.setId(102);
        diary2.setName("Sinan Beyin Gunlugu");

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();






        tx.commit();
        sf.close();
        session.close();

    }
}

