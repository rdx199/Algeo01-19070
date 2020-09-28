package com.company;

import java.util.Scanner;

public class Spl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistem Persamaan Linear\n\nBUAT MATRIKS :");
        // input matriks
        int jumlahSPL = insertJumlahSPL();
        int jumlahVar = insertJumlahVar();
        double[][] matriks = new double[jumlahSPL][jumlahVar + 1];
        bacaValue(matriks, jumlahSPL, jumlahVar);

        System.out.println("Matriks: \n");
        printMatriks(matriks);
    }

    public static int insertJumlahSPL() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah persamaan: ");
        return scanner.nextInt();
    }

    public static int insertJumlahVar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah variabel: ");
        return scanner.nextInt();
    }

    public static void bacaValue (double[][] M, int jumlahSPL, int jumlahVar) {
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<jumlahSPL; i++) {
            for (int j=0; j<jumlahVar; j++) {
                System.out.print("Masukkan matriks"+ "[" + (i+1) + "]"  + "[" + (j+1) + "] : ");
                M[i][j]=scanner.nextDouble();
            }

            System.out.print("Masukkan solusi SPL-" + (i+1) + " : ");
            M[i][jumlahVar]=scanner.nextDouble();
        }
    }

    public static void printMatriks(double[][] M) {
        int brs = M.length;
        int kol = M[0].length;
        for (int i = 0; i < brs; i++) {
            System.out.print("[\t");
            for (int j = 0; j < kol; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println("\t]");
        }

    }
}
