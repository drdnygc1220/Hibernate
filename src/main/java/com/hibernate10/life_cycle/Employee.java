package com.hibernate10.life_cycle;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee { // employee

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;

    // !!! Entity LifeCycle Metodlari

    /*
    bir Çalışan sınıfı kaydedilmeden once, onPrePersist() metodu otomatik olarak
    çağrılır ve " onPrePersist methodu calisti" çıktısı verilir. Nesne kaydedilmeden
    önce yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
 */ // @PrePersist Aciklama
    @PrePersist
    public void onPrePersist(){
        System.out.println("************ onPrePersist methodu calisti");
    }

    /*
    Bir varlık veritabanına kaydedildikten sonra, onPostPersist() metodu çağrılır
    ve "onPostPersist methodu calisti" çıktısı verilir. Bu, Nesne kaydedildikten
    sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
 */  // @PostPersist Aciklama
    @PostPersist
    public void onPostPersist(){
        System.out.println("************ onPostPersist methodu calisti");
    }

    /*
    Bir varlık veritabanından yüklendiğinde, onPostLoad() metodu çağrılır ve
    "onPostLoad methodu calisti" çıktısı verilir. Bu, bir nesne yüklendikten
    sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
 */ // @PostLoad Aciklama
    @PostLoad
    public void onPostLoad(){
        System.out.println("************ onPostLoad methodu calisti");
    }

        /*
        @PreRemove anotasyonu, bir nesne silinmeden önce çalıştırılacak bir yöntemi
        belirtmek için kullanılır. Bu yöntem, bir nesne silinmeden önce yapılması
        gereken işlemleri gerçekleştirmek için kullanılabilir. Örneğin, bir nesnenin
        silinmeden önce bağımlı varlıkları ile olan ilişkileri çözmek veya bir kaydı
        arşivlemek gibi işlemler yapılabilir.
     */ // @PreRemove aciklama

    @PreRemove
    public void onPreRemove(){

        System.out.println("************ onPreRemove methodu calisti");

    }

    /*
 @PostRemove yöntemi ise, bir Çalışan nesnesi silindikten sonra çağrılır ve
 "Employee record removed from the database" çıktısı verilir. Bu örnekte,
 loglama veya istatistik toplama gibi işlemler yapmak gerekiyorsa, @PostRemove
 yöntemi içine kodlar eklenebilir.
*/ // @PostRemove aciklama
    @PostRemove
    public void onPostRemove(){
        System.out.println("************ onPostRemove methodu calisti");
    }

    // !!! GETTER -SETTER

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // !!! toString()

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

