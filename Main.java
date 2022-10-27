public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(2,-5);
        Punto p2 = new Punto(3,3);

        System.out.println("Primo punto, x= " + p1.x + " y= " + p1.y);
        System.out.println("Primo punto, x= " + p2.x + " y= " + p2.y);
        System.out.println("La distanza tra i due punti: " + Punto.Distanza(p1,p2));
    }
}