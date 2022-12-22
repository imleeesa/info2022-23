public class MadMatrixMain {
    public static void main(String[] args) {
        int[][] matriceA = new int[4][4];
        for (int i = 0; i < matriceA.length; i++) {
            for (int j = 0; j < matriceA[0].length; j++) {
                double NumRandom = Math.random()   *10;
                matriceA[i][j] = (int) NumRandom;
            }
        }
        MadMatrix mm1 = new MadMatrix(matriceA);
        System.out.println(mm1);
    }
}
