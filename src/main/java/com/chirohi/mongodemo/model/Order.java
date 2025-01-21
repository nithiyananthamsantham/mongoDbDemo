package com.chirohi.mongodemo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chirohi.mongodemo.validation.OrderTypeValidator;

@Document
public class Order {
	@Id
	private String id;
	
	private String orderId;
	
	private String productName;
	
	private int quantity;
	
	private double price;
	
	@OrderTypeValidator
	private String orderType;
	
	private List<String> shippingAddressListList;
	

	public Order(String id, String orderId, String productName, int quantity, double price, String orderType, List<String> shippingAddressList) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
		this.shippingAddressListList = shippingAddressList;
		
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", orderType=" + orderType + ", shippingAddressListList="
				+ shippingAddressListList + "]";
	}

	public Order() {
		super();
	}


	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<String> getShippingAddressListList() {
		return shippingAddressListList;
	}

	public void setShippingAddressListList(List<String> shippingAddressListList) {
		this.shippingAddressListList = shippingAddressListList;
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
