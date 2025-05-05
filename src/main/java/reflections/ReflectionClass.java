package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ReflectionClass {

    // Uso delle reflection
    public static void main(String[] args) throws ClassNotFoundException {

        // Ottenere info sulla classe
        Class<?> testClass = Number.class; // oppure Test.class.getClass();
        testClass.getName();
        System.out.println("Nome classe: " + testClass.getName());
        testClass.getSimpleName();
        System.out.println("Nome semplice classe: " + testClass.getSimpleName());
        testClass.getPackage();
        System.out.println("Nome package intero: " + testClass.getPackage().getName());
        testClass.getInterfaces();
        System.out.println("Nome interfaces: " + testClass.getInterfaces());

        testClass.getSuperclass();
        System.out.println("Nome superclasse: " + testClass.getSuperclass().getName());
        testClass.getEnclosingClass();
        System.out.println("Nome classe esterna: " + testClass.getEnclosingClass());

        testClass.getDeclaredClasses();
        System.out.println("Nome classi: " + testClass.getDeclaredClasses());
        testClass.getAnnotations();
        System.out.println("Nome annotazioni: " + testClass.getAnnotations());


        // Ottenere info sui metodi
        System.out.println("\n========================\n");
        try {
            Class<?> clazz = Class.forName("java.lang.String");

            // Ottenere tutti i metodi pubblici di String, inclusi quelli ereditati
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println("Metodo: " + method.getName());
            }

            // Ottenere solo i metodi dichiarati nella classe String
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println("Metodo dichiarato: " + method.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Ottenere info sui campi
        System.out.println("\n========================\n");
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");

            // Ottenere tutti i campi pubblici
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println("Campo pubblico: " + field.getName());
            }

            // Ottenere tutti i campi dichiarati (inclusi quelli privati)
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println("Campo dichiarato: " + field.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Ottenere info sui costruttori
        System.out.println("\n========================\n");
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");

            // Ottenere tutti i costruttori pubblici
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Costruttore pubblico: " + constructor);
            }

            // Ottenere tutti i costruttori dichiarati
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                System.out.println("Costruttore dichiarato: " + constructor);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Ottenere info sui modificatori
        System.out.println("\n========================\n");
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");

            // Ottenere i modificatori della classe
            int modifiers = clazz.getModifiers();
            System.out.println("Modificatori classe: " + modifiers);

            // Ottenere i modificatori di un metodo
            Method method = clazz.getMethod("add", Object.class);
            int methodModifiers = method.getModifiers();
            System.out.println("Modificatori metodo: " + methodModifiers);

            // Ottenere i modificatori di un campo
            Field field = clazz.getDeclaredField("size");
            int fieldModifiers = field.getModifiers();
            System.out.println("Modificatori campo: " + fieldModifiers);

        } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Accesso a metodi privati
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Method substring = clazz.getMethod("substring", int.class, int.class);

            // Invocare il metodo substring su una stringa
            String str = "Hello, World!";
            String result = (String) substring.invoke(str, 7, 12);

            // Invocazione metodi statici
            Method staticMethod = clazz.getMethod("valueOf", int.class);
            String staticResult = (String) staticMethod.invoke(null, 42); // null per i metodi statici

            System.out.println("Risultato: " + result);  // Output: World
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Accesso a campi privati
        try {
            Class<?> clazz = Class.forName("java.awt.Point");
            Field field = clazz.getDeclaredField("x");

            // Creare un oggetto Point
            Object point = clazz.newInstance();

            // Modificare il valore del campo 'x'
            field.setAccessible(true);  // Necessario se il campo è privato
            field.set(point, 42); // Impostare il valore di 'x' a 42

            // Leggere il valore del campo 'x'
            int xValue = (int) field.get(point);
            System.out.println("Valore x: " + xValue);  // Output: 42

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creare oggetti dinamicamente
        try {
            // Ottenere il costruttore della classe Point
            Class<?> clazz = Class.forName("java.awt.Point");
            Constructor<?> constructor = clazz.getConstructor(int.class, int.class);

            // Creare un'istanza di Point passando i parametri al costruttore
            Object point = constructor.newInstance(10, 20);

            System.out.println("Istanza creata: " + point);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}