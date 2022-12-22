import java.util.ArrayList;
public class MadMatrix {
    private ArrayList<Value> matrice;
    public MadMatrix(int[][] matrice2) {
        this.matrice = new ArrayList<Value>();
        for (int i = 0; i < matrice2.length; i++) {
            for (int j = 0; j < matrice2[i].length; j++) {
                int value = matrice2[i][j];
                int pos = search(matrice, value);
                if (pos >= 0) {
                    matrice.get(pos).setPair(i, j);
                } else {
                    matrice.add(new Value());
                    matrice.get(matrice.size() - 1).setNum(value);
                    matrice.get(matrice.size() - 1).setPair(i, j);
                }
            }
        }

        matrice = sort(matrice);
    }

    @Override
    public String toString() {
        String s1 = "";
        for (int i = 0; i < matrice.size(); i++) {
            s1 += matrice.get(i).getString() + "\n";
        }
        return s1;
    }

    private int search(ArrayList<Value> matrice2, int value) {
        for (int i = 0; i < matrice.size(); i++) {
            if (matrice2.get(i).getNum() == value) {
                return i;
            }
        }

        return -1;
    }

    private ArrayList<Value> sort(ArrayList<Value> matrice2) {
        ArrayList<Value> MatriceDef = new ArrayList<Value>();
        ArrayList<Value> elements = new ArrayList<Value>();
        int i = 0;

        for (int k = 0; k < matrice2.size(); k++) {
            elements.add(matrice2.get(k));
        }

        while (i < matrice2.size()) {
            Value element = matrice2.get(i);
            if (search(MatriceDef, element.getNum()) == -1) {
                boolean isMinor = true;
                for (int j = 0; j < elements.size(); j++) {
                    if (element.getNum() > elements.get(j).getNum()) {
                        isMinor = false;
                        break;
                    }
                }
                if (isMinor) {
                    MatriceDef.add(element);
                    elements.remove(element);
                    i = 0;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return MatriceDef;
    }
}