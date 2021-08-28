package reflection;

public class Test {

    public static void main(String[] args)  {

        try {
            System.out.println(Class.forName(Calculator.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
