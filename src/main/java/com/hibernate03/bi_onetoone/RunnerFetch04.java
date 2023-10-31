package com.hibernate03.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);//2 tane entity clas var

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        Student04 student=session.get(Student04.class,1001);
        Diary04 diary=session.get(Diary04.class,101);
        System.out.println(student);//student+diary
        System.out.println("---------");
        System.out.println(student.getDiary());//sadece diary
        System.out.println("-------------");
        System.out.println(diary);//diary+student
        System.out.println("-----------");
        System.out.println(diary.getStudent());//sadece student

        //INNER JOIN=Kesişim
        //TASK:sadece günlüğü olan öğrenciler..
        String hqlQuery1="SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
        //Hql de field isimleri(student) 1.java değişkenlerini kullanılırız yada;
        //Hql de 2.Java classlarını kullanırım.

        //üstteki HQL in SQL halini yazalım..
        //SQL de 1-Tablo isimlerini,2-Tablo hedırlarını kullanacagım...
        //SELECT s.std_name,d.name FROM student04 s INNER JOIN  diary04 d ON s.id=d.std_id;

        List<Object[]> resultList =session.createQuery(hqlQuery1).getResultList();
        for(Object[] objects: resultList){
            System.out.println(Arrays.toString(objects));
        }

        //okunabilirlik olması için lamba kullanmak daha mantıklı..
        //foreach lamba ile yapmak istersem
        resultList.forEach(oa->{
                    System.out.println(Arrays.toString(oa));

                });

        //HQL LEFT JOIN
        //TASK:butun ogrenciler ve varsa bu ögrencilerin gunluk bilgilerini getir.
        String hqlQuery2="SELECT s.name,d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]> resultList2=session.createQuery(hqlQuery2).getResultList();
        resultList2.forEach(oa->{
                    System.out.println(Arrays.toString(oa));
                });

        //HQL RIGHT JOIN
        //TASK:butun gunlukler ve varsa gunlugu olan öğrenciler gelsin.
        String hqlQuery3="SELECT s.name,d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]>resultList3=session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        //FULL JOIN
        //TASK:
        String hqlQuery4="SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]>resultList4=session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });






        tx.commit();
        sf.close();
        session.close();
    }
}
