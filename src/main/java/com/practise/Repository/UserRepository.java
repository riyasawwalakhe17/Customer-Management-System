package com.practise.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Customer;
import com.practise.Utility.HibernateUtility;

public class UserRepository {

	public void getDataById(int customerid) {
		// 1. Get Single Customer Data
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer cs = session.find(Customer.class, customerid);
		System.out.println("Customer First Name: " + cs.getfName());
		System.out.println("Customer Last Name: " + cs.getlName());
		System.out.println("Customer Gender: " + cs.getGender());
		System.out.println("Customer City Name: " + cs.getCity());

		transaction.commit();
		session.close();
	}

	public void getAllData() {
		// 2. Get All Customers Details
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Customer> cslist = session.createQuery("select c from Customer c", Customer.class).getResultList();
		System.out.println("List of Customer Details:");
		cslist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}

	public void getUpdatedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Updated Customer Details:");
		Customer cs = session.find(Customer.class, 104);
		cs.setfName("Priyanka");
		cs.setlName("Karmarkar");
		cs.setCity("Mumbai");
		cs.setGender("Female");

		transaction.commit();
		session.close();
	}

	public void getDeletedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Deleted Customer Details:");
		Customer cs = session.find(Customer.class, 104);
		session.remove(cs);

		transaction.commit();

		session.close();
	}

	public void addNewData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("New Added Customer Details:");
		Customer cs = new Customer();
		cs.setID(107);
		cs.setfName("Siddhesh");
		cs.setlName("Wanjari");
		cs.setGender("Male");
		cs.setCity("Nagpur");
		
		session.persist(cs);
		transaction.commit();
		session.close();
	}

}
