package com.practise;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practise.Entity.Customer;
import com.practise.Repository.UserRepository;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args67) {

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.err.println("WELCOME TO CUSTOMER MANAGEMENT SYSTEM"); 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Please Select as per Requirement");
			System.out.println("1. Get Single Customer Data");
			System.out.println("2. Get All Customers Details");
			System.out.println("3. Get Updated Customer Details");
			System.out.println("4. Get Deleted Customer Details");
			System.out.println("5. Add New Customer Details");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			UserRepository user = new UserRepository();

			switch (choice) {
			case 1:
				System.out.println("Please Enter Customer ID: ");
				int customerid = sc.nextInt();
				user.getDataById(customerid);
				break;

			case 2:
				user.getAllData();
				break;

			case 3:
				user.getUpdatedData();
				break;

			case 4:
				user.getDeletedData();
				break;

			case 5:
				user.addNewData();
				break;

			}
		}
	}
}
