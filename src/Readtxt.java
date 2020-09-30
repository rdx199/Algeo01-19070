package src;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Readtxt {

    public static double[][] read () {
        Scanner scan; String filename = "input";
        Scanner f = new Scanner(System.in);
        int jmlKol = 0, jmlBrs = 0;
        boolean found = false;


        // hitung jumlah baris dan kolom
        while (!found) {
            try {
                System.out.print("Masukkan nama file text (tanpa '.txt') : ");
                filename = f.nextLine();
                File file = new File(filename+".txt");
                scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    jmlBrs++;
                    jmlKol = scan.nextLine().split(" ").length;
                    found = true;
                }
            } catch (FileNotFoundException e1) {
                System.out.println("File not found, please try again!");
            }
        }

        double[][] M = new double[jmlBrs][jmlKol];
        File file = new File(filename+".txt");
        try {
            scan = new Scanner(file);
            while (scan.hasNextDouble()) {
                for (int i = 0; i < jmlBrs; i++) {
                    for (int j = 0; j < jmlKol; j++) {
                        M[i][j] = scan.nextDouble();
                    }
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return M;

    }
}

