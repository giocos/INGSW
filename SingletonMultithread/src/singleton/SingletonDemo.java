package singleton;

import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            CloneNotSupportedException
    {
        SingletonMultithreading singletonInstance = SingletonMultithreading.getInstance();
        //Class<SingletonMultithread> clazz = (Class<SingletonMultithread>) Class.forName("singleton.SingletonMultithread");
        //Constructor<SingletonMultithread> constructor = clazz.getDeclaredConstructor(null);
        //constructor.setAccessible(true);
        //SingletonMultithread newInstance = constructor.newInstance(null);
        //SingletonMultithread cloneInstance = (SingletonMultithread) instance.clone();
        System.out.println(singletonInstance == SingletonMultithreading.getInstance());
    }
}
