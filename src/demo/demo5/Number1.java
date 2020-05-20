package demo.demo5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Number1 {

    Random random = new Random();

    // a) Implémentez ce programme en utilisant un ArrayList
    public ArrayList genererArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }


    // b) Implémentez ce programme en utilisant votre ListeChainee
    public ListeChainee<Integer> genererListeChainee(int n) {
        ListeChainee<Integer> list = new ListeChainee<>();

        for(int i=0; i < n; i++) {
//            list.addLast(random.nextInt(100));
            list.addFirst(random.nextInt(100));
        }
        return list;
    }


    // c) Implémentez ce programme en utilisant une LinkedList de Java
    public LinkedList<Integer> genererLinkedList(int n) {
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }
}
