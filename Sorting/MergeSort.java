import java.lang.reflect.Array;
public class MergeSort{

    public void sort(int[] array, int start, int size){
        merge(array, start, size);
    }
    private void merge(int[] array, int start, int size){
        int l;
        int i;
        if (array.length%2 == 0) {
            l = array.length/2; 
        }
        else {
            l = (array.length/2)+1;
        }
        int num = array[0];
        for(i=0; i < l; i++){ 
            if(num>array[i]){
                int num2=array[i];
                array[i-1]=num2;
                array[i]=num;
            }
            num=array[i]; 
        }
        for(i=l; i < array.length-l; i++){ 
            if(num>array[i]){
                int num2=array[i];
                array[i-1]=num2;
                array[i]=num;
            }
            num=array[i]; 
        }
        if((array.length-start)%size==0){
            int p = (array.length-start)/size;
            i=0;
            while(i < size){
            if(array[start]>array[start+size]){
                int n = array[start];
                array[start]=array[start+size];
                array[start+size]=n;
            }
            i++;
            }
        }

    }
}
