package com.hibernate10.life_cycle_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

    public static void main(String[] args) {

        Student14 student1 = new Student14(); // !!! Transient State
        student1.setName("Fatma Ersoz");
        student1.setMathGrade(10);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); // !!! Persistent State

        student1.setName("Updated in persisted state");

        session.evict(student1); //!!! detach STate ( uyku)

        student1.setName("Updated in detach");

        session.update(student1); //!!! uyku modundan detach atate den persistent state e alindi
        session.merge(student1);

        tx.commit();
        session.close();
        sf.close();
    }
}

