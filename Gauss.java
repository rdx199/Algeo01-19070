package com.belajar;

public class Gauss {
    public static void main(String[] args) {
        
    }
    public static void tukarBaris(double[][] matriks, int j1, int j2) {
        double temp;
        for (int i = 0; i < matriks[0].length; i++) {
            temp = matriks[j2][i];
            matriks[j2][i] = matriks[j1][i];
            matriks[j1][i] = temp;
        }

    }
    public static boolean isColNull(double[][] matriks, int j) {
        int i;
        boolean allZero = true;
        for (i = 0; i < matriks.length; i++) {
            if (matriks[i][j] != 0) {
                allZero = false;
            }
        }
        return allZero;
    }

    public static void eselonRow(double[][] matriks) {
        int i, j, steps, rowPivot;
        double divider, multiplier;
        int totalCol = matriks[0].length;
        int totalRow = matriks.length;
        int currentcol = 0;
        boolean changecol;
        double epsilon = 0.00001;

        steps = 1;

        while (steps <= totalRow && currentcol<totalCol)
        {
            rowPivot = steps-1;
            changecol = false;
            if (matriks[rowPivot][currentcol]<epsilon && matriks[rowPivot][currentcol]> -epsilon) {
                i=rowPivot;
                while (i<totalRow && matriks[i][currentcol]<epsilon && matriks[i][currentcol]> - epsilon) { // nyari baris yang elemen nya tidak nol
                    i++;
                }
                if (i==totalRow) {
                    currentcol++;
                    changecol=true;

                } else {
                    tukarBaris(matriks,rowPivot,i); // nuker baris kalo ga isallzero
                }
            }
            if (!changecol) {
                divider = matriks[rowPivot][currentcol];
                for (j = currentcol; j < totalCol; j++) {
                    matriks[rowPivot][j] /= divider;
                }
                for (i = rowPivot + 1; i < totalRow; i++) {
                    multiplier = matriks[i][currentcol];
                    for (j = currentcol; j < totalCol; j++) {
                        matriks[i][j] -= (multiplier * matriks[rowPivot][j]);
                    }
                }
                steps++;
            }
        }

    }
    public static void eselonred(double[][] matriks) {
        
    }
}
