package genericReflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.type.WildcardType;

public class GenericReflectionTest {
    public static void main(String [] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            try(Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name (eg..,java.util.Collection): ");
                name = in.next();
            }
        }

        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for (Method m : cl.getDeclaredMethods()) {
                printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printMethod(Method m) {
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print("  ");
        printTypes(m.getTypeParameters(),"<",",",">",true);

        printType(m.getGenericReturnType(),false);
        System.out.print("  ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(),"",",","",false);
        System.out.println(")");
    }

    private static void printClass(Class<?> cl) {
        System.out.println(cl);
        printTypes(cl.getTypeParameters(),"<",",",">",true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.println(" extend ");
            printType(sc,false);
        }
        printTypes(cl.getGenericInterfaces()," implement ",",","",false);
        System.out.println();

    }

    private static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition) {
                printTypes(t.getBounds()," extends "," & ","",false);
            }
        }
        else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            //below 2 line can't compile successfully,need to analysis
            //printTypes(t.getSuperBound()," extends "," & ","",false);
           //printTypes(t.getSuperBound()," super "," & ","",false);
        }
        else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner,false);
                System.out.print(".");
            }
            printType(t.getRawType(),false);
            printTypes(t.getActualTypeArguments(),"<",",",">",false);
        }
        else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(),isDefinition);
            System.out.print("[]");
        }
    }

    private static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extend ") && Arrays.equals(types,new Type[] {Object.class}))
            return;
        if (types.length > 0) {
            System.out.println(pre);
        }
        for (int i = 0;i < types.length;i++) {
            if (i > 0) {
                System.out.print(sep);
                printType(types[i],isDefinition);
            }
            if (types.length > 0 ) {
                System.out.print(suf);
            }
        }
    }
}
