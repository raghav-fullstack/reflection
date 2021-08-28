import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;

public class ReflectionDemo {
    public static void main(String[] args) {
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        //Object o = Class.forName(ReflectionDemo).newInstance();

        try {
            ReflectionDemo reflectionDemo1 = ReflectionDemo.class.getConstructor().newInstance();
            ReflectionDemo reflectionDemo2 = (ReflectionDemo) reflectionDemo1.clone();
            DateFormat instance = DateFormat.getInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
