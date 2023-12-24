package Q5;

/**
 * This class will be a Linked-List that we've created, of Workers and Mangers from Q2
 */
public class ListWM {

    public static void main(String[] args) {
        // List of workers
        LinkedList<Worker> workerLinkedList = new LinkedList<Worker>();
        Worker w1 = new Worker("w1", 1234, 1000); // Can be added to the list
        Manager m2 = new Manager("M2", 5678, 9000); // Also can be added to the list, because 'Manager' is kind of 'Worker', because he inherits from 'Worker'

        workerLinkedList.add(w1);
        workerLinkedList.add(m2);
        workerLinkedList.add(new Worker("w3",90124,234254)); // We can add directly to the list, creating the objects to the list itself

        // Manager List
        LinkedList<Manager> managerLinkedList = new LinkedList<Manager>();
        managerLinkedList.add(m2); // This is a lis of 'Managers'
//        managerLinkedList.add(w1); // the inheritance here is only from 'Worker' to others, 'Worker' is not kind of 'Manager'. So we can't add him to the list.

        System.out.println(workerLinkedList);
        System.out.println(managerLinkedList);
    }
}
