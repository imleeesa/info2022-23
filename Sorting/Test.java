public class Test {
    private final Sorter sorter;

    public Test(Sorter sorter) {
        this.sorter = sorter;
    }

    public long runSingleTest(int[] array) {
        long startTime = System.currentTimeMillis();;
        sorter.sort(array);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }

    public long runTest() {
        long time = 0L;
        for(int i=0; i < 100; i++){
            int[] array = Utils.getRandomArray(100);
            time += runSingleTest(array);
        }
        return time;
    }
}