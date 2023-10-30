package com.hibernate01.annotation;

import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();

        Transaction tx =  session.beginTransaction();

        // !!! DB den bilgi cekmek icin 3 yol :
        // 1) get metodu
        // 2) SQL
        // 3) HQL ( Hibernate Query Language )
        // Not: Get =============================================
/*
         Student01 student1 = session.get(Student01.class,1001);
         Student01 student2 = session.get(Student01.class,1002);
         System.out.println(student1);
        System.out.println(student2);
        System.out.println(student2.getName());

 */
        // Not: SQL =============================================
/*
        String sqlQuery1 = "SELECT * FROM t_student01";
       List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
       for(Object[] objects: resultList1){
            System.out.println(Arrays.toString(objects));
       }

 */

        // Not: HQL ============================================

        String hqlQuery1 = "FROM Student01";
        List<Student01> resultList3 =  session.createQuery(hqlQuery1, Student01.class).getResultList();
        for(Student01 student01: resultList3){
           System.out.println(student01);
        }

/*

        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='FEYYAZ YAĞCI'";
        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
      //System.out.println(Arrays.toString(uniqueResult1));
        //TEK TEK DE GÖRMEK İÇİN İNDEXLERDEN GİDEBİLİRİM..
      System.out.println(uniqueResult1[0] + " : " + uniqueResult1[1] + " : " + uniqueResult1[2]);

 */




      // ayni task i HQL ile yazalim
    //CLASS İSİMLERİYLE YAZMAM GEREK
        /*
        String hqlQuery2 = "FROM Student01  WHERE name='FEYYAZ YAĞCI'";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2,Student01.class).uniqueResult();
        System.out.println(uniqueResult2);
       tx.commit();


         */

        // HQL + Alias=kısaltmak için
       String hqlQuery3 = "FROM Student01 std  WHERE std.name='FEYYAZ YAĞCI'";
       Student01 uniqueResult3 = session.createQuery(hqlQuery3,Student01.class).uniqueResult();
        System.out.println(uniqueResult3);



     /*   // grade degeri 90 olan ogrencileri getirelim - HQL
        String hqlQuery4 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade=90";
        List<Object[]> uniqueResult4 = session.createQuery(hqlQuery4).getResultList();
        for(Object[] objects : uniqueResult4) {
            System.out.println(Arrays.toString(objects));
   }

      */

      /*  // id ye gore azalan sirali sekilde ogrencileri listeleyiniz

        String hqlQuery5 = "FROM Student01 s ORDER BY s.id desc";
        List<Student01> resultList1 = session.createQuery(hqlQuery5, Student01.class).getResultList();
        for(Student01 student01: resultList1) {
            System.out.println(student01);
        }

       */



        session.close();
        sf.close();
    }
}
