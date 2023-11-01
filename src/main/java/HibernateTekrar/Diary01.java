package HibernateTekrar;

import javax.persistence.*;

@Entity
public class Diary01 {//günlük
    @Id
    private int id;
    @Column(name = "diary_name")
    private String name;

    @OneToOne
    @JoinColumn(name="std_id")
   private Student01 student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student01 getStudent() {
        return student;
    }

    public void setStudent(Student01 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
