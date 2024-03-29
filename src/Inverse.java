package src;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Inverse {
    public static void main(String[] args) {
        int brs,kol;
        double[][] matriks;
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Buat Matriks, 2. Load dari file (1/2) : ");
        int menu1 = scanner.nextInt();

        if (menu1 == 1) {
            System.out.println("BUAT MATRIKS :");
            brs = insertbrs();
            kol = brs;
            matriks = new double[brs][kol];
            System.out.println("");
            Determinan.bacaValue(matriks, brs, kol);
        }
        else if (menu1 == 2) {
            matriks = Readtxt.read();
        }
        else {
            System.out.println("Masukan salah!");
            Createtxt.write("Masukan salah!");
            return;
        }
        matriksBalikan(matriks);
        Scanner scan = new Scanner(System.in);

        System.out.print("\nPress ENTER to go back...");
        scan.nextLine();
    }

    public static int insertbrs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris/kolom (mxm): ");
        return scanner.nextInt();
    }
    public static void matriksBalikan(double[][] matriks) {
        DecimalFormat df = new DecimalFormat("#.###");

        double[][] kofaktor;
        double[][] adjoin;
        double[][] inverse;
        double[][] mSquare = new double[matriks.length][matriks[0].length];
        double epsilon = 0.0001;

        // copy matriks ke mSquare
        for (int i = 0; i < mSquare.length; i++) {
            for (int j = 0; j < mSquare[0].length; j++) {
                mSquare[i][j] = matriks[i][j];
            }
        }

        double determinan = Determinan.ekspansiKofaktor(mSquare);
        if(matriks.length != matriks[0].length || determinan==0) {
            System.out.println("matriks harus matriks persegi atau determinan tidak boleh nol");
            Createtxt.writeoln("matriks harus matriks persegi atau determinan tidak boleh nol");
        }
        else {
            kofaktor=Cofactor.getCofactor(mSquare);
            adjoin=Cofactor.getTranspose(kofaktor);
            inverse=Cofactor.kaliKons(adjoin,(1/determinan));
            for (int i = 0; i < mSquare.length; i++) {
                for (int j = 0; j < mSquare[0].length; j++) {
                    inverse[i][j] = Double.parseDouble(df.format(inverse[i][j]));
                    if (inverse[i][j] < epsilon && inverse[i][j] > -epsilon) {
                        inverse[i][j] = 0;
                    }
                }
            }
            System.out.println("matriks balikannya adalah : ");
            Main.printMatriks(inverse);
            Createtxt.write("matriks balikannya adalah : ");
            Createtxt.writeoln("");
            Createtxt.writeMatriks(inverse);
        }
    }
}
