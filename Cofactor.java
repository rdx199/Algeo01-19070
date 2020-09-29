package com.belajar;

import static java.lang.StrictMath.pow;

public class Cofactor {
    public static double[][] excMatriks(double[][] matriks, int baris, int kolom) {
        double[][] small = new double[matriks.length-1][matriks.length-1];
        int count = -1;
        for(int i=0; i<matriks.length;i++) {
            for(int j=0; j<matriks.length;j++) {
                if(i<baris) {
                    if(j<kolom) {
                        small[i][j]=matriks[i][j];
                    } else if (j>kolom) {
                        small[i][j-1]=matriks[i][j];
                    }
                } else if (i>baris) {
                    if(j<kolom) {
                        small[i-1][j]=matriks[i][j];
                    } else if(j>kolom){
                        small[i-1][j-1]=matriks[i][j];
                    }
                }

            }
        }
        return small;
    }
    public static double[][] getCofactor(double[][] matriks) {
        double[][] cofactor = new double[matriks.length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                cofactor[i][j] = Determinan.ekspansiKofaktor(excMatriks(matriks,i,j)) * pow(-1,i+j);
            }
        } return cofactor;
    }
    public static double[][] getTranspose(double[][] matriks) {
        double[][] transpose = new double[matriks.length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                transpose[i][j]=matriks[j][i];
            }
        } return transpose;
    }
    public static double[][] kaliKons(double[][] matriks, double x) {
        double[][] hasil = new double[matriks.length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                hasil[i][j] *= x;
            }
        } return hasil;
    }
    public static void makeInverse(double[][] matriks) {
        double[][] kofaktor;
        double[][] adjoin;
        double[][] inverse;
        double[][] mSquare = new double[matriks.length][matriks[0].length - 1];

        // copy m2 ke m3, tapi tidak termasuk hasil spl
        for (int i = 0; i < mSquare.length; i++) {
            for (int j = 0; j < mSquare[0].length; j++) {
                mSquare[i][j] = matriks[i][j];
            }
        }
        double determinan = Determinan.ekspansiKofaktor(mSquare);
        if(matriks.length != matriks[0].length-1) {
            System.out.println("matriks harus merupakan matriks persegi");
        }
        else {
            kofaktor=getCofactor(matriks);
            adjoin=getTranspose(kofaktor);
            inverse=kaliKons(adjoin,(1/determinan));
            Main.printMatriks(inverse);
        }
    }
}
