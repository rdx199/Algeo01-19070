package com.kuliah;

import java.util.Scanner;

public class Spl {

    public static void main(String[] args) {
        int jumlahSPL = insertJumlahSPL();
        int jumlahVar = insertJumlahVar();

        double[][] matriks = new double[jumlahSPL][jumlahVar + 1];

        bacaValue(matriks, jumlahSPL, jumlahVar);
        System.out.println("Matriks: \n");
        printMatriks(matriks, jumlahSPL, jumlahVar);
        System.out.println("");
        System.out.println("Matriks gauss jordan: \n");
        gaussjordan(matriks, jumlahSPL, jumlahVar);
        printMatriks(matriks, jumlahSPL, jumlahVar);
    }

    public static int insertJumlahSPL() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris (m): ");
        return scanner.nextInt();
    }

    public static int insertJumlahVar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah kolom (n): ");
        return scanner.nextInt();
    }

    public static double[][] bacaValue (double[][] matriks, int jumlahSPL, int jumlahVar) {
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<jumlahSPL; i++) {
            for (int j=0; j<jumlahVar; j++) {
                System.out.print("Masukkan matriks"+ "[" + (i+1) + "]"  + "[" + (j+1) + "] : ");
                matriks[i][j]=scanner.nextDouble();
            }

            System.out.print("Masukkan solusi SPL-" + (i+1) + " : ");
            matriks[i][jumlahVar]=scanner.nextDouble();
        }

        return matriks;
    }

    public static void printMatriks(double[][] matriks, int jumlahSPL, int jumlahVar) {
        for (int i=0; i<jumlahSPL; i++) {
            for (int j=0; j<jumlahVar; j++) {
                System.out.print(matriks[i][j]+" ");
            }

            System.out.print(matriks[i][jumlahVar]);
            System.out.println("");
        }
    }

    public static double[][] gauss (double[][] matriks, int jumlahSPL, int jumlahVar){
        int i, j, k, n;
        for (i = 0; i < jumlahSPL; i++){
            double temp = matriks[i][i];
            for (j = 0; j < jumlahVar+1; j++){
                matriks[i][j] = matriks[i][j]/temp;
            }
            for (k = 0; k < jumlahSPL; k++){
                temp = matriks[k][i];
                if (i != k){
                    for(n = 0; n < jumlahVar+1; n++){
                        matriks[k][n] = matriks[k][n] - (temp * (matriks[i][n]));
                    }
                }
            }
        }
        return matriks;
    }

    public static void gaussjordan (double[][] matriks, int jumlahSPL, int jumlahVar){
        int i, j, k, n;
        for (i = 0; i < jumlahSPL; i++){
            double temp = matriks[i][i];
            for (j = 0; j < jumlahVar+1; j++){
                matriks[i][j] = matriks[i][j]/temp;
            }
            for (k = 0; k < jumlahSPL; k++){
                temp = matriks[k][i];
                if (i != k){
                    for(n = 0; n < jumlahVar+1; n++){
                        matriks[k][n] = matriks[k][n] - (temp * (matriks[i][n]));
                    }
                }
            }
        }

    }
}
