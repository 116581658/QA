package mytests;

import java.lang.reflect.Constructor;

public class ParameterReflection {
    public static void main(String args[]) throws Exception {
        Class c = Class.forName("MyClass");

        Constructor constructors[] = c.getDeclaredConstructors();
        Object      obj            = null;
        for (Constructor cons : constructors) {
            Class[] params = cons.getParameterTypes();
            if (params.length == 1 && params[0] == int.class) {
                obj = cons.newInstance(10);
                break;
            }
        }
    }
}

class MyClass {
    private int count;

    MyClass(int c) {
        System.out.println("MyClass(int):" + c);
        count = c;
    }

    MyClass() {
        System.out.println("MyClass()");
        count = 0;
    }

    void setCount(int c) {
        System.out.println("setCount(int): " + c);
        count = c;
    }

    int getCount() {
        System.out.println("getCount():" + count);
        return count;
    }

    void showcount() {
        System.out.println("count is " + count);
    }
}
