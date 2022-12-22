public class Pair {
    public int[] Pair_ = new int[2];

    public int getPair(int pos) {
        return this.Pair_[pos];
    }

    public void setPair(int pos, int z) {
        this.Pair_[pos] = z;
    }

    @Override
    public String toString() {
        return "(" + Pair_[0] + ", " + Pair_[1] + ")";
    }
}