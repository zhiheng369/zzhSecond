package com.huifu.test;

public class Example {

    String str = new String("good");

    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {

        Example ex = new Example();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.println(ex.ch);
        System.out.println(getValue(2));

    }

    public void change(String str, char ch[]) {

        str = "test ok";

        ch[0] = 'g';

    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
        case 1:
            result = result + i;
            System.out.println(result);
        case 2:
            result = result + i * 2;
            System.out.println(result);
        case 3:
            result = result + i * 3;
            System.out.println(result);
        }
        return result;
    }
}
