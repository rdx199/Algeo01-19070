package src;

import java.util.Scanner;

public class Regresi {
    public static void main(String[] args){
        int inputn, inputk;
        double[][] matriksinput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Buat Matriks, 2. Load dari file (1/2) : ");
        int menu1 = scanner.nextInt();

        if (menu1 == 1) {
            System.out.println("BUAT MATRIKS :");
            System.out.print("Masukkan n persamaan: ");
            inputn = scanner.nextInt();
            System.out.print("Masukkan k (peubah x): ");
            inputk = scanner.nextInt();
            matriksinput = new double [inputn][inputk+1];

            
            bacaValue(matriksinput, inputn, inputk+1);
            makeRegresi(matriksinput, inputn, inputk);
        } else if (menu1 == 2) {
            matriksinput = Readtxt.read();
            inputn = matriksinput.length;
            System.out.print("Masukkan k (peubah x): ");
            inputk = scanner.nextInt();
            makeRegresi(matriksinput, inputn, inputk);
        } else {
            System.out.println("Masukan salah!");
            return;
        }
    }
    public static void bacaValue(double[][] matriks, int brs, int kol) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < brs; i++) {
            System.out.print("Masukkan matriks baris ke-"+(i+1)+" : ");
            for (int j = 0; j < kol; j++) {
                matriks[i][j] = scanner.nextDouble();
            }
        }
    }

    public static double[][] getTranspose(double[][] matriks) {
        double[][] transpose = new double[matriks[0].length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                transpose[j][i] = matriks[i][j];
            }
        }
        return transpose;
    }

    public static double[][] matriksadd1 (double[][] matriks){
        double[][] matrixadd1 = new double[matriks.length][matriks[0].length+1];
        for (int i = 0; i < matrixadd1.length; i++){
            matrixadd1[i][0] = 1;
        }
        for (int i = 0; i < matriks.length; i++){
            for (int j = 0; j < matriks[0].length; j++){
                matrixadd1[i][j+1] = matriks[i][j];
            }
        }
        return matrixadd1;
    }
    public static double[][] newmatriks (double[][] matriks){
        double[][] newmatrix = new double[matriks.length][matriks[0].length];

        for (int i = 0; i < newmatrix.length; i++){
            newmatrix[i][0] = 1;
        }
        for (int i = 0; i < matriks.length; i++){
            for (int j = 0; j < matriks[0].length-1; j++){
                newmatrix[i][j+1] = matriks[i][j];
            }
        }
        return newmatrix;
    }
    public static double[][] kalimatriks(double[][] matriks1, double[][] matriks2){
        double[][] result = new double[matriks1.length][matriks2[0].length];
        if (matriks1[0].length != matriks2.length){
            System.out.println("Matriks tidak dapat dikalikan");
        } else{
            for (int i = 0; i < matriks1.length; i++){
                for (int j = 0; j < matriks2[0].length; j++){
                    double sum = 0;
                    for (int k = 0; k < matriks1[0].length; k++){
                        sum += matriks1[i][k] * matriks2[k][j];
                    }
                    result[i][j] = sum;
                }
            }
        }
        return result;
    }
    public static void o(String a) {
        Createtxt.write(a);
    }
    public static void oln(String a) {
        Createtxt.writeoln(a);
    }
    public static void om(double[][] M) {
        Createtxt.writeMatriks(M);
    }
    public static void makeRegresi(double[][] matriksinput, int inputn, int inputk){
        double[][] matriksinputclone = matriksinput;
        Scanner sc = new Scanner(System.in);
        double[] inputxi = new double[inputk];
        double[][] matrikstemp;
        double[][] matrikstemp1;
        double[][] matrikstemp2;
        double[][] matriksReg;
        matrikstemp = matriksadd1(matriksinputclone);
        matrikstemp1 = newmatriks(matriksinput);
        matrikstemp2 = getTranspose(matrikstemp1);
        matriksReg = kalimatriks(matrikstemp2, matrikstemp);

        System.out.println("");
        oln("");
        System.out.println("SPL yang terbentuk: ");
        oln("SPL yang terbentuk: ");
        Main.printMatriks(matriksReg);
        om(matriksReg);
        System.out.println("");
        oln("");

        System.out.print("");
        o("");
        for (int m = 0; m < inputk; m++){
            System.out.print("Masukkan nilai x[" + (m+1) +  "] yang ingin ditaksir : ");
            inputxi[m] = sc.nextDouble();
            oln("Masukkan nilai x[" + (m+1) +  "] yang ingin ditaksir : "+inputxi[m]);

        }
        Gauss.eselonRed(matriksReg);
        System.out.println("");
        oln("");

        double[] result = new double[matriksReg.length];

        for (int i = 0; i < result.length; i++){
            result[i] = matriksReg[i][matriksReg[0].length-1];
        }

        System.out.println("Persamaan yang terbentuk setelah menyelesaikan SPL: ");
        oln("Persamaan yang terbentuk setelah menyelesaikan SPL: ");
        for (int i = 0; i < result.length; i++){
            if (i == 0){
                if (result[i] < 0){
                    System.out.print(" - ");
                    o(" - ");
                    System.out.print(-1 * result[i]);
                    o(String.valueOf(-1 * result[i]));
                } else{
                    System.out.print(result[i]);
                    o(String.valueOf(result[i]));
                }
            } else{
                if (i == result.length){
                    if (result[i] > 0){
                        System.out.print(" + ");
                        o(" + ");
                        System.out.print(result[i] + "x" + i);
                        o(result[i] + "x" + i);
                    } else if (result[i] < 0){
                        System.out.print(" - ");
                        o(" - ");
                        System.out.print(-1 * result[i] + "x" + i);
                        o(-1 * result[i] + "x" + i);
                    }
                } else{
                    if (result[i] > 0){
                        System.out.print(" + ");
                        o(" + ");
                        System.out.print(result[i] + "x" + i);
                        o(result[i] + "x" + i);
                    } else if (result[i] < 0){
                        System.out.print(" - ");
                        o(" - ");
                        System.out.print(-1 * result[i] + "x" + i);
                        o(-1 * result[i] + "x" + i);
                    }
                }
            }
        }
        System.out.println("");
        oln("");
        System.out.println("Taksiran : ");
        oln("Taksiran : ");
        double sum = result[0];
        for (int i = 1; i < result.length; i++){
            sum += result[i] * inputxi[i-1];
        }
        System.out.println("y = " + sum);
        oln("y = " + sum);
        System.out.println("");
        oln("");
    }
}
