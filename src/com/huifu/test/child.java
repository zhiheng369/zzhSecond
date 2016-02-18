package com.huifu.test;

public class child extends StaticClassTest {
		  static{
			  System.out.println("我是子类类静态快");
			  
		  }
		  {
			  System.out.println("我是子类非静态快");
		  }
		  
		  public child(){
			  System.out.println("我是子类构造方法");
			  
		  }
		}
