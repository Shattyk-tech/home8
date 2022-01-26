package peaksoft;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.entity.Employee;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Employee employee =  new  Employee("Akyl","Arzygulov",19);
        Employee employee1 =  new  Employee("Aza","Akylov",18);
        Employee employee2 =  new  Employee("Aza","Azamatov",20);
        Employee employee3 =  new  Employee("Aidar","Akilov",21);
        Employee employee4 =  new  Employee("Aza","Mambetov",23);
        Employee employee5 =  new  Employee("Ulan","Nazimov",25);
       // create(employee);
       // for (Employee e:getAza()) {
          //  System.out.println(e);

        delete();
       // update ("Aza",18);

    }

    public static void create(Employee employee) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully :" + employee);
    }
    public static List<Employee> getAza(){
        SessionFactory sessionFactory = HibernateUtil.getSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List employees = session.createQuery("from  Employee  where age > 20").getResultList();
        session.getTransaction().commit();
        session.close();
        return  employees;

    }
    public static void update(String name,int age){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Employee set age = : age where name =: name").setParameter("age",age).setParameter("name",name).executeUpdate();
        session.getTransaction().commit();
        System.out.println("Update");
        session.close();
    }
    public  static void delete(){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from  Employee where name = 'Aza'").executeUpdate();
        session.getTransaction().commit();
        System.out.println("delete");
        session.close();


}

}
