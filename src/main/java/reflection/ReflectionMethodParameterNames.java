package reflection;


import java.lang.reflect.Method;

public class ReflectionMethodParameterNames {
    public int add(int a, int b) {
        return a + b;
    }

    public void test() throws Throwable {
        Method method = getClass().getDeclaredMethod("add");
        Method[] methods = getClass().getDeclaredMethods();
    }

    public static void main(String[] args) {
    }
}
