package src;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Interpolasi {

    public static void o(String a) {
        Createtxt.write(a);
    }
    public static void oln(String a) {
        Createtxt.writeoln(a);
    }

    public static void main(String[] args) {
        int derajatx;
        double[][] matriksinput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Buat Matriks, 2. Load dari file (1/2) : ");
        int menu1 = scanner.nextInt();
        Scanner scan = new Scanner(System.in);

        if (menu1 == 1) {
            System.out.println("BUAT MATRIKS :");
            System.out.print("Masukkan Derajat: ");
            derajatx = scanner.nextInt();
            matriksinput = new double [derajatx+1][2];
            bacatitik(matriksinput, derajatx+1, 2);
            makeInterpolasi(matriksinput, derajatx);
            System.out.print("\nPress ENTER to go back...");
            scan.nextLine();

        } else if (menu1 == 2) {
            matriksinput = Readtxt.read();
            derajatx = matriksinput.length-1;
            makeInterpolasi(matriksinput, derajatx);
            System.out.print("\nPress ENTER to go back...");
            scan.nextLine();
        } else {
            System.out.println("Masukan salah!");
            return;
        }
    }

    public static void bacatitik(double[][] matriks, int brs, int kol) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < brs; i++) {
            for (int j = 0; j < kol; j++) {
                if (j != 1) {
                    System.out.print("Titik x[" + (i + 1) + "] : ");
                    matriks[i][0] = scanner.nextDouble();
                } else{
                    System.out.print("Titik y[" + (i + 1) + "] : ");
                    matriks[i][1] = scanner.nextDouble();
                }
            }
        }
    }
    public static double[][] makematrix1(double[][] M, int brs, int kol){
        for (int i = 0; i < brs; i++){
            for (int j = 0; j < kol; j++){
                M[i][j] = 1;
            }
        }
        return M;
    }

    public static void makeInterpolasi(double[][] matriksinput, int derajatx){
        Scanner sc = new Scanner(System.in);
        double[][] matrikspersamaan = new double [derajatx+1][derajatx+2];
        double[][] matriksfinal = makematrix1(matrikspersamaan, derajatx+1, derajatx+2);


        for (int i = 0; i < matriksfinal.length; i++){
            for (int j = 0; j < matriksfinal.length-1; j++){
                matriksfinal[i][j] *= pow(matriksinput[i][0],matriksfinal.length-1-j);
            }
            matriksfinal[i][matriksfinal[0].length-1] = matriksinput[i][1];
        }

        Gauss.eselonRed(matriksfinal);
        matrikspersamaan = matriksfinal;
        double[] result = matrikspersamaan[matrikspersamaan.length-1];
        for (int brs = 0; brs < matrikspersamaan.length; brs++){
            result[brs] = matrikspersamaan[brs][matrikspersamaan[0].length-1];
        }

        System.out.println("Persamaan : ");
        oln("Persamaan : ");
        for (int i = 0; i < result.length-1; i++){
            if (i != 0 && (result.length-1 - (i+1)) != 0){
                if (result[i] > 0){
                    System.out.print(" + ");
                    o(" + ");
                    System.out.print(result[i] + "x^" + (result.length-1 - (i+1)));
                    o(result[i] + "x^" + (result.length-1 - (i+1)));

                } else if (result[i] < 0){
                    System.out.print(" - ");
                    o(" - ");
                    System.out.print(-1 * result[i] + "x^" + (result.length-1 - (i+1)));
                    o(-1 * result[i] + "x^" + (result.length-1 - (i+1)));
                }
            } else if ((result.length-1 - (i+1)) == 0){
                if (result[i] > 0){
                    System.out.print(" + ");
                    o(" + ");
                    System.out.print(result[i]);
                    o(String.valueOf(result[i]));
                } else if (result[i] < 0){
                    System.out.print(" - ");
                    o(" - ");
                    System.out.print(-1 * result[i]);
                    o(String.valueOf(-1 * result[i]));
                }
            }
            else{
                if (result[i] < 0){
                    System.out.print(" - ");
                    o(" - ");
                    System.out.print(-1 * result[i] + "x^" + (result.length-1 - (i+1)));
                    o(-1 * result[i] + "x^" + (result.length-1 - (i+1)));
                } else{
                    System.out.print(result[i] + "x^" + (result.length-1 - (i+1)));
                    o(result[i] + "x^" + (result.length-1 - (i+1)));
                }
            }
        }

        System.out.print("\nMasukkan nilai x yang ingin ditaksir : ");
        double taksirx = sc.nextDouble();
        double sum = 0;
        for (int i = 0; i < result.length-1; i++){
            if (result[i] != 0) {
                sum += result[i] * pow(taksirx, (result.length-1 - (i+1)));
            }
        }
        System.out.println("f(" + taksirx + ") = " + sum);
        oln("f(" + taksirx + ") = " + sum);
        System.out.print("\n");
        o("\n");
    }
}
