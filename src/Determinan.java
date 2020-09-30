package src;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Determinan {

    public static void main(String[] args) {
        int brs,kol;
        double[][] matriks;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Buat Matriks 2. Load dari file (1/2) : ");
        int menu1 = scanner.nextInt();

        if (menu1 == 1) {
            System.out.println("BUAT MATRIKS :");
            brs = insertbrs();
            kol = insertkol();
            matriks = new double[brs][kol];
            System.out.println("");
            bacaValue(matriks, brs, kol);
        }
        else if (menu1 == 2) {
            matriks = Readtxt.read();
            brs = matriks.length;
            kol = matriks[0].length;
        }
        else {
            System.out.println("Masukan salah!");
            return;
        }
        // loop menu
        if (brs != kol) {
            System.out.print("Tidak ada determinan karena bukan matriks persegi\n\nPress ENTER to go back...");
            Createtxt.write("\nTidak ada determinan karena bukan matriks persegi\n");
            scanner.nextLine();
        } else {
            while (true) {
                System.out.println("\nMatriks " + brs + " x " + kol);
                Main.printMatriks(matriks);
                System.out.println("\nMENU DETERMINAN:\n" +
                        "1. Metode Ekspansi Kofaktor\n" +
                        "2. Metode Reduksi Baris\n" +
                        "0. BACK\n");

                int pilihan = menu();
                if (pilihan == 0) {
                    break;
                } else if (pilihan == 1) {
                    System.out.println("Dengan menggunakan metode Ekspansi Kofaktor,\ndidapat nilai determinan = " + ekspansiKofaktor(matriks));
                    Createtxt.write("\nDengan menggunakan metode Ekspansi Kofaktor,\ndidapat nilai determinan = " + ekspansiKofaktor(matriks));
                    System.out.print("\nPress ENTER to go back...");
                    scanner.nextLine();
                } else if (pilihan == 2) {
                    System.out.println("Dengan menggunakan metode Reduksi Baris,\ndidapat nilai determinan = " + reduksiBaris(matriks));
                    Createtxt.write("\nDengan menggunakan metode Reduksi Baris,\ndidapat nilai determinan = " + reduksiBaris(matriks));
                    System.out.print("\nPress ENTER to go back...");
                    scanner.nextLine();
                } else {
                    System.out.println("Masukkan salah, silahkan coba lagi!");
                    Createtxt.write("\nMasukkan salah, silahkan coba lagi!");

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
        double rasio, det = 1;
        double[][] segitigaatas = new double[M.length][M[0].length];
        int n = segitigaatas.length;

        // isi segitigaatas
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                segitigaatas[i][j] = M[i][j];
            }
        }
        // tukar jika elemen1,1 = 0
        if (segitigaatas[0][0] == 0) {
            for (int x = 1; x <segitigaatas.length; x++) {
                if (segitigaatas[x][0] != 0) {
                    double[] temp = segitigaatas[0];
                    segitigaatas[0] = segitigaatas[x];
                    segitigaatas[x] = temp;
                    det = -1;
                    break;
                }
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (j > i) {
                    rasio = segitigaatas[j][i] / segitigaatas[i][i];
                    for (k = 0; k < n; k++) {
                        segitigaatas[j][k] -= rasio * segitigaatas[i][k];
                    }
                }
            }
        }
         //storage for determinant
        for (i = 0; i < n; i++)
            det *= segitigaatas[i][i];
        return det;
    }
} // close
