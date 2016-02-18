package com.huifu.test;

public class StaticClassTest {
  static{
	  System.out.println("我是父类静态快");
	  
  }
  {
	  System.out.println("我是父类非静态快");
  }
  
  public StaticClassTest(){
	  System.out.println("我是父类构造方法");
	  
  }
  public static void test(){
	  System.out.println("我是静态方法");
  }
  public final static String m= "我是常量";
}
