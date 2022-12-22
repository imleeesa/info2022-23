public class MadMatrix {
    /*static int n=5;
    static int[][] matrixA= new int[n][n];    
    */
    MadMatrix(int n){
        int[][] matrixA= new int[n][n];
        for(int i=0; i < matrixA.length; i++){
            for(int j=0; j < matrixA[0].length; j++){
                double NumeroRandom = Math.random()*10;
                matrixA[i][j]= (int)NumeroRandom;
            }
        }
        int[] patata = new int[n*n];
    }

    @Override
    public String toString() {
        return /*n -> (pos1,pos1) (pos1, pos2) */   //DENTRO UN ARRAY
    }

    public static void main(String[] args) {
        MadMatrix m1 = new MadMatrix(5);
        
    }
}
