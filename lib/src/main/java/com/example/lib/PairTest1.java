package com.example.lib;

public class PairTest1 {
    public static <E> void printArray(E [] intArray) {
        for (E element : intArray) {
            System.out.printf("%s ",element);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer [] intArray = {1,2,3,4,5};
        Double [] doubleArray = {1.1,2.2,3.3,4.4,5.5};
        Character [] charArray = {'H','E','L','L','O'};

        System.out.println("int array is:");
        printArray(intArray);

        System.out.println("Double array is:");
        printArray(doubleArray);

        System.out.println("Char array is:");
        printArray(charArray);

        /*
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        Cache<String> cache1 = new Cache<String>();
        cache1.setValue("hello world");
        String value2 = cache1.getValue();

        Cache<Integer> cache2 = new Cache<>();
        cache2.setValue(1234);
        Integer value3 = cache2.getValue();
        */
    }
}

/*
class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a ==null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1;i < a.length;i++) {
            if (min.compareTo(a[i])>0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }
}
*/
