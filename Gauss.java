package com.company;

import java.util.Scanner;

public class Gauss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BUAT MATRIKS :");
        int brs = scanner.nextInt();
        int kol = scanner.nextInt();
        double[][] matriks = new double[brs][kol+1];
        System.out.println("");
        Spl.bacaValue(matriks, brs, kol);
        eselonRow(matriks);
        Spl.printMatriks(matriks);
    }

    public static void tukarBaris(double[][] matriks, int j1, int j2) {
        double temp;
        for (int i = 0; i < matriks[0].length; i++) {
            temp = matriks[j2][i];
            matriks[j2][i] = matriks[j1][i];
            matriks[j1][i] = temp;
        }
    }

    public static void eselonRow(double[][] matriks) {

        int i, j, count, pivot;
        int jmlKol = matriks[0].length;
        int jmlBrs = matriks.length;
        int currentcol = 0;
        boolean changecol;
        double divider, multiplier;
        double epsilon = 0.00001;

        count = 1;

        while (count <= jmlBrs && currentcol < jmlKol) {
            pivot = count - 1;
            changecol = false;
            if (matriks[pivot][currentcol] < epsilon && matriks[pivot][currentcol] > -epsilon) {
                i = pivot;
                while (i < jmlBrs && matriks[i][currentcol] < epsilon && matriks[i][currentcol] > -epsilon) { // nyari baris yang elemen nya tidak nol
                    i++;
                }
                if (i == jmlBrs) {
                    currentcol++;
                    changecol = true;

                } else {
                    tukarBaris(matriks, pivot, i); // nuker baris kalo ga isallkolomzero
                }
            }
            if (!changecol) {
                divider = matriks[pivot][currentcol];
                for (j = currentcol; j < jmlKol; j++) {
                    matriks[pivot][j] /= divider;
                }
                for (i = pivot + 1; i < jmlBrs; i++) {
                    multiplier = matriks[i][currentcol];
                    for (j = currentcol; j < jmlKol; j++) {
                        matriks[i][j] -= (multiplier * matriks[pivot][j]);
                    }
                }
                count++;
            }
        }

    }

    public static void eselonred(double[][] matriks) {
        eselonRow(matriks);
        int currentbaris = 1;
        int jmlKol = matriks[0].length, jmlBrs = matriks.length;
        while (currentbaris < jmlBrs) {
            boolean leadingP = false;
            int pivotcol = 0;
            while (pivotcol < jmlKol - 1 && !(leadingP)) {
                if (matriks[currentbaris][pivotcol] == 1) {
                    leadingP = true;
                } else {
                    pivotcol++;
                }
            }
            if (leadingP) {
                for (int i = 0; i < currentbaris; i++) {
                    double multiplier = matriks[i][pivotcol];
                    for (int j = 0; j < jmlKol; j++) {
                        matriks[i][j] -= (multiplier * matriks[currentbaris][j]);
                    }
                }
            }
            currentbaris++;
        }

    }
}
