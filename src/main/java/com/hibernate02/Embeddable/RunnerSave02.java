package com.hibernate02.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student1=new Student02();
        student1.setId(1001);
        student1.setName("AHSEN YAĞCI");
        student1.setGrade(80);
        //adres nesnesi oluşturmam lazım
        Address address1=new Address();
        address1.setCity("istanbul");
        address1.setCountry("turkey");
        address1.setStreet("Apple stret");
        address1.setZipCode("06853");

        student1.setAddress(address1);

        Address address2=new Address();
        address2.setCity("istanbul");
        address2.setCountry("turkey");
        address2.setStreet("orange stret");
        address2.setZipCode("06953");

        //öğrenci üzerinden oluşturacagım.
        Student02 student2=new Student02();
        student2.setId(1002);
        student2.setName("feyyaz yagcı");
        student2.setGrade(80);

        student2.setAddress(address2);

        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        //session oluşturmam lazım
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        //transaction başlatıypruz..
        Transaction tx=session.beginTransaction();

        //iki öğrenciyi kaydediyorum.
        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        sf.close();


    }
}
