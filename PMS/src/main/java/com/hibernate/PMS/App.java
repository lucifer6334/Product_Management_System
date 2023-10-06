package com.hibernate.PMS;

import java.util.Scanner;

import com.hibernate.PMS.dao.Online_shopping_dao;
import com.hibernate.PMS.model.Online_shopping;

/**
 * Hello world!
 *
 */
public class App {

	static int price, qun, n ;
	static String name, cate, brand;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {		
		
		System.out.println("1) row insert\n2) update by id\n3) delete by id\n4) get by id");
		
		System.out.println("Enter numbers you want to perform:- ");
		n=sc.nextInt();
		
		if (n==1) {
			row_insert();
		} 
		else if (n==2) {
			updatebyid();
		}
		else if (n==3) {
			deletebyid();
		}
		
		else if (n==4) {
			getbyid();
		}
	
		else {
			System.out.println("Invalid Input");
			}
		}
		
		
	

	public static void row_insert() {
		try {

			Online_shopping_dao online_shopping_dao = new Online_shopping_dao();

			System.out.println("Enter your Name");
			name = sc.next();

			System.out.println("Enter your Brands");
			brand = sc.next();

			System.out.println("Enter your Categories");
			cate = sc.next();

			System.out.println("Enter Price");
			price = sc.nextInt();

			System.out.println("Enter Quantity");
			qun = sc.nextInt();

			Online_shopping online_shopping = new Online_shopping(name, cate, brand, price, qun);
			online_shopping_dao.saveOnline(online_shopping);
			
			System.out.println("\n Data inserted successfully.....");
		} catch (Exception e) {
			System.out.println("\n Please check your Entries");
		}
		
		
	}

	public static void deletebyid() {
		try {
			Online_shopping_dao online_shopping_dao = new Online_shopping_dao();

			System.out.println("Enter id you want to delete");
			int n = sc.nextInt();
			online_shopping_dao.delete_online(n);

		} catch (Exception e) {
			System.out.println("Invalid id/or not exist");
		}
	}

	public static void updatebyid() {
		try {
			Online_shopping_dao online_shopping_dao = new Online_shopping_dao();

			online_shopping_dao.updateOnline();

		} catch (Exception e) {
			System.out.println("Invalid id/or not exist");
		}
	}

	public static void getbyid() {
		try {
			Online_shopping_dao online_shopping_dao = new Online_shopping_dao();

			System.out.println("Enter id you want :- ");
			int n = sc.nextInt();
			online_shopping_dao.getbyiddao(n);

		} catch (Exception e) {
			System.out.println("Invalid id/or not exist");
		}

	}
}
