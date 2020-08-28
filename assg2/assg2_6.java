package com.robin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else {
                if(n*3+1<Integer.MAX_VALUE)
                    n = n * 3 + 1;
                else {
                    System.out.println(n+"*3+1");
                    n=(int)(n*1.5+0.5);
                }
            }
            System.out.println(n);
        }
    }
}