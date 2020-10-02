package src;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;

public class Createtxt {

    public static void create(String[] args) {
        try {
            File upOne = new File(System.getProperty("user.dir"));
            String path = (upOne+File.separator+"test"+File.separator+"output.txt");

            File txt = new File(path);
            if (txt.createNewFile()) {
                System.out.println(txt.getName()+" berhasil dibuat.");
            } else {
                System.out.println("output.txt sudah ada.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void write(String x) {
        // contoh cara pakai di class lain :
        // Createtxt.write("\nBla bla bla");
        try {
            File upOne = new File(System.getProperty("user.dir"));
            String path = (upOne+File.separator+"test"+File.separator+"output.txt");
            BufferedWriter wr = new BufferedWriter(new FileWriter(path, true));
            wr.write(x);
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeoln(String x) {
        // contoh cara pakai di class lain :
        // Createtxt.write("\nBla bla bla");
        try {
            File upOne = new File(System.getProperty("user.dir"));
            String path = (upOne+File.separator+"test"+File.separator+"output.txt");
            BufferedWriter wr = new BufferedWriter(new FileWriter(path, true));
            wr.write(x+"\n");
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeMatriks(double[][] M) {
        // contoh cara pakai di class lain :
        // Createtxt.write("\nBla bla bla");
        try {

            File upOne = new File(System.getProperty("user.dir"));
            String path = (upOne+File.separator+"test"+File.separator+"output.txt");
            BufferedWriter wr = new BufferedWriter(new FileWriter(path, true));
            for (int i = 0; i < M.length ; i++) {
                for (int j = 0; j < M[0].length ; j++) {
                    wr.write(M[i][j] + " ");
                }
                wr.write("\n");
            }
            wr.write("\n");
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
