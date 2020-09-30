package src;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Readtxt {

    public static double[][] read () {
        Scanner scan;
        int jmlKol = 0, jmlBrs = 0;
        File file = new File("input.txt");
        // hitung jumlah baris dan kolom
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                jmlBrs++;
                jmlKol = scan.nextLine().split(" ").length;
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        double[][] M = new double[jmlBrs][jmlKol];

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

