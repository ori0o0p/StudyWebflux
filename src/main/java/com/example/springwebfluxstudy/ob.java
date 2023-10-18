package com.example.springwebfluxstudy;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ob {

    static class Intob extends Observable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i<= 10; i++) {
                setChanged();
                notifyObservers(i);
            }
        }
    }
    public static void main(String[] args) {
        // push
        Observer ob = (o, arg) -> System.out.println(arg);

        Intob io = new Intob();
        io.addObserver(ob);
        io.run();

        // pull
        Iterable<Integer> iter = () ->
                new Iterator<>() {
                    int i = 0;
                    static final int MAX = 10;
                    @Override
                    public boolean hasNext() {
                        return i < MAX;
                    }
                    @Override
                    public Integer next() {
                        return ++i;
                    }
        };

        for (Integer i : iter) { // Iterable은 for-each에 포함될 수 있다.
            System.out.println(i);
        }

        for (Iterator<Integer> it = iter.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

    }
}
