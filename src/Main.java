package src;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\nMENU UTAMA\n" +
                            "1. Sistem Persamaaan Linier\n" +
                            "2. Determinan\n" +
                            "3. Matriks balikan\n" +
                            "4. Interpolasi Polinom\n" +
                            "5. Regresi linier berganda\n" +
                            "0. EXIT\n");

            System.out.print("Pilih (1/2/3/4/5/0) : ");
            int menu1 = scanner.nextInt();
            if (menu1 == 0) {
                break;
            } else if (menu1 == 1) {
                Spl.main(args);
            } else if (menu1 == 2) {
                Determinan.main(args);
            } else if (menu1 == 3) {
                Inverse.main(args);
            } else if (menu1 == 4) {
                Interpolasi.main(args);
            } else if (menu1 == 5) {
                System.out.println("blm");
            } else {
                System.out.println("Masukkan salah, silahkan coba lagi!");
            }
        }
    }

    public static void printMatriks(double[][] M) {
        int brs = M.length;
        int kol = M[0].length;
        for (int i = 0; i < brs; i++) {
            System.out.print("[\t");
            for (int j = 0; j < kol; j++) {
                System.out.print(M[i][j] + "  ");
            }
            System.out.println("\t]");
        }

    }

}
