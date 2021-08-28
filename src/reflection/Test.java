package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    public static void main(String[] args)  {

        try {
            Class<?> myClass = Class.forName(Calculator.class.getName());
            System.out.println("Name of the Class :"+myClass.getName());
            Constructor<?> myClassConstructor = myClass.getConstructor();

            System.out.println(myClassConstructor.getName());
            System.out.println(myClass.getConstructor().getParameters());
            System.out.println("\n List of methods of class : "+Arrays.toString(myClass.getMethods()));

            Constructor<?> constructor = myClass.getConstructor(null);
            constructor.newInstance(null);

            Constructor<?> constructorParameterized = myClass.getConstructor(double.class, double.class);
            System.out.println(constructorParameterized.newInstance(5, 10));

            Object o = constructorParameterized.newInstance(5, 10);

            Field num1s = myClass.getDeclaredField("num1");
            num1s.setAccessible(true);
            num1s.setDouble(o,80);

            Annotation[] annotations = myClass.getAnnotations();
            System.out.println("\n Annotations :" + Arrays.toString(annotations));
            MyAnnotation annotation = (MyAnnotation) annotations[0];

            System.out.println(annotation.value1());
            System.out.println(annotation.value2());

            Method getNum1 = myClass.getMethod("getNum1", null);
            System.out.println(getNum1.invoke(o,null));

            Method getNum2 = myClass.getMethod("getNum2", null);
            System.out.println(getNum2.invoke(o,null));

            Method setNum1 = myClass.getMethod("setNum1", double.class);
            setNum1.invoke(o,6);

            Method setNum2 = myClass.getMethod("setNum2", double.class);
            setNum2.invoke(o,12);

            Method getNum3 = myClass.getMethod("getNum1", null);
            System.out.println(getNum3.invoke(o,null));

            Method getNum4 = myClass.getMethod("getNum2", null);
            System.out.println(getNum4.invoke(o,null));

            Method sum = myClass.getMethod("sum", double.class, double.class);
            System.out.println(sum.invoke(o,20,30));


        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
