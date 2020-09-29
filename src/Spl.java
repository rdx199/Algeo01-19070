package src;


import java.util.Scanner;

public class Spl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistem Persamaan Linear\n\nBUAT MATRIKS :");
        // input matriks
        System.out.print("Masukkan Jumlah Persamaan (SPL) : ");
        int jumlahSPL = scanner.nextInt();
        System.out.print("Masukkan Jumlah Variabel : ");
        int jumlahVar = scanner.nextInt();
        double[][] matriks = new double[jumlahSPL][jumlahVar + 1];
        bacaValue(matriks, jumlahSPL, jumlahVar);

        while (true) {
            System.out.println("\nMatriks Augmented " + jumlahSPL + " x " + (jumlahVar+1));
            printMatriks(matriks);
            System.out.println("\nMenu Sistem Persamaan Linier:\n" +
                    "1. Metode eliminasi Gauss\n" +
                    "2. Metode eliminasi Gauss-Jordan\n" +
                    "3. Metode matriks balikan\n" +
                    "4. Kaidah Cramer\n" +
                    "0. BACK\n");
            System.out.print("Pilih (1/2/3/4/0) : ");

            int pilihan = scanner.nextInt();
            Scanner scan = new Scanner(System.in);

            if (pilihan == 0) {
                break;
            } else if (pilihan == 1) {
                System.out.println("Dengan menggunakan metode Eliminasi Gauss,\ndidapat : ");
                System.out.print("\nPress ENTER to go back...");
                scan.nextLine();
            } else if (pilihan == 2) {
                System.out.println("Dengan menggunakan metode Eliminasi Gauss Jordan,\ndidapat :");
                System.out.print("\nPress ENTER to go back...");
                scan.nextLine();
            } else if (pilihan == 3) {
                System.out.println("Dengan menggunakan metode Matriks Balikan,\ndidapat :");
                System.out.print("\nPress ENTER to go back...");
                scan.nextLine();
            } else if (pilihan == 4) {
                System.out.println("Dengan menggunakan metode Cramer,\ndidapat :");
                cramer(matriks);
                System.out.print("\nPress ENTER to go back...");
                scan.nextLine();
            } else {
                System.out.println("Masukkan salah, silahkan coba lagi!");
            }
        }
    } // tutup main

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
    // METHOD UNTUK CRAMER
    public static void gantikolom(double[][] M,int kolom) {
        for (int i = 0; i < M.length; i++) {
            M[i][kolom] = M[i][M[0].length - 1];
        }
    }
    public static void copy(double[][] m2, double[][] oldmatriks) {
        // m2 : dengan hasil , m3 : matriks persegi
        for (int i = 0; i < oldmatriks.length; i++) {
            for (int j = 0; j < oldmatriks[0].length; j++) {
                m2[i][j] = oldmatriks[i][j];
            }
        }
    }
    public static void cramer (double[][] M) {
        double[][] m2 = new double[M.length][M[0].length];
        copy(m2,M);
        double[][] m3 = new double[M.length][M[0].length - 1];

        // copy m2 ke m3, tapi tidak termasuk hasil spl
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[0].length; j++) {
                m3[i][j] = m2[i][j];
            }
        }
        if (M.length != M[0].length - 1) {
            System.out.println("tidak ada determinan dikarenakan matriks bukan persegi");
        } else {
            double det = Determinan.ekspansiKofaktor(m3);

            for (int j = 0; j < M[0].length - 1; j++) {
                gantikolom(m2,j);
                // copy m2 ke m3, tapi tidak termasuk hasil spl
                for (int k = 0; k < m3.length; k++) {
                    for (int l = 0; l < m3[0].length; l++) {
                        m3[k][l] = m2[k][l];
                    }
                }
                double detx = Determinan.ekspansiKofaktor(m3);
                System.out.println("x" + (j + 1) + " = " + (detx / det));
                copy(m2,M);

            }
        }
    }
} //close
