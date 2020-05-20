package demo.demo5;

public class ListeChainee<E> {
    public Noeud<E> premier;

    public ListeChainee() {
        this.premier = null;
    }

    void addFirst(E element) {
        if(this.premier == null) {
            this.premier = new Noeud<E>(element);
        } else {
            Noeud<E> n = new Noeud<E>(element);
            n.prochain = this.premier;
            this.premier = n;
        }
    }

    void addLast(E element) {
        if(this.premier == null) {
            this.premier = new Noeud<E>(element);
        } else {
            Noeud<E> n = new Noeud<E>(element);
            Noeud<E> temp = this.premier;

            while(temp.prochain != null) {
                temp = temp.prochain;
            }

            temp.prochain = n;
        }
    }

    E get(int index) {
        Noeud<E> temp = this.premier;

        while(temp.valeur != null && index != 0 ) {
            temp = temp.prochain;
            index--;
        }
        return temp.valeur;

    }

    void set(int index, E element) {
        Noeud<E> temp = this.premier;

        while(temp.valeur != null && index != 0 ) {
            temp = temp.prochain;
            index--;
        }
        temp.valeur = element;
    }

    int size() {
        Noeud<E> temp = this.premier;
        int count = 0;
        while(temp != null) {
            temp = temp.prochain;
            count++;
        }
        return count;
    }
}
