package com.hibernate.PMS.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;
import com.hibernate.PMS.model.Online_shopping;
import com.hibernate.PMS.util.Online_s_util;

public class Online_shopping_dao {
	public void saveOnline(Online_shopping online_shopping) {
		Transaction transaction = null;
		try (Session session = Online_s_util.getsessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(online_shopping);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		}
	}

	public void delete_online(int id) {
		Transaction transaction = null;
		try (Session session = Online_s_util.getsessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Online_shopping online_shopping = session.get(Online_shopping.class, id);
			session.delete(online_shopping);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		}
	}

	public void updateOnline() {
		int n;
		Transaction transaction = null;
		Scanner sc = new Scanner(System.in);

		try (Session session = Online_s_util.getsessionFactory().openSession();) {
			transaction = session.beginTransaction();

			System.out.println("Enter product ID to update: ");
			n = sc.nextInt();

			// Retrieve the entity from the database
			Online_shopping onlineShopping = session.get(Online_shopping.class, n);

			if (onlineShopping != null) {

				System.out.println("Enter new name: ");
				onlineShopping.setName(sc.next());
				System.out.println("Enter new brand: ");
				onlineShopping.setBrand(sc.next());
				System.out.println("Enter new category: ");

				onlineShopping.setCate(sc.next());
				System.out.println("Enter new price: ");
				onlineShopping.setPrice(sc.nextInt());
				System.out.println("Enter new quantity: ");
				onlineShopping.setQuantity(sc.nextInt());

				// Save the updated entity back to the database
				session.update(onlineShopping);
				transaction.commit();
				System.out.println("Data updated successfully......");
			} else {
				System.out.println("Product not found with ID: " + n);
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void getbyiddao
	(int id) {
		Transaction transaction = null;
		try (Session session = Online_s_util.getsessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Online_shopping online_shopping = session.get(Online_shopping.class, id);
			
			System.out.println(online_shopping);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		}

	}
}
