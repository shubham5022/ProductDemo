package com.ProductDemo;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

	List<Product> products = new ArrayList<>();
	ProductDB db = new ProductDB() ;
	public void addProduct(Product p) {

		db.save(p);

	}

	public List<Product> getAllProducts() {

		List<Product> products=db.getAll();
		return products;
	}

	public void getProduct(String name) {
		// TODO Auto-generated method stub
		for (Product p : products) {
			if (p.getName().equals(name)) {
				System.out.println(p);
			}
		}
	}

	public List<Product> getProductWithText(String text) {
		List<Product> prods = new ArrayList<>();
		for (Product p : products) {
			if (p.getName().contains(text) || p.getPlace().contains(text) || p.getType().contains(text)) {
				prods.add(p);
			}

		}

		return prods;

	}
}