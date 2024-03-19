package com.baidu.hello;

import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        String s1,s3;
        String s2;
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        s1=sc.next();
        char b=s1.charAt(s1.length()-1);
        int i=0;
        while(i<s1.length()&&s1.charAt(i)>='0'&&s1.charAt(i)<='9'){
            sb.append(s1.charAt(i));
            i++;
        }

        char k=' ';
        if(i<s1.length())k=s1.charAt(i);
        i++;
        while(i<s1.length()&&s1.charAt(i)>='0'&&s1.charAt(i)<='9'){
            sb1.append(s1.charAt(i));
            i++;
        }

        sb.reverse();
        i=0;
        while(i<sb.length()&&sb.charAt(i)=='0')sb.delete(i,i+1);

        i=0;
        s3=sb1.toString();
        boolean d=s3.isEmpty();
        while(i<sb1.length()&&sb1.charAt(i)=='0')sb1.delete(i,i+1);
        sb1.reverse();
        i=0;
        while(i<sb1.length()&&sb1.charAt(i)=='0')sb1.delete(i,i+1);
        s2=sb.toString();
        if(s2.isEmpty()){
            System.out.print(0);
        }else{
            System.out.print(s2);
        }
        s3=sb1.toString();
        System.out.print(k);
        if((b>='0'&&b<='9')&&s3.isEmpty()&&!d){
            System.out.print(0);
        }else{
            System.out.print(s3);
        }
    }
}
