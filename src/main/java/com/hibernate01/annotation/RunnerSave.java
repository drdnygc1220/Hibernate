package com.hibernate01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        Student01 student1=new Student01();
        student1.setId(1001);
        student1.setName("DÜRDANE YAĞCI");
        student1.setGrade(90);

        Student01 student2=new Student01();
        student2.setName("FEYYAZ YAĞCI");
        student2.setId(1002);
        student2.setGrade(90);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("FEYZA YAĞCI");
        student3.setGrade(90);

        //CON. nesnesi oluşturuyorum
        //Hibernate e konfigurasyon ve entitu sınıflarımı gösteriyorum.
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

       SessionFactory sf= con.buildSessionFactory();//bana bir tane seşın gönder:open.Session
        Session session= sf.openSession();//seşına=oturuma ihtiyac vardı onu yaptık burada.

        //transaction oluşturmam lazım
        Transaction tx=session.beginTransaction();
        //transactionı commitlenmesi lazım.
        //transaction ile commit arasındaki olan seyler data base gönderecek.

      //session.save(student1);//database gitti
       //session.save(student2);
       // session.save(student3);

        tx.commit();

        session.close();//kapattık
        sf.close();

    }
}
