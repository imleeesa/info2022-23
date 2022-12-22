import java.lang.reflect.Array;
import java.util.Arrays;

public class MadMatrix2 {
    static int[][] Matrix;
    static int n;
    MadMatrix2(int[][] Matrix) {
        MadMatrix2.Matrix = Matrix;
        MadMatrix2.n= Matrix.length;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                double NumRandom = Math.random()   *10;
                Matrix[i][j] = (int) NumRandom;
            }
        }
    }
    
    void Print(int[][] M){
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
 

@Override
public String toString(){
    String str = "";
    int[] ArrayS = new int[n*n];
    String[] ArrayPos = new String[n*n];
    int z=0;
    int i;
    int j;
    for (i=0; i<Matrix.length; i++) {
        for (j=0; j<Matrix[0].length; j++) {
            ArrayS[z] = Matrix[i][j];
            z++;
        }
    }
    Arrays.sort(ArrayS);

    for (z = 0; z<ArrayS.length;z++) {
        ArrayPos[z]="";
        for (i=0; i<Matrix.length; i++) {
            for (j=0; j<Matrix[0].length; j++) {
                if (ArrayS[z]==Matrix[i][j]) {
                    ArrayPos[z] = ArrayPos[z] + " --> (" + i + ","+"" + j +")";
                    
                }
            }
        }
    }
    for(i=0; i<ArrayS.length;i++) {
        str += ArrayPos[i] + "\n" + ArrayS[i];
    }
    return str;
    }
}

        