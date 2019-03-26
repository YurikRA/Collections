package ua.ruban.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable {

    private int n;
    private int m;

    private boolean flag;

    Range(int n, int m) {
        this.n = n;
        this.m = m;
        this.flag = false;

    }

    public class OB implements Iterator {

        private int count;
        private int all = m-n+1;
        private int [] mass = createM();

        private int[] createM(){
            count=0;
            int[] massM = new int[all];
            for (int i=0; i<all; i++){
                massM[i] = n+i;
            }
            return massM;
        }

        @Override
        public boolean hasNext() {
            return (count != all);
        }

        @Override
        public Integer next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int t = mass[count];
            count++;
            return t;
        }
    }

    Range(int n, int m, boolean reverse){
        this.n = n;
        this.m = m;
        if (!reverse){
            new Range(n , m);
        }else {
            this.flag = true;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        if (!flag){
            return new OB();
        }else {
            return new OS();
        }
    }

    private class OS implements Iterator {

        private int count;
        private int all = m-n+1;
        private int k;
        private int [] mass = createM();

        private int[] createM(){
            count=all;
            int[] massT = new int[all];
            for (int i=0; i<all; i++){
                massT[i] = m-i;
            }
            return massT;
        }

        @Override
        public boolean hasNext() {
            return (count != 0);
        }
        @Override
        public Integer next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int to = mass[k];
            k++;
            count--;
            return to;
        }
    }
}
