import java.util.ArrayList;

public class Value {
    public int n;
    public ArrayList<Pair> Pair;

    public Value() {
        Pair = new ArrayList<Pair>();
    }

    public void setNum(int n) {
        this.n = n;
    }

    public int getNum() {
        return this.n;
    }

    public void setPair(int x, int y) {
        Pair t = new Pair();
        t.setPair(0, x);
        t.setPair(1, y);
        Pair.add(t);
    }
    public String getString() {
        String s1 = n + " -> ";
        for (int i = 0; i < Pair.size(); i++) {
            s1 += "(" + Pair.get(i).getPair(0) +", " + Pair.get(i).getPair(1) + ") ";
        }
        return s1;
    }
}