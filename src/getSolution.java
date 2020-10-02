package src;

public class getSolution {
    public static void main(String[] args) {
        double[][] matriks = Readtxt.read();
        Main.printMatriks(matriks);
        Gauss.eselonRed(matriks);
        Main.printMatriks(matriks);
    }
    public static void o(String a) {
        Createtxt.write(a);
    }
    public static void om(double[][] M) {
        Createtxt.writeMatriks(M);
    }
    public static boolean isExistsol(double[][] matriks) {
        int count = 0; //
        boolean isexist;
        for (int i = 0; i < matriks.length; i++) {
            isexist = false;
            for (int j = 0; j < matriks[0].length - 1; j++) {
                if (matriks[i][j] != 0) { //apabila 1 row semua koefisien variablenya 0, maka false
                    isexist = true;
                }
            }
            if (!(isexist) && matriks[i][matriks[0].length - 1] == 0) { //apabila semua koef. variable 0, solusi spl 0 maka true, apabila solusi tidak 0, maka false
                isexist = true;
            } else if (!(isexist) && matriks[i][matriks[0].length - 1] != 0) { //apabila semua koef. variable 0, solusi tidak 0
                count++; // apabila terdapat baris semua koef. variabel 0, namun solusi tidak 0, count += 1
            }
        }
        if (count == 0) { //
            isexist = true;
        } else {
            isexist = false;
        }
        return isexist;
    }

    public static void getSolutionInverse(double[][] matriks, double[][] inverse) {
        double sum;
        if (!(isExistsol(matriks))) {
            System.out.println("\nSPL tidak memiliki solusi");
            o("\nSPL tidak memiliki solusi\n");
            return;
        }
        for (int i = 0; i < inverse.length; i++) {
            sum = 0;
            for (int j = 0; j < inverse.length; j++) {
                sum += inverse[i][j] * matriks[j][matriks[0].length - 1]; // baris i kali kolom j  = xi

            }
            System.out.print("x" + (i + 1) + " = " + sum);
            System.out.println("");
            o("x" + (i + 1) + " = " + sum);
            o("\n");
        }
    }

    public static boolean isSatuUtama(double[][] M, int idbrs, int idkol) {
        boolean depanAllZero = true, isOne = false;
        int count0 = 0;
        int count1 = 0;

        if (M[idbrs][idkol] == 1) {
            // cek depannya 0 semua
            for (int j = 0; j < idkol; j++) {
                if (M[idbrs][j] != 0) {
                    depanAllZero = false;
                    break;
                }
            }
            if (depanAllZero) {
                // cek kolomnya
                for (int i = 0; i < M.length; i++) {
                    if (M[i][idkol] == 0) {
                        count0++;
                    } else if (M[i][idkol] == 1) {
                        count1++;
                    }
                }
                if (count1 == 1 && count0 == M.length - 1) {
                    isOne = true;
                }
            }
        }
        return isOne;
    }

    public static void gaussJordanSolution(double[][] matriks) {

        // ubah menjadi gauss jordan
        o("\n");
        Gauss.eselonRed(matriks);
        System.out.println("Matriks Eselon Reduksi dari SPL :");
        Main.printMatriks(matriks);
        o("Matriks Eselon Reduksi dari SPL :\n");
        om(matriks);
        if (!(isExistsol(matriks))) {
            System.out.println("\nSPL tidak memiliki solusi");
            o("\nSPL tidak memiliki solusi\n");
            return;
        }
        int idparameter = 1;
        System.out.println("\nSolusi SPL : ");
        o("Solusi SPL : \n");
        String[] par = new String[matriks[0].length - 1];
        for (int j = 0; j < matriks[0].length - 1; j++) {
            par[j] = "s";
        }
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length - 1; j++) {
                if (isSatuUtama(matriks, i, j)) {
                    par[j] = String.valueOf(matriks[i][matriks[0].length - 1]);
                }
            }
        }
        for (int j = 0; j < matriks[0].length - 1; j++) {
            if (par[j].equals("s")) {
                par[j] = "s" + idparameter;
                idparameter++;
            }
        }

        int stepbaris = 0;
        String out1;
        // cek baris
        for (int j = 0; j < matriks[0].length - 1; j++) {
            if (isSatuUtama(matriks, stepbaris, j)) {
                out1 = "x" + (j + 1) + " = " + par[j];
                System.out.print("\n"+out1);
                o("\n"+out1);
                // ngeprint belakang2nya

                for (int k = j + 1; k < matriks[0].length - 1; k++) {
                    if (matriks[stepbaris][k] != 0) {
                        double ras = matriks[stepbaris][k];
                        System.out.print(" + (" + ((-1) * ras) + ")" + par[k]);
                        o(" + (" + ((-1) * ras) + ")" + par[k]);
                    }
                }
                if (stepbaris < matriks.length -1) {
                    stepbaris++;
                }
            } else {
                out1 = "x" + (j + 1) + " = " + par[j];
                System.out.print("\n"+out1);
                o("\n"+out1);
            }
        }
    }

    public static void gaussSolution(double[][] matriks) {

        // ubah menjadi gauss jordan
        o("\n");
        Gauss.eselonRow(matriks);
        System.out.println("Matriks Eselon Reduksi dari SPL :");
        Main.printMatriks(matriks);
        o("Matriks Eselon Reduksi dari SPL :\n");
        om(matriks);
        Gauss.eselonRed(matriks);
        if (!(isExistsol(matriks))) {
            System.out.println("\nSPL tidak memiliki solusi");
            o("\nSPL tidak memiliki solusi\n");
            return;
        }
        int idparameter = 1;
        System.out.println("\nSolusi SPL : ");
        o("Solusi SPL : \n");
        String[] par = new String[matriks[0].length - 1];
        for (int j = 0; j < matriks[0].length - 1; j++) {
            par[j] = "s";
        }
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length - 1; j++) {
                if (isSatuUtama(matriks, i, j)) {
                    par[j] = String.valueOf(matriks[i][matriks[0].length - 1]);
                }
            }
        }
        for (int j = 0; j < matriks[0].length - 1; j++) {
            if (par[j].equals("s")) {
                par[j] = "s" + idparameter;
                idparameter++;
            }
        }

        int stepbaris = 0;
        String out1;
        // cek baris
        for (int j = 0; j < matriks[0].length - 1; j++) {
            if (isSatuUtama(matriks, stepbaris, j)) {
                out1 = "x" + (j + 1) + " = " + par[j];
                System.out.print("\n"+out1);
                o("\n"+out1);
                // ngeprint belakang2nya

                for (int k = j + 1; k < matriks[0].length - 1; k++) {
                    if (matriks[stepbaris][k] != 0) {
                        double ras = matriks[stepbaris][k];
                        System.out.print(" + (" + ((-1) * ras) + ")" + par[k]);
                        o(" + (" + ((-1) * ras) + ")" + par[k]);
                    }
                }
                if (stepbaris < matriks.length -1) {
                    stepbaris++;
                }
            } else {
                out1 = "x" + (j + 1) + " = " + par[j];
                System.out.print("\n"+out1);
                o("\n"+out1);
            }
        }
    }

}


