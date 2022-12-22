public class MadMatrixTest2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] Matrice_ = new int[n][n];           //solo radici quadrate

        MadMatrix2 m1 = new MadMatrix2(Matrice_);
        m1.Print(Matrice_);
        System.out.println(m1);
    }
}