package com.robin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        long n = obj.nextInt();
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else n = n * 3 + 1;
            System.out.println(n);
        }
    }
}
