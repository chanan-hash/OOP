package Ex1B;

/**
 * This class will be the main program, it will implement the faced pattern, by simplify the usage fot the students
 */

public class Main {
    public static void main(String[] args) {
        RegisterSystem registerSystem = RegisterSystem.getInstance(); // singleton
        Student chanan = Student.createStudent("chanan",1234);
        System.out.println(chanan);
        Student yossi = Student.createStudent("yossi",1235);
    }
}
