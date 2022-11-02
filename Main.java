import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci la x del primo punto");
        double x = in.nextDouble();
        System.out.println("Inserisci la y del primo punto");
        double y = in.nextDouble();
        Punto p1 = new Punto(x,y);

        System.out.println("Inserisci la x del secondo punto");
        double x2 = in.nextDouble();
        System.out.println("Inserisci la y del secondo punto");
        double y2 = in.nextDouble();
        Punto p2 = new Punto(x2,y2);

        System.out.println("Primo punto, x= " + p1.x + " y= " + p1.y);
        System.out.println("Primo punto, x= " + p2.x + " y= " + p2.y);
        System.out.println("La distanza tra i due punti: " + Punto.Distanza(p1,p2));
    }
}