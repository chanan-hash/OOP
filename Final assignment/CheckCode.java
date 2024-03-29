import java.util.ArrayList;
import java.util.List;

public class CheckCode {
    public static void main(String[] args) {

        // Q1
//        List<Person> uppercaseLettersList = new ArrayList<>();
//        List<Person> lowercaseLettersList = new ArrayList<>();
//
//        lowercaseLettersList.add(new Person("alice"));
//        lowercaseLettersList.add(new Person("bob"));
//
////        for (int i = 0; i < lowercaseLettersList.size(); i++) {
////            uppercaseLettersList.add(new Person(lowercaseLettersList.get(i).getName().toUpperCase()));
////        }
////        for (int i = 0; i < lowercaseLettersList.size(); i++) {
////            uppercaseLettersList.add(lowercaseLettersList.get(i));
////            uppercaseLettersList.get(i).setName(uppercaseLettersList.get(i).getName().toUpperCase());
////        }
//
//        for (int i = 0; i < lowercaseLettersList.size(); i++) {
//            uppercaseLettersList.add(new Person(lowercaseLettersList.get(i).getName()));
//            uppercaseLettersList.get(i).setName(uppercaseLettersList.get(i).getName().toUpperCase());
//        }
//
//        // Printing the first list
//        System.out.println("Uppercase List:");
//        for (Person person : uppercaseLettersList) {
//            System.out.println(person.getName());
//        }
//
//        // Printing the second list
//        System.out.println("Lowercase List:");
//        for (Person person : lowercaseLettersList) {
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
                System.out.println(position);
            }
            System.out.println();
        }

        // Q3

    }
}

