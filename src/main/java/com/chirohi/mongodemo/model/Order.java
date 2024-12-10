package com.chirohi.mongodemo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String id;
	
	private String orderId;
	
	private String productName;
	
	private int quantity;
	
	private double price;
	
	private List<String> shippingAddressListList;

	public Order(String id, String orderId, String productName, int quantity, double price, List<String> shippingAddressList) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.shippingAddressListList = shippingAddressList;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", shippingAddressList=" + shippingAddressListList + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getshippingAddressList() {
		return shippingAddressListList;
	}

	public void setshippingAddressList(List<String> shippingAddressList) {
		this.shippingAddressListList = shippingAddressList;
	}
	

}
