package demo.demo5;

public class Number2 {

    public static void main(String args[]) {
        System.out.println("ArrayList--------");
        bmArrayList(5000);
        System.out.println("LinkedList--------");
        bmLinkedList(5000);
        System.out.println("ListeChainee--------");
        bmListeChainee(5000);
    }



    static Number1 number1 = new Number1();

    public static void bmArrayList(int n) {
        long time = System.nanoTime();
        number1.genererArrayList(n);
        long deltaTime = System.nanoTime() - time;
        System.out.println(deltaTime);
    }

    public static void bmLinkedList(int n) {
        long time = System.nanoTime();
        number1.genererLinkedList(n);
        long deltaTime = System.nanoTime() - time;
        System.out.println(deltaTime);
    }

    public static void bmListeChainee(int n) {
        long time = System.nanoTime();
        number1.genererListeChainee(n);
        long deltaTime = System.nanoTime() - time;
        System.out.println(deltaTime);
    }


}
