public class BubbleSort implements Sorter{
    
    public void sort(int[] array){
        for(int i=0; array.length; i++){
            for(int j=0; j < array.length; j++){
                if(array[i]>array[j]){
                    int num = array[i];
                    array[i] = array[j];
                    array[j] = num;
                }
            }
        }
    }
}
