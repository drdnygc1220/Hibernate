package com.hibernate09.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("*************** ilk get islemi --> 1 id li ogrenci icin");
        Student12 student1 = session.get(Student12.class, 1L);

        // session.clear(); // cache bellek silinir

        System.out.println("*************** ikinci get islemi --> 1 id li ogrenci icin");
        Student12 student2 = session.get(Student12.class, 1L);


        tx.commit();
        session.close();

        Session session2 =  sf.openSession();
        Transaction tx1 = session2.beginTransaction();

        System.out.println("*************** session.close sonrasi get islemi --> 1 id li ogrenci icin");
        Student12 student3 = session2.get(Student12.class, 1L);

        tx1.commit();
        session2.close();

        Session session3 = sf.openSession();
        Transaction tx2 = session3.beginTransaction();

        System.out.println("*************** session.close sonrasi get islemi --> 1 id li ogrenci icin");
        Student12 student4 = session3.get(Student12.class, 1L);

        tx2.commit();
        session3.close();
        sf.close();

    }
}

