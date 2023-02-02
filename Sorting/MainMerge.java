import java.lang.reflect.Array;
import java.util.Random;

public class MainMerge {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Random r = new Random();
        int size=4;
        int[] array = new int[size];
        for(int i=0; i < array.length; i++){
            array[i]=r.nextInt(10);
            System.out.print(array[i] + " ");
        }
        m.sort(array, 2, 2);
    }
    
}
