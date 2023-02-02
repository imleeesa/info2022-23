import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int[] Array = new int[size];
        Random r = new Random();
        for(int i=0; i < Array.length;){
            Array[i]= r.nextInt(1,100);
        }
        long start = System.currentTimeMillis();
        Utils.getRandomArray(5);
        long end = System.currentTimeMillis();
        System.out.println("elapsed time: " + (end - start));

        start = System.currentTimeMillis();
        Utils.shuffleArray(Array);
        end = System.currentTimeMillis();
        System.out.println("elapsed time: " + (end - start));

    }
}
