package com.delhiguru.relationship.one2many;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.delhiguru.util.HibernateUtil;
 
public class OneToManyClient {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);
 
        Employee emp1 = new Employee("Ranjeet", "Kumar", "111");
        Employee emp2 = new Employee("Anila Jha", "Jha", "222");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
 
        session.save(emp1);
        session.save(emp2);
 
        session.getTransaction().commit();
        session.close();
    }
}