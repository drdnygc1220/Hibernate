package HibernateTekrar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        Student01 student1=new Student01();
        student1.setId(100);
        student1.setName("zehra betül");
        student1.setGrade(3);

        Student01 student2=new Student01();
        student2.setId(101);
        student2.setName("fırat bey");
        student2.setGrade(5);

        Student01 student3=new Student01();
        student3.setId(102);
        student3.setName("neriman hanım");
        student3.setGrade(7);

        Diary01 diary1=new Diary01();
        diary1.setId(200);
        diary1.setName("zehra betülün günlüğü");
        diary1.setStudent(student1);
        Diary01 diary2=new Diary01();
        diary1.setId(201);
        diary1.setName("fırat ın günlüğü");
        diary1.setStudent(student2);




        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class).
                addAnnotatedClass(Diary01.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        //diary nin içinde student var önce student daha sonra diary
        session.save(student1);
        session.save(student2);
        session.save(student3);

    session.save(diary1);
    session.save(diary2);



        tx.commit();
        sf.close();
        session.close();



    }
}
