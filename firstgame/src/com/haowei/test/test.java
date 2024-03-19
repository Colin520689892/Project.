package com.haowei.test;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for(int i=0;i<tempArr.length;i++){
            int index=r.nextInt(tempArr.length);
            int t=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=t;
        }
        for(int i=0;i<tempArr.length;i++){
            System.out.print(tempArr[i]+" ");
        }
        System.out.println();

        int[][] data=new int[4][4];
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                if(4*i-4+j!=16)data[i-1][j-1]=4*i-4+j;
                else data[i-1][j-1]=0;
                System.out.print(data[i-1][j-1]+" ");
            }
            System.out.println();
        }
    }
}
