package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "MENU UTAMA\n" +
                            "1. Sistem Persamaaan Linier\n" +
                            "2. Determinan\n" +
                            "3. Matriks balikan\n" +
                            "4. Interpolasi Polinom\n" +
                            "5. Regresi linier berganda\n" +
                            "0. EXIT\n");

            System.out.print("Pilih (1/2/3/4/5/0) :");
            int menu1 = scanner.nextInt();
            if (menu1 == 0) {
                break;
            } else if (menu1 == 1) {
                Spl.main(args);
            } else if (menu1 == 2) {
                Determinan.main(args);
            } else if (menu1 == 3) {
                System.out.println("blm");
            } else if (menu1 == 4) {
                System.out.println("blm");
            } else if (menu1 == 5) {
                System.out.println("blm");
            } else {
                System.out.println("Masukkan salah, silahkan coba lagi!");
            }
        }
    }
}
