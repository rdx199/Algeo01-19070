package src;

import java.util.Scanner;

public class Gauss {

    public static void tukarBaris(double[][] matriks, int j1, int j2) {
        double temp;
        for (int i = 0; i < matriks[0].length; i++) {
            temp = matriks[j2][i];
            matriks[j2][i] = matriks[j1][i];
            matriks[j1][i] = temp;
        }
    }

    public static void eselonRow(double[][] matriks) { // Gauss

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

    public static void eselonRed(double[][] matriks) { // Gauss Jordan
        eselonRow(matriks);
        int currentbaris = 1;
        int jmlKol = matriks[0].length, jmlBrs = matriks.length;
        while (currentbaris < jmlBrs) {
            boolean leadingP = false;
            int pivotKol = 0;
            while (pivotKol < jmlKol - 1 && !(leadingP)) {
                if (matriks[currentbaris][pivotKol] == 1) {
                    leadingP = true;
                } else {
                    pivotKol++;
                }
            }
            if (leadingP) {
                for (int i = 0; i < currentbaris; i++) {
                    double multiplier = matriks[i][pivotKol];
                    for (int j = 0; j < jmlKol; j++) {
                        matriks[i][j] -= (multiplier * matriks[currentbaris][j]);
                    }
                }
            }
            currentbaris++;
        }

    }
}
