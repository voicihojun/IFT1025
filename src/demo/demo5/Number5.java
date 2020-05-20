package demo.demo5;

import java.util.Stack;

public class Number5<E> {
    Stack<E> addStack = new Stack<>();
    Stack<E> popStack = new Stack<>();

    public void ajouter(E element) {
        if(addStack == null) {
            for(int i=0; i < popStack.size(); i++) {
                addStack.add(popStack.pop());
            }
        }
        addStack.add(element);
    }

    public E retirer() {
        if(popStack == null) {
            for(int i=0; i < addStack.size(); i++) {
                popStack.add(addStack.pop());
            }
        }
        return popStack.pop();
    }
}
