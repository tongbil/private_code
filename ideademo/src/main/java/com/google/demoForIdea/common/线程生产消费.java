package com.google.demoForIdea.common;

import java.util.LinkedList;

public class 线程生产消费 {
		static 	int carName =1;

	public static void main(String[] args) {
		Car4s car4s = new Car4s();
		new Thread(new ProductTask(car4s)).start();
					new Thread(new ConsumerTask(car4s)).start();
		new Thread(new ConsumerTask(car4s)).start();
		new Thread(new ConsumerTask(car4s)).start();
	}

	static class ProductTask implements  Runnable{
	  Car4s car4s;

		public ProductTask (Car4s car4s) {
			this.car4s = car4s;
		}

		@Override
		public void run() {

			while (true){
				synchronized (car4s){
					if(car4s.carsList.size()<1){

						Cars cars = new Cars();
						cars.setName(carName+"");

						System.out.println("生产了"+cars.getName());
						carName++;
						car4s.carsList.push(cars);

						car4s.notifyAll();

					}else {
						try {
							car4s.wait();
						} catch (InterruptedException e) {

						}
					}
				}

			}



		}
	}
	static class ConsumerTask implements  Runnable{
		  Car4s car4s;

		public ConsumerTask (Car4s car4s) {
			this.car4s = car4s;
		}

		@Override
		public void run() {
			while (true){
				synchronized (car4s){
					if(car4s.carsList.size()>0){
						Cars cars = (Cars) car4s.carsList.poll();
						System.out.println("消费了"+cars.getName());
						car4s.notifyAll();
					}else {
						try {
							car4s.wait();
						} catch (InterruptedException e) {

						}
					}
				}

			}

		}
	}

	static class Car4s{
			LinkedList carsList=	new LinkedList();
	}

	static class Cars{
		private String  name;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
