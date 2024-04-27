package com.ProductDemo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		ProductService service = new ProductService();

//		service.addProduct(new Product(1,"Asus", "Android", "Noida", 5));
//		service.addProduct(new Product(2,"A", "IOS", "Noida", 6));
//		service.addProduct(new Product(3,"B", "Android", "Noida", 7));
		
		List<Product> prods =service.getAllProducts();
		for(Product b : prods) {
			System.out.println(b);
		}
		
//		System.out.println("Now Printing all elements after inserting them in list..");
//		service.getAllProducts();
//		
//		System.out.println("****************************************************************");
//		
//		service.getProduct("A");
//		
//		System.out.println("****************************************************************");
//		
//		List<Product> prods = service.getProductWithText("IOS");
//		for(Object b : prods) {
//			System.out.println(b);
//		}
	}
}
