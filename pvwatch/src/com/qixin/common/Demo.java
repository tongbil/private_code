package com.qixin.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Demo {
	 public static void main(String[] args) {
		 
		  Scanner sc = new Scanner(System.in);
	      System.out.println("请输入你的电话:");
	      String tel = sc.nextLine();
	      char[] arr = tel.toCharArray();
	      HashSet<Character> set = new HashSet<>();
	      for (char c : arr) {
	         set.add(c);
	      }
	      ArrayList<Integer> index = new ArrayList<>();
	      Object[] tels = set.toArray();
	      List<Object> list = Arrays.asList(tels);
	      Collections.shuffle(list);
	      for (char anArr : arr) {
	         for (int j = 0; j < list.size(); j++) {
	            if (anArr == (char) list.get(j)) {
	               index.add(j);
	            }
	         }
	      }
	      System.out.println("自动生成的代码:");
	      System.out.print("int[] arr = new int[] {");
	      for (int i = 0; i < list.size(); i++) {
	         if (i != list.size() - 1) {
	            System.out.print(list.get(i) + ",");
	         } else {
	            System.out.print(list.get(i) + "};");
	         }
	      }
	      System.out.println();
	      System.out.print("int[] index = new int[] {");
	      for (int i = 0; i < index.size(); i++) {
	         if (i != index.size() - 1) {
	            System.out.print(index.get(i) + ",");
	         } else {
	            System.out.print(index.get(i) + "};");
	         }
	      }
	      System.out.println();
	      System.out.println("String tel = \"\";");
	      System.out.println("for (int i : index) {");
	      System.out.println("tel += arr[i];");
	      System.out.println("}");
	      System.out.println("System.out.println(\"联系方式:\"+tel);");
	      System.out.println();
	}
}
