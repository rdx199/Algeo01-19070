package src;

public class getSolution {
    public static boolean isExistsol(double[][] matriks) {
        int count = 0; //
        boolean isexist;
        for (int i= 0; i< matriks.length;i++) {
            isexist = false;
            for (int j=0; j< matriks[0].length-1;j++) {
                if(matriks[i][j]!=0) { //apabila 1 row semua koefisien variablenya 0, maka false
                    isexist=true;
                }
            } if(!(isexist) && matriks[i][matriks[0].length-1]==0) { //apabila semua koef. variable 0, solusi spl 0 maka true, apabila solusi tidak 0, maka false
                isexist=true;
            } else if (!(isexist) && matriks[i][matriks[0].length-1]!=0) { //apabila semua koef. variable 0, solusi tidak 0
                count++; // apabila terdapat baris semua koef. variabel 0, namun solusi tidak 0, count += 1
            }
        } if (count==0) { //
            isexist=true;
        } else {
            isexist=false;
        }
        return isexist;
    }
    public static void getSolutionInverse (double[][] matriks, double[][] inverse) {
        double sum;
        for(int i= 0;i< inverse.length;i++) {
            sum=0;
            for(int j=0;j< inverse.length;j++) {
                sum += inverse[i][j] * matriks[j][matriks[0].length -1]; // baris i kali kolom j  = xi

            } System.out.print("x" + (i + 1) + " = " + sum);
            System.out.println("");
        }
    }
}