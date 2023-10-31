package com.hibernate05.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        // !!! 3 Student objesi
        Student07 student1 = new Student07();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(11);

        Student07 student3 = new Student07();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(9);

        // !!! 5 Book objesi
        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("John's Art Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("John's Math Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("James's Java Book");

        Book07 book4 = new Book07();
        book4.setId(104);
        book4.setName("James's Hibernate Book");

        Book07 book5 = new Book07();
        book5.setId(105);
        book5.setName("Tony's JS Book");

        // setleme islemi -->  book uzerinden student setlenir
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        tx.commit();
        session.close();
        sf.close();


    }
}
