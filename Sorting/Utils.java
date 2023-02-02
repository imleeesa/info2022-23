import java.util.Random;

public class Utils {

    private static final Random gen = new Random(); 

    private Utils(){};

    public static int[] getRandomArray(int size) {
      int[] array = new int[size];
      for(int i=0; i < size; i++){
        array[i]=gen.nextInt(1,100);
      }
      return array;
    }

    public static void shuffleArray(int[] array) {
        for(int i=0; i < array.length; i++){
            if(gen.nextBoolean()==true){
                array[gen.nextInt(array.length)] = array[gen.nextInt(array.length)];
            }
        }
    }
}
