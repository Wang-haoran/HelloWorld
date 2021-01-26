package com.example.lib;

public class Pair <T>{
    private T first;
    private T second;

    public  Pair() {first = null;second = null;}
    public Pair(T first,T second) {this.first = first;this.second = second;}

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}
/*
interface Task
{
    void run() throws Exception;

    @SuppressWarnings("unchecked")
    static <T extends Throwable> void ThrowAs (Throwable t) throws T
    {
        throw (T) t;
    }

    static Runnable asRunable(Task task)
    {
        return () ->
        {
            try {
                task.run();
            }
            catch (Exception e) {
                Task.<RuntimeException>ThrowAs(e);
            }
        };
    }
}
*/
