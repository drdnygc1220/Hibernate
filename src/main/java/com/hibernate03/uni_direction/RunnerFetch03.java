package com.hibernate03.uni_direction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);//2 tane ENTİTY class oldugu için ikisinide ekledim.

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // !!! student fetch ediyourz id ile
        Student03 student = session.get(Student03.class, 1001);//SELECT:get den dolayı
        // !!! diary fetch ediyoruz
        Diary diary = session.get(Diary.class, 101);

        System.out.println("===========" + student);//student gelir:left joın yaptık
        System.out.println("----------------------------------");
        System.out.println(diary);//diary+student
        System.out.println("----------------------------------");
        System.out.println(diary.getStudent());//sadece student classını getirir.


        tx.commit();
        //acılma sırasıyla kapatıyorum..
        session.close();
        sf.close();
    }
}
