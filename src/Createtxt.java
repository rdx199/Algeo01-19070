package src;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;

public class Createtxt {
    public static void create(String[] args) {
        try {
            File txt = new File("output.txt");
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
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt", true));
            wr.write(x);
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
