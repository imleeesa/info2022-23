class stack {
    int size = 10;
    int top = -1;
    int[] ArrayTable = new int[size];

    void push(Integer n) {
        if (top + 1 == size) {
            System.out.println("Lo stack è pieno");
        } else {
            top++;
            ArrayTable[top] = n;
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Lo stack è vuoto");
        } else {
            top--;
        }
    }

    boolean empty() {
        return top == -1;
    }

    @Override
    public String toString() {
        String r = "[";
        for (int i = 0; i < top; i++) {
            r = r + ArrayTable[i] + ",";
        }
        r = r + ArrayTable[top] + "]";
        return r;
    }

    public static void main(String[] args) {
        stack S = new stack();
        S.push(5);
        S.push(6);
        S.push(10);
        System.out.println(S);
        S.pop();
        System.out.println(S);
        S.push(10);
        System.out.println(S);
    }
}
