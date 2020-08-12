package com.google.demoForIdea.common;

public class finalDemo {
	public static void main(String[] args) throws InterruptedException {
		finalDemo.state state =new finalDemo.state();

		while(true){
			ThreadA A =new ThreadA(state);
			ThreadB  B =new ThreadB(state);
			A.start();
			B.start();
			A.join();
		}
	}
 static class ThreadA extends Thread{
		private  final finalDemo.state state;

	 ThreadA(finalDemo.state state) {
		 this.state = state;
	 }
	 public void run(){
	 	state.a=1;
		 state.b=1;
		 state.c=1;
		 state.d=1;
	 }
 }
	static class ThreadB extends Thread{
		private  final finalDemo.state state;

		ThreadB(finalDemo.state state) {
			this.state = state;
		}
		public void run(){
			System.out.println(state.a+"-"+state.b+"-"+state.c+"-"+state.d);
			if(state.a==0){
				System.out.println("a==0");
			}
			if(state.b==0){
				System.out.println("b==0");
			}
			if(state.c==0){
				System.out.println("c==0");
			}
			if(state.d==0){
				System.out.println("d==0");
			}
			if(state.a==1&&(state.b==0||state.c==0||state.d==0)){
				System.out.println("b==1");
			}
	 	if(state.b==1&&(state.a==0||state.c==0||state.d==0)){
		    System.out.println("b==1");
	    }
		 if(state.c==1&&(state.a==0||state.b==0||state.d==0)){
			 System.out.println("c==1");
		 }
		 if(state.d==1&&(state.a==0||state.b==0||state.c==0)){
			 System.out.println("d==1");
		 }
		}
	}

 static class state{
	  int a =0;
	  int b =0;
	  int c =0;
	  int d =0;
 };
}
