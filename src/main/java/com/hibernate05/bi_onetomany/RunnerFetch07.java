package com.hibernate05.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student07 student = session.get(Student07.class, 1001);
//        student.getBookList().forEach(System.out::println);

        // TASK : SQL ile   DB de kitaplari olan ogrencilerin isimlerini ve sahip olduklari kitaplarin isimlerini ekrana basalim
//        String sqlQuery1 ="SELECT s.student_name, b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//        for (Object[] objects: resultList1) {
//            System.out.println(Arrays.toString(objects));
//        }

        // Yukardaki Taski HQL ile yazdigimizda :
        // String hqlQuery = "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id = b.student.id";

        // Not : Delete islemi ( HQL )
//        String hqlQuery2 = "DELETE FROM Book07";
//        int numOfRec = session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Etkilenen veri sayisi : " + numOfRec);

        String hqlQuery3 = "DELETE FROM Student07";
        int numOfRec2 = session.createQuery(hqlQuery3).executeUpdate();
        System.out.println("Etkilenen veri sayisi : " + numOfRec2);

        // !!! Task : Kitabi olan bir ogrenciyi silmek istiyorum
        // 1001 id li student nesnesini silelim
//        Student07 student2 = session.get(Student07.class,1001);
//        session.delete(student2);
        // child silinmeden parent silemiyorum , bunun cozumu 2 yol
        // 1.yol: once child sil sonra parent yol
        // 2.YOL : Student entity sinifina OrphanRemovel veya Cascade kullanacagiz

        tx.commit();
        session.close();
        sf.close();
    }
}
