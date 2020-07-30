package com.google.demoForIdea.common;

import com.google.demoForIdea.model.Cart;

public class fansheDemo {
	public static void main(String[] args) {

		Cart cart = new Cart();
		Class aClass = cart.getClass();
		System.out.println(aClass ==Cart.class );

		System.out.println(	Cart.class.getName());
		System.out.println(	Cart.class.getDeclaredFields());
		System.out.println(Cart.class.getTypeName());
		try {
			Class aClass1 = Class.forName("com.google.demoForIdea.model.Cart");
			System.out.println(aClass1 == aClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
