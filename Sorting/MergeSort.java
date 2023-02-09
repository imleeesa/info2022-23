import java.util.Random;

public class MergeSort{
    public static void sort(int[] array) {
    int arraylength = array.length;
    if (arraylength < 2) {
        return;
    }
    int mid = arraylength / 2;
    int[] leftHalf = new int[mid];
    int[] rightHalf = new int[arraylength - mid];

    for(int i = 0; i < mid; i++) {
      leftHalf[i] = array[i];
    }
    for(int i = mid; i < arraylength; i++) {
      rightHalf[i - mid] = array[i];
    }
    sort(leftHalf);
    sort(rightHalf);
    merge(array, leftHalf, rightHalf);
  }

  public static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
    int leftLength = leftHalf.length;
    int rightLength = rightHalf.length;
    
    int i = 0, j = 0, k = 0;
    
    while (i < leftLength && j < rightLength) {
      if (leftHalf[i] <= rightHalf[j]) {
        array[k] = leftHalf[i];
        i++;
      }
      else {
        array[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    
    while (i < leftLength) {
      array[k] = leftHalf[i];
      i++;
      k++;
    }
    
    while (j < rightLength) {
      array[k] = rightHalf[j];
      j++;
      k++;
    }
    
  }

  private static void print(int[] b) {
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }
  }
  public static void main(String[] args) {
    Random rand = new Random();
    int[] array = new int[10];
    for(int i = 0; i < array.length; i++) {
        array[i] = rand.nextInt(100);
    }

    print(array);
    sort(array); 
    System.out.println();
    print(array);
  }
}
