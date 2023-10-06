package com.hibernate.PMS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Online_shopping")
public class Online_shopping {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private int id;
private String name;
private String cate;
private String brand;
private int price;
private int quantity;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCate() {
	return cate;
}
public void setCate(String cate) {
	this.cate = cate;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Online_shopping() {
	super();
	// TODO Auto-generated constructor stub
}
public Online_shopping(String name, String cate, String brand, int price, int quantity) {
	super();
	this.name = name;
	this.cate = cate;
	this.brand = brand;
	this.price = price;
	this.quantity = quantity;
}
@Override
public String toString() {
	return "online_shopping [ id=" + id + ", name=" + name + ", cate=" + cate + ", brand=" + brand + ", price=" + price
			+ ", quantity=" + quantity + "]";
}

}
