package com.example.spring01.sample;

public class ProductVO {
	private String productName;
	private double productPrice;
	

	// Constructor
	public ProductVO(String productName, double productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	// Getter/Setter
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
		
	// toString()
	@Override
	public String toString() {
		return "ProductVO [productName=" + productName + ", productPrice=" + productPrice + "]";
	}
}
