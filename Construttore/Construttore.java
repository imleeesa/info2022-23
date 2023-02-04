public class Construttore{
    public static void main(String[] args) {
        
         Dog myDog = new Dog("tom", 2 ,"red");
         Dog bobsdog = new Dog("Tony", 5 ,"white");
         System.out.println(myDog);
         System.out.println(bobsdog);
         System.out.println("My dog uman age: " + (myDog.age * Constants.ONE_YEAR_DOGS_UMAN_AGE));
         System.out.println("Bobs's dog uman age: " + (bobsdog.age * Constants.ONE_YEAR_DOGS_UMAN_AGE));
    }
}