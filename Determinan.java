package com.company;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Determinan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BUAT MATRIKS :");
        int brs = insertbrs();
        int kol = insertkol();
        double[][] matriks = new double[brs][kol];
        System.out.println("");
        bacaValue(matriks, brs, kol);

        // loop menu
        if (brs != kol) {
            System.out.print("Tidak ada determinan karena bukan matriks persegi\n\nPress ENTER to go back...");
            scanner.nextLine();
        } else {
            while (true) {
                System.out.println("\nMatriks " + brs + " x " + kol);
                printMatriks(matriks, brs, kol);
                System.out.println("\nMENU DETERMINAN:\n" +
                        "1. Metode Ekspansi Kofaktor\n" +
                        "2. Metode Reduksi Baris\n" +
                        "0. BACK\n");

                int pilihan = menu();
                if (pilihan == 0) {
                    break;
                } else if (pilihan == 1) {
                    System.out.println("Dengan menggunakan metode Ekspansi Kofaktor,\ndidapat nilai determinan = " + ekspansiKofaktor(matriks));
                    System.out.print("\nPress ENTER to go back...");
                    scanner.nextLine();
                } else if (pilihan == 2) {
                    System.out.println("Dengan menggunakan metode Reduksi Baris,\ndidapat nilai determinan = " + reduksiBaris(matriks));
                    System.out.print("\nPress ENTER to go back...");
                    scanner.nextLine();
                } else {
                    System.out.println("Masukkan salah, silahkan coba lagi!");
                }
            }
        }


    } // tutup main

    public static int insertbrs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris (m): ");
        return scanner.nextInt();
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pilih (1/2/0) :");
        return scanner.nextInt();
    }

    public static int insertkol() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah kolom (n): ");
        return scanner.nextInt();
    }

    public static void bacaValue(double[][] matriks, int brs, int kol) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < brs; i++) {
            for (int j = 0; j < kol; j++) {
                System.out.print("Masukkan matriks" + "[" + (i + 1) + "]" + "[" + (j + 1) + "] : ");
                matriks[i][j] = scanner.nextDouble();
            }
        }
    }

    public static double ekspansiKofaktor(double[][] M) {

        double sumdet = 0;
        int brseff = M.length;
        int koleff = M[0].length;
        int idbrs = brseff - 1;
        int idkol = koleff - 1;

        if (brseff == 1) {
            return M[0][0];}
        else if (brseff != koleff) {
                System.out.println("Tidak ada determinan karena bukan matriks persegi");
                return 0;

        } else {
            double[][] Mij = new double[brseff - 1][koleff - 1];
            int i, j, k;
            for (i = 0; i < idkol + 1; i++) {
                for (j = 1; j < idbrs + 1; j++) {
                    for (k = 0; k < idkol; k++) {
                        if (k >= i) {
                            Mij[j - 1][k] = M[j][k + 1];
                        } else {
                            Mij[j - 1][k] = M[j][k];

                        }
                    }
                }
                sumdet += pow(-1, i) * M[0][i] * ekspansiKofaktor(Mij);
            }
            return sumdet;
        }
    }

    public static double reduksiBaris(double[][] M) {
        int i, j, k;
        double rasio, det;
        double[][] segitigaatas = new double[M.length][M[0].length];
        int n = segitigaatas.length;

        // isi segitigaatas
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                segitigaatas[i][j] = M[i][j];
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (j > i && segitigaatas[i][i] != 0) {
                    rasio = segitigaatas[j][i] / segitigaatas[i][i];
                    for (k = 0; k < n; k++) {
                        segitigaatas[j][k] -= rasio * segitigaatas[i][k];
                    }
                }
            }
        }
        det = 1; //storage for determinant
        for (i = 0; i < n; i++)
            det *= segitigaatas[i][i];
        return det;
    }

    public static void printMatriks(double[][] matriks, int brs, int kol) {
        for (int i = 0; i < brs; i++) {
            System.out.print("[\t");
            for (int j = 0; j < kol; j++) {
                System.out.print(matriks[i][j] + "\t");
            }
            System.out.println("\t]");
        }

    }
} // close