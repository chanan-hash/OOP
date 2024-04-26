import java.util.ArrayList;
import java.util.List;

public class CheckCode {
    public static void main(String[] args) {

        // Q1
//        List<Ex1B.Person> uppercaseLettersList = new ArrayList<>();
//        List<Ex1B.Person> lowercaseLettersList = new ArrayList<>();
//
//        lowercaseLettersList.add(new Ex1B.Person("alice"));
//        lowercaseLettersList.add(new Ex1B.Person("bob"));
//
////        for (int i = 0; i < lowercaseLettersList.size(); i++) {
////            uppercaseLettersList.add(new Ex1B.Person(lowercaseLettersList.get(i).getName().toUpperCase()));
////        }
////        for (int i = 0; i < lowercaseLettersList.size(); i++) {
////            uppercaseLettersList.add(lowercaseLettersList.get(i));
////            uppercaseLettersList.get(i).setName(uppercaseLettersList.get(i).getName().toUpperCase());
////        }
//
//        for (int i = 0; i < lowercaseLettersList.size(); i++) {
//            uppercaseLettersList.add(new Ex1B.Person(lowercaseLettersList.get(i).getName()));
//            uppercaseLettersList.get(i).setName(uppercaseLettersList.get(i).getName().toUpperCase());
//        }
//
//        // Printing the first list
//        System.out.println("Uppercase List:");
//        for (Ex1B.Person person : uppercaseLettersList) {
//            System.out.println(person.getName());
//        }
//
//        // Printing the second list
//        System.out.println("Lowercase List:");
//        for (Ex1B.Person person : lowercaseLettersList) {
//            System.out.println(person.getName());
//        }

        // Q2

        int n = 10;
        Position[][] positiona = new Position[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positiona[i][j] = new Position(i, j);
            }
        }
        for (Position[] position_row : positiona) {
            for (Position position : position_row) {
                System.out.print(position);
            }
            System.out.println();
        }

        // Q3
        Animal animal = new Dog();
        animal.makeSound(); // will return the sound of a dog because the method is overridden in the Dog class, and we've created a dog object
    }
}

/**
public class Animal {
    final static String sound = "Animal sound";

    void makeSound() {
        System.out.println(sound);
    }
}
public class Dog extends Animal{
    final static String sound = "Bark";

    void makeSound() {
        System.out.println(sound);
    }
}


public class CheckCode {
    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.makeSound(); // will return the sound of a dog because the method is overridden in the Dog class, and we've created a dog object
    }
}

What one thing should I change the code to be polymorfic behavior?
*/