import java.lang.Math;
public class Punto {
    double x;
    double y;
    static double z; //static Since you haven't created an object, the non-static method doesn't exist yet. A static method (by definition) always exists.

    Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double Distanza(Punto p1, Punto p2){         
        z = Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2);
        return Math.sqrt(z);
    }
}
