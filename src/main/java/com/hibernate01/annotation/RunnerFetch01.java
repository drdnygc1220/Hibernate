package com.hibernate01.annotation;

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
//         Student01 student1 = session.get(Student01.class,1001);
//         Student01 student2 = session.get(Student01.class,1002);
//         System.out.println(student1);
//         System.out.println(student2);
//        System.out.println(student2.getName());

        // Not: SQL =============================================
//        String sqlQuery1 = "SELECT * FROM t_student01";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//        for(Object[] objects: resultList1){
//            System.out.println(Arrays.toString(objects));
//        }

        // Not: HQL ============================================
        String hqlQuery1 = "FROM Student01";
        List<Student01> resultList3 =  session.createQuery(hqlQuery1, Student01.class).getResultList();
        for(Student01 student01: resultList3){
            System.out.println(student01);
        }

        tx.commit();

        session.close();
        sf.close();
    }
}

