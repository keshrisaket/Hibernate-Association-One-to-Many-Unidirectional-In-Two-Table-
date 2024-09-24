package main;

import beans.Employee;
import beans.PhoneNumber;
import hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session);

        try {

            // Employee 1 Data
            Employee employee=new Employee();
            employee.setName("Keshri");
            employee.setAddr("Patna");
            List<PhoneNumber> phoneNumbers=new ArrayList<PhoneNumber>();
            phoneNumbers.add(new PhoneNumber("8252504073"));
            phoneNumbers.add(new PhoneNumber("9153141811"));
            employee.setPhoneNumber(phoneNumbers);


            // Employee 2 Data
            Employee employee2=new Employee();
            employee2.setName("Keshri_kumar");
            employee2.setAddr("Patna_New");
            List<PhoneNumber> phoneNumbers2=new ArrayList<PhoneNumber>();
            phoneNumbers2.add(new PhoneNumber("7488028936"));
            phoneNumbers2.add(new PhoneNumber("9835429698"));
            employee2.setPhoneNumber(phoneNumbers2);

           /* session.persist(employee);
            session.persist(employee2);*/

            // Fetching data from Employee
            Employee em=(Employee) session.get(Employee.class,Integer.parseInt("2"));
            System.out.println(em.getPhoneNumber());


            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }


    }
}
