package singleton;

import java.io.Serializable;

public final class SingletonMultithreading implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private static volatile SingletonMultithreading instance;

    private SingletonMultithreading() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
        System.out.println("Singleton instance created");
    }

    public static SingletonMultithreading getInstance() {
        if (instance == null) {
            synchronized (SingletonMultithreading.class) {
                if (instance == null) {
                    instance = new SingletonMultithreading();
                }
            }
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.err.println("Cannot clone singleton instance");
        throw new CloneNotSupportedException();
    }
}
