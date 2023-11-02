package com.hibernate08.idgeneration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {

    public static void main(String[] args) {

        Student10 student1 = new Student10();
        student1.setName("Ahmet");
        student1.setGrade(80);

        Student10 student2 = new Student10();
        student2.setName("Mehmet");
        student2.setGrade(80);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        sf.close();

    }
}

