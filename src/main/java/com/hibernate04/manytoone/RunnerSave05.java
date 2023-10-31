package com.hibernate04.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {

        Student05 student1= new Student05();
        student1.setId(1001);
        student1.setName("Zafer Kanbur");
        student1.setGrade(10);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Yusuf Kaplan");
        student2.setGrade(9);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Yigit Bey");
        student3.setGrade(8);

        University university = new University();
        university.setId(1);
        university.setName("TPE Unv");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
