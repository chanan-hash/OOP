package TicTacToe;

import java.lang.reflect.Field;


class A {
    public String open = "I have nothing to hide!";
    private String hidden = "DONT LOOK AT ME";

    public A() {
    }

    public static void main(String[] args) throws IllegalAccessException {
        //print ALL fields of an instance of A
        A a = new A();
        Class cls = a.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            String fieldValue = (String) f.get(a);
            System.out.println("fieldValue = " + fieldValue);
        }
    }

}



