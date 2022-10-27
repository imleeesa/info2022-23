public class Dog{

    String name;
    int age;
    String color;
    int UmanAge;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
@Override
public String toString(){
    return name + " " + age + " " + color;
}
}