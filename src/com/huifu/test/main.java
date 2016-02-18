package com.huifu.test;

public class main {
	public static void main(String[] args) {
		//StaticClassTest s=	new StaticClassTest();
        try {
			int a = 3/0;
			System.out.println("a");
		} catch (Exception e) {
			System.out.println("b1");
			//int b= 3/0;
			System.out.println("b");
			// TODO: handle exception
		}finally {
			System.out.println("c1");
		}
       System.out.println("d");
	}
}
