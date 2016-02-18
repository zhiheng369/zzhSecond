package com.huifu.test;

public class TestMain {

	public static void main(String[] args) {
		System.out.println(aa()[0]);
	}
	
	public static Object[] aa(){
		Object[] obj = {"a"};
		try {
			return bb(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			obj[0] = "c";
		}
		return obj;
	}
	
	public static Object[] bb(Object[] obj){
		obj[0] = "b";
		return obj;
	}
}
