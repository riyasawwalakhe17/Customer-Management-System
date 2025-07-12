package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practise.Entity.Customer;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args67)
    {
        
    	Customer c = new Customer();
    	c.setID(105);
    	c.setfName("Harshal");
    	c.setlName("Sawwalakhe");
    	c.setCity("Amravati");
    	c.setGender("Male");
    	
    	//1
        SessionFactory factory = HibernateUtility.getSessionFactory();
        //2
        Session session = factory.openSession();
        //3
        Transaction transaction = session.beginTransaction();
        //4
        session.persist(c);
        //5
        transaction.commit();
        session.close();
    }
}
