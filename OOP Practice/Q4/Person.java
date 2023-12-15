package Q4;

public class Person {

    private String id; // needs to be 9 number, amd the first number can be 0
    private String name;

    private int birthYear;


    public Person(String id, String name, int year) throws Exception {
        // Checking the id correction
        if (id.length() != 9) {
            throw new PersonException("The id number is not a nine digits");
        } else {
            this.id = id;
        }

        // The same for the name
        if (name.isEmpty()) {
            throw new PersonException("You have put an empty name");
        } else {
            this.name = name;
        }

        // And for the birth year
        if (year > 2013) {
            throw new PersonException("You have put an incorrect year, please put less than 2013");
        } else {
            this.birthYear = year;
        }
    }

    public int compareTo(Person other) {
        if (other.birthYear > this.birthYear) { // Means 'other' is younger
            return 1;
        } else if (other.birthYear < this.birthYear) { // Means 'other', is older
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }


    public static void main(String[] args) throws Exception {
        Person person = new Person("433527689", "Jon", 2012);
        System.out.println(person);
    }
}
