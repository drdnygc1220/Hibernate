package HibernateTekrar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class).
                addAnnotatedClass(Diary01.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student01 student=session.get(Student01.class,100);
        Diary01 diary=session.get(Diary01.class,200);
        System.out.println(student);
        System.out.println(diary);

        //TASK:sadece günlüğü olan öğrenciler..
        //HQL
        String hqlQuery1="SELECT s.name,d.name FROM Student01 s INNER JOIN Diary01 d WHERE s.id=d.student_id";
        List<Object[]>resultList=session.createQuery(hqlQuery1).getResultList();

         // for(Object[] objects:resultList){
         //  System.out.println(Arrays.toString(objects));
         // }

        tx.commit();
        sf.close();
        session.close();
    }
}
