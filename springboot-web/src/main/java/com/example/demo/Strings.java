package com.example.demo;

/**
 * Created by kawano on 2017/7/31 15:49.
 */
public class Strings {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = "abc";

        System.out.println(str == str2);

        String str3 = new String("abc");

        System.out.println(str2 == str3);

        String str4 = new String("abc");
        System.out.println(str3 == str4);

        System.out.println(str3.equals(str4));

        String str5 = str3 + str4;

        String str6 = str + str2;

        String str7 = str + str3;


        System.out.println(str6.intern());
        System.out.println(str7.intern());
        System.out.println(str5.intern());
    }
}
