package ua.ruban.part2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {


    private static final int MAX_ELEMENTS = 10_000;

    public static void main(String[] args) {
        int k=4;
        List<Object> arrayList = init(new ArrayList<>());
        List<Object> linkedList = init(new LinkedList<>());

        System.out.println("ArrayList#Index: ".
                concat(String.valueOf(removeByIndex(arrayList,k))).concat(" ms"));
        System.out.println("LinkedList#Index: ".
                concat(String.valueOf(removeByIndex(linkedList,k))).concat(" ms"));

        arrayList = init(new ArrayList<>());
        linkedList = init(new LinkedList<>());
        System.out.println("ArrayList#Iterator: ".
                concat(String.valueOf(removeByIterator(arrayList,k))).concat(" ms"));
        System.out.println("LinkedList#Iterator: ".
                concat(String.valueOf(removeByIterator(linkedList,k))).concat(" ms"));
    }

    private static long removeByIndex(List<?> list, int k) {
        long startTime = System.currentTimeMillis();
        int t=0;
        int index=0;
        while (list.size()!=1){
            if ((t == k)||(list.size()<k)){
                index = index+t;
                if (index>list.size()){
                    index = index-list.size();
                }
                index--;
                list.remove(index);
                t=1;
            }
            t++;
        }
        return (System.currentTimeMillis() - startTime);
    }

    private static long removeByIterator(List<?> list, int k) {
        long startTime = System.currentTimeMillis();
        int u = k;
        int t = 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            it.next();
            t++;
            if (t == u) {
                it.remove();
                u = t;
                t = 0;
            }
            if (!it.hasNext()) {
                it = list.iterator();
            }
            if (list.size() == 1) {
                break;
            }
        }
        return (System.currentTimeMillis() - startTime);
    }

    private static List<Object> init(List<Object> list) {
        for (int i=0; i<MAX_ELEMENTS; i++){
            SecureRandom r = new SecureRandom();
            int tt = r.nextInt(MAX_ELEMENTS);
            list.add(tt);
        }
        return list;
    }
}
